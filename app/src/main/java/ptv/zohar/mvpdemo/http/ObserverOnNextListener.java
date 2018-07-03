package ptv.zohar.mvpdemo.http;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public interface ObserverOnNextListener<T> {
    void onCompleted();

    void onError(Throwable e);

    void onNext(T result);
}
