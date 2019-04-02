package ptv.zohar.mvpdemo.ui.movie;

import android.content.Context;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import module.zohar.prt.net.http.ObserverOnNextListener;
import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.ui.base.mvp.BasePresenter;

/**
 * Created by lhZou on 2018/1/23.
 * desc:
 */
public class MoviePresenter extends BasePresenter<MovieView, MovieDataManager> {
    private Context mContext;

    MoviePresenter(Context mContext) {
        this.mContext = mContext;
        setModel(new MovieDataManager(mContext, null, new MovieDataManager.MovieApiHelper(null), null));
    }

    public void requestTopMovie(int start, int count) {
        getModel().getApiHelper(MovieDataManager.MovieApiHelper.class).getTopMovie(start, count,
                new Consumer<Disposable>() {
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