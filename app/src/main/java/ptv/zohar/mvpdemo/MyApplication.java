package ptv.zohar.mvpdemo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lhZou on 2018/3/29.
 * desc:
 */
public class MyApplication extends Application {
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        application = this;
    }

    public static Context getContext() {
        return application;
    }
}