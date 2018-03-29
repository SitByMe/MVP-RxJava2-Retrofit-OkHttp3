package ptv.zohar.mvpdemo.http.httpMethods;

import io.reactivex.Observer;
import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.http.HttpCore;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class MovieHttpMethods extends BaseHttpMethods {

    /**
     * 用于获取豆瓣电影Top250的数据
     *
     * @param observer 由调用者传过来的观察者对象
     * @param start    起始位置
     * @param count    获取长度
     */
    public static void getTopMovie(Observer<Movie> observer, int start, int count) {
        httpSubscribe(HttpCore.getMovieService().getTopMovie(start, count), observer);
    }
}