package ptv.zohar.mvpdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ptv.zohar.mvpdemo.R;
import ptv.zohar.mvpdemo.mvp.presenter.LoginPresenter;
import ptv.zohar.mvpdemo.mvp.view.LoginView;
import ptv.zohar.mvpdemo.utils.ToastUtils;

/**
 * Created by Zohar on 2018/1/22.
 * desc: 登录界面
 */
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.til_username)
    TextInputLayout tilUsername;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter();
        presenter.attachView(this);
    }

    public void goToRegister(View view) {
        Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
    }

    /**
     * 请求登录服务
     *
     * @param view
     */
    public void login(View view) {
        String userName = tilUsername.getEditText().getText().toString();
        String password = tilPassword.getEditText().getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            ToastUtils.showShortToast(this, "账号和密码不能为空");
            return;
        }
        presenter.login(userName, password, "1111");
    }

    @Override
    public void onLoginResult(String result) {
        ToastUtils.showLongToast(this, result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
    }
}