package ptv.zohar.mvpdemo.ui.base.mvp;

/**
 * Created by lhZou on 2018/1/24.
 * desc:
 */
public abstract class BasePresenter<V extends BaseView, M extends DataManager> {
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

    public void setModel(M mModel) {
        this.mModel = mModel;
    }

    public M getModel() {
        return mModel;
    }
}