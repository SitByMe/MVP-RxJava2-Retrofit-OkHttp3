package ptv.zohar.mvpdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class MyApplication extends Application {
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Context getContext() {
        return application;
    }
}