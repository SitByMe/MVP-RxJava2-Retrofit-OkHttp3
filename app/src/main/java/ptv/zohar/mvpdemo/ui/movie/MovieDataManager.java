package ptv.zohar.mvpdemo.ui.movie;

import android.content.Context;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ptv.zohar.mvpdemo.ui.base.mvp.AppDataManager;
import ptv.zohar.mvpdemo.data.db.DbHelper;
import ptv.zohar.mvpdemo.data.net.ApiHeader;
import ptv.zohar.mvpdemo.data.net.ApiHelper;
import ptv.zohar.mvpdemo.data.net.AppApiHelper;
import ptv.zohar.mvpdemo.data.net.http.MyObserver;
import ptv.zohar.mvpdemo.data.net.http.ObserverOnNextListener;
import ptv.zohar.mvpdemo.data.net.http.httpMethods.MovieHttpMethods;
import ptv.zohar.mvpdemo.data.sp.SpHelper;
import ptv.zohar.mvpdemo.entity.Movie;

class MovieDataManager extends AppDataManager {

    MovieDataManager(Context mContext, DbHelper mDbHelper, ApiHelper mApiHelper, SpHelper mSpHelper) {
        super(mContext, mDbHelper, mApiHelper, mSpHelper);
    }

    static class MovieApiHelper extends AppApiHelper {

        MovieApiHelper(ApiHeader mApiHeader) {
            super(mApiHeader);
        }

        void getTopMovie(int start, int count, Consumer<Disposable> before, ObserverOnNextListener<Movie> resultListener) {
            MovieHttpMethods.getTopMovie(start, count, before, new MyObserver<>(resultListener));
        }
    }
}
