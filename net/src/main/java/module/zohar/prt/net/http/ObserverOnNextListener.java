package module.zohar.prt.net.http;

/**
 * Created by lhZou on 2018/3/29.
 * desc:
 */
public interface ObserverOnNextListener<T> {
    void onCompleted();

    void onError(Throwable e);

    void onNext(T result);
}
