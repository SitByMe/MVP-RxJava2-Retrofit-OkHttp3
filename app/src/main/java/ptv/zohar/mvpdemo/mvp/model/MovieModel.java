package ptv.zohar.mvpdemo.mvp.model;

import android.content.Context;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.http.httpMethods.MovieHttpMethods;
import ptv.zohar.mvpdemo.http.MyObserver;
import ptv.zohar.mvpdemo.http.ObserverOnNextListener;

/**
 * Created by Zohar on 2018/1/23.
 * desc:
 */
public class MovieModel extends BaseModel {
    private Context context;

    public MovieModel(Context context) {
        this.context = context;
    }

    /**
     * 请求热门电影列表
     *
     * @param start          起始index
     * @param count          总数
     * @param resultListener 回调接口
     */
    public void getTopMovie(int start, int count, Consumer<Disposable> before, Action after, ObserverOnNextListener<Movie> resultListener) {
        MovieHttpMethods.getTopMovie(start, count, before, after, new MyObserver<>(context, resultListener));
    }
}
