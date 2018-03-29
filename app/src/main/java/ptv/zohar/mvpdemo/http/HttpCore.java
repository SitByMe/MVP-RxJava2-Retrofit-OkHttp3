package ptv.zohar.mvpdemo.http;

import ptv.zohar.mvpdemo.http.iservices.IMovieService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class HttpCore {
    private static String baseUrl = "https://api.douban.com/v2/movie/";

    private static IMovieService movieService;

    private static <T> T createRetrofitForGsonConverter(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

    //单例
    public static IMovieService getMovieService() {
        if (movieService == null) {
            synchronized (HttpCore.class) {
                if (movieService == null) {
                    movieService = createRetrofitForGsonConverter(IMovieService.class);
                }
            }
        }
        return movieService;
    }
}