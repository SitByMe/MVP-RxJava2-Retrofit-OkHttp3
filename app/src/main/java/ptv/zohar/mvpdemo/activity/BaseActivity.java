package ptv.zohar.mvpdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Zohar on 2018/1/22.
 * desc: 基类Activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext = this;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
