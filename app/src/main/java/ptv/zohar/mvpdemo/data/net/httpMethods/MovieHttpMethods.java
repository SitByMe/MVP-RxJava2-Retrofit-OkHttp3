package ptv.zohar.mvpdemo.data.net.httpMethods;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import module.zohar.prt.net.http.BaseHttpMethods;
import ptv.zohar.mvpdemo.data.net.HttpCoreHelper;
import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.data.net.iservices.IMovieService;

/**
 * Created by lhZou on 2018/3/29.
 * desc:
 */
public class MovieHttpMethods extends BaseHttpMethods {

    /**
     * 用于获取豆瓣电影Top250的数据
     *
     * @param start    起始位置
     * @param count    获取长度
     * @param observer Observer with Movie
     */
    public static void getTopMovie(int start, int count, Consumer<Disposable> before, Observer<Movie> observer) {
        httpSubscribe(HttpCoreHelper.getService(IMovieService.class).getTopMovie(start, count), before, observer);
    }
}