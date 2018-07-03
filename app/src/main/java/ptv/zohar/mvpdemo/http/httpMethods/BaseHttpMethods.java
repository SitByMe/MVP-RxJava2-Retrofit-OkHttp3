package ptv.zohar.mvpdemo.http.httpMethods;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class BaseHttpMethods {
    /**
     * 封装线程管理和订阅的过程
     */
    public static <T> void httpSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 封装线程管理和订阅的过程
     */
    protected static <T> void httpSubscribe(Observable<T> observable, Consumer<Disposable> before, Action after, Observer<T> observer) {
        if (before == null || after == null) {
            httpSubscribe(observable, observer);
        } else {
            observable.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .doOnSubscribe(before)
                    .doAfterTerminate(after)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
    }
}