package ptv.zohar.mvpdemo.mvp.presenter;

import ptv.zohar.mvpdemo.mvp.view.BaseView;

/**
 * Created by Zohar on 2018/1/24.
 * desc:
 */
public abstract class BasePresenter<V extends BaseView> {
    private V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public V getView() {
        return view;
    }
}