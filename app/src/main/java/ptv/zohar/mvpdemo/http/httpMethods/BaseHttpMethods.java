package ptv.zohar.mvpdemo.http.httpMethods;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
}