package ptv.zohar.mvpdemo.mvp.presenter;

import ptv.zohar.mvpdemo.mvp.model.BaseModel;
import ptv.zohar.mvpdemo.mvp.view.BaseView;

/**
 * Created by Zohar on 2018/1/24.
 * desc:
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    private V mView;
    private M mModel;

    public void attachView(V view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
        this.mModel = null;
    }

    public V getView() {
        return mView;
    }

    void setModel(M mModel) {
        this.mModel = mModel;
    }

    M getModel() {
        return mModel;
    }
}