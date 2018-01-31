package ptv.zohar.mvpdemo.mvp.presenter;

import ptv.zohar.mvpdemo.http.HttpUtils;
import ptv.zohar.mvpdemo.mvp.model.LoginModel;
import ptv.zohar.mvpdemo.mvp.view.LoginView;

/**
 * Created by Zohar on 2018/1/23.
 * desc:
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginModel model;

    public LoginPresenter() {
        this.model = new LoginModel();
    }

    public void login(String phoneNo, String password, String registerId) {
        this.model.login(phoneNo, password, registerId, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (getView() != null) {
                    getView().onLoginResult(result);
                }
            }
        });
    }
}