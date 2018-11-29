package ptv.zohar.mvpdemo.mvp.presenter;

import android.content.Context;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.http.ObserverOnNextListener;
import ptv.zohar.mvpdemo.mvp.model.MovieModel;
import ptv.zohar.mvpdemo.mvp.view.MovieView;

/**
 * Created by Zohar on 2018/1/23.
 * desc:
 */
public class MoviePresenter extends BasePresenter<MovieView, MovieModel> {
    private Context mContext;

    public MoviePresenter(Context mContext) {
        this.mContext = mContext;
        setModel(new MovieModel());
    }

    public void requestTopMovie(int start, int count) {
        getModel().getTopMovie(start, count, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) {
                getView().showLoadingView();
            }
        }, new ObserverOnNextListener<Movie>() {

            @Override
            public void onCompleted() {
                getView().dismissLoadingView();
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