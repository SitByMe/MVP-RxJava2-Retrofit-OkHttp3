package module.zohar.prt.net.http;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by lhZou on 2018/3/29.
 * desc:
 */
public class MyObserver<T> implements Observer<T>, ProgressCancelListener {
    private static final String TAG = "ProgressObserver";
    private ObserverOnNextListener<T> listener;
    private Disposable d;

    public MyObserver(ObserverOnNextListener<T> listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
    }

    @Override
    public void onNext(T t) {
        if (listener != null) listener.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (listener != null) listener.onError(e);
    }

    @Override
    public void onComplete() {
        if (listener != null) listener.onCompleted();
    }

    @Override
    public void onCancelProgress() {
        //如果处于订阅状态，则取消订阅
        if (!d.isDisposed()) {
            d.dispose();
        }
    }
}
