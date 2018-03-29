package ptv.zohar.mvpdemo.mvp.presenter;

import android.content.Context;

import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.http.ObserverOnNextListener;
import ptv.zohar.mvpdemo.mvp.model.MovieModel;
import ptv.zohar.mvpdemo.mvp.view.MovieView;

/**
 * Created by Zohar on 2018/1/23.
 * desc:
 */
public class MoviePresenter extends BasePresenter<MovieView> {
    private MovieModel model;
    private MovieView view;

    public MoviePresenter(MovieView view, Context context) {
        this.view = view;
        this.model = new MovieModel(context);
    }

    public void getTopMovie(int start, int count) {
        this.model.getTopMovie(start, count, new ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie movie) {
                view.onLoginResult(movie);
            }
        });
    }
}