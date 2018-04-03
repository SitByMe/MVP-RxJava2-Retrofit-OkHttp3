package ptv.zohar.mvpdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

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
}
