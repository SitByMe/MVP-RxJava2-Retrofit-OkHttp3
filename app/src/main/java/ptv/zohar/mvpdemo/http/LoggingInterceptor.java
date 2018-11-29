package ptv.zohar.mvpdemo.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by lhZou on 2018/5/16.
 * desc:
 */
public class LoggingInterceptor implements Interceptor {
    private String TAG = "MVP_demo";

    @Override
    public Response intercept(Chain chain) throws IOException {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        Request request = chain.request();
        long t1 = System.nanoTime();//请求发起的时间

        String method = request.method();
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < (body != null ? body.size() : 0); i++) {
                    sb.append(body.encodedName(i)).append("=").append(body.encodedValue(i)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                Log.i(TAG, String.format("发送请求 %s on %s %n%s %nRequestParams:{%s}",
                        request.url(), chain.connection(), request.headers(), sb.toString()));
            }
        } else {
            Log.i(TAG, String.format("发送请求 %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));
        }
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();//收到响应的时间
        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        Log.i(TAG, String.format("%.1fms %n%s", (t2 - t1) / 1e6d, response.headers()));
        Log.i(TAG, String.format("接收响应: %s", response.request().url()));
        Log.i(TAG, String.format("返回json:【%s】", responseBody.string()));
        return response;
    }
}