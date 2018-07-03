package ptv.zohar.mvpdemo.activity;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ptv.zohar.mvpdemo.R;
import ptv.zohar.mvpdemo.mvp.presenter.BasePresenter;

/**
 * Created by Zohar on 2018/1/22.
 * desc: 基类Activity
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public Context mContext = this;

    protected P presenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detachView();
        presenter = null;
    }

    public Dialog loadingDialog;

    public void showLoadingView() {
        if (loadingDialog == null) {
            View vi = getLayoutInflater().inflate(R.layout.loading_dialog, null);
            loadingDialog = new Dialog(this, R.style.loading_dialog);
            loadingDialog.setCanceledOnTouchOutside(false);
            loadingDialog.setContentView(vi);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    public void dismissLoadingView() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }
}
