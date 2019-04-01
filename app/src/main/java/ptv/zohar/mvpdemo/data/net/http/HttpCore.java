package ptv.zohar.mvpdemo.data.net.http;

import okhttp3.OkHttpClient;
import ptv.zohar.mvpdemo.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class HttpCore {

    private static <S> S createRetrofitForGsonConverter(Class<S> iServer) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new LoggingInterceptor());//使用自定义的Log拦截器
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(iServer);
    }

    public static <S> S getService(Class<S> iServer) {
        return createRetrofitForGsonConverter(iServer);
    }
}