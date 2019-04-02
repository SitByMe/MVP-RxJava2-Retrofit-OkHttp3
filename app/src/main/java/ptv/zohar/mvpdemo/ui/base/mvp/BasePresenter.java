package ptv.zohar.mvpdemo.ui.base.mvp;

/**
 * Created by lhZou on 2018/1/24.
 * desc:
 */
public abstract class BasePresenter<V extends BaseView, M extends DataManager> implements IBasePresenter<V> {
    private V mView;
    private M mModel;

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        this.mModel = null;
    }

    public V getView() {
        return mView;
    }

    protected void setModel(M mModel) {
        this.mModel = mModel;
    }

    protected M getModel() {
        return mModel;
    }

    @Override
    public boolean hasLogin() {
        return true;
    }

    @Override
    public void logout() {
    }
}