package ptv.zohar.mvpdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Zohar on 2018/1/22.
 */
public class StartActivityUtils {

    /**
     * 跳转源生界面
     *
     * @param context 上下文
     * @param cls     泛型
     */
    public static void startActivity(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
    }

    /**
     * 跳转源生界面
     *
     * @param context 上下文
     * @param cls     泛型
     * @param bundle  传递参数
     */
    public static void startActivity(Context context, Class<?> cls, Bundle bundle) {
        context.startActivity(new Intent(context, cls).putExtras(bundle));
    }
}
