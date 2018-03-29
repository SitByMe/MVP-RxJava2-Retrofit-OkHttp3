package ptv.zohar.mvpdemo.mvp.model;

import android.content.Context;

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
     * 登录
     *
     * @param start          起始index
     * @param count          总数
     * @param resultListener 回调接口
     */
    public void getTopMovie(int start, int count, ObserverOnNextListener resultListener) {
        MovieHttpMethods.getTopMovie(new MyObserver<Movie>(context, resultListener), start, count);
    }
}
