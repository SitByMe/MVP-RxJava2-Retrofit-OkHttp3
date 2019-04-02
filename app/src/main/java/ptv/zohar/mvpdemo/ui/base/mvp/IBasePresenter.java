package ptv.zohar.mvpdemo.ui.base.mvp;

public interface IBasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

    boolean hasLogin();

    void logout();
}
