package ptv.zohar.mvpdemo.mvp.presenter;

import android.content.Context;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.http.ObserverOnNextListener;
import ptv.zohar.mvpdemo.mvp.model.MovieModel;
import ptv.zohar.mvpdemo.mvp.view.MovieView;

/**
 * Created by Zohar on 2018/1/23.
 * desc:
 */
public class MoviePresenter extends BasePresenter<MovieView> {
    private Context mContext;
    private MovieModel model;

    public MoviePresenter(Context context) {
        this.mContext = context;
        this.model = new MovieModel(context);
    }

    public void requestTopMovie(int start, int count) {
        this.model.getTopMovie(start, count, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) {
                getView().showLoadingView();
            }
        }, new Action() {
            @Override
            public void run() {
                getView().dismissLoadingView();
            }
        }, new ObserverOnNextListener<Movie>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Movie movie) {
                getView().showTopMovie(movie);
            }
        });
    }
}