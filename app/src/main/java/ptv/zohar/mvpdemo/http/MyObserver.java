package ptv.zohar.mvpdemo.http;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ptv.zohar.mvpdemo.utils.LogUtils;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class MyObserver<T> implements Observer<T>, ProgressCancelListener {
    private static final String TAG = "ProgressObserver";
    private ObserverOnNextListener<T> listener;
    private Disposable d;

    public MyObserver(ObserverOnNextListener<T> listener) {
        this.listener = listener;
    }

    public MyObserver(Context context, ObserverOnNextListener<T> listener) {
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
        LogUtils.i(TAG, "onError: " + e.toString());
        if (listener != null) listener.onError(e);
    }

    @Override
    public void onComplete() {
        LogUtils.i(TAG, "onComplete: ");
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
