package ptv.zohar.mvpdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lhZou on 2018/1/22.
 */
public class SharedPreferencesUtils {

    private static SharedPreferences sp;

    private static final String PREFERENCES_FILE_NAME = "NGY_SP";

    private static SharedPreferences getSp(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp;
    }

    /**
     * 移除指定key的数据
     *
     * @param context 上下文
     * @param key     键
     */
    public static void remove(Context context, String key) {
        SharedPreferences preferences = getSp(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 存入字符串
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences preferences = getSp(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * 获取字符串
     *
     * @param context 上下文
     * @param key     键
     * @return 得到的字符串
     */
    public static String getString(Context context, String key) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, "");
    }

    /**
     * 获取字符串
     *
     * @param context  上下文
     * @param key      键
     * @param defValue 默认值
     * @return 得到的字符串
     */
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, defValue);
    }

    /**
     * 保存布尔值
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * 获取布尔值
     *
     * @param context  上下文
     * @param key      键
     * @param defValue 默认值
     * @return 返回保存的值
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getBoolean(key, defValue);
    }

    /**
     * 保存long值
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    public static void putLong(Context context, String key, long value) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * 获取long值
     *
     * @param context  上下文
     * @param key      键
     * @param defValue 默认值
     * @return 保存的值
     */
    public static long getLong(Context context, String key, long defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getLong(key, defValue);
    }

    /**
     * 保存int值
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * 获取int值
     *
     * @param context  上下文
     * @param key      键
     * @param defValue 默认值
     * @return 保存的值
     */
    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getInt(key, defValue);
    }

    /**
     * 保存对象
     *
     * @param context 上下文
     * @param key     键
     * @param obj     要保存的对象（Serializable的子类）
     * @param <T>     泛型定义
     */
    public static <T extends Serializable> void putObject(Context context, String key, T obj) {
        try {
            put(context, key, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象
     *
     * @param context 上下文
     * @param key     键
     * @param <T>     指定泛型
     * @return 泛型对象
     */
    public static <T extends Serializable> T getObject(Context context, String key) {
        try {
            return (T) get(context, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储List集合
     *
     * @param context 上下文
     * @param key     存储的键
     * @param list    存储的集合
     */
    public static void putList(Context context, String key, List<? extends Serializable> list) {
        try {
            put(context, key, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取List集合
     *
     * @param context 上下文
     * @param key     键
     * @param <E>     指定泛型
     * @return List集合
     */
    public static <E extends Serializable> List<E> getList(Context context, String key) {
        try {
            return (List<E>) get(context, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储Map集合
     *
     * @param context 上下文
     * @param key     键
     * @param map     存储的集合
     * @param <K>     指定Map的键类型
     * @param <V>     指定Map的值类型
     */
    public static <K extends Serializable, V extends Serializable> void putMap(Context context, String key, Map<K, V> map) {
        try {
            put(context, key, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Map集合
     *
     * @param context 上下文
     * @param key     键
     * @param <K>     Map的键类型
     * @param <V>     Map的值类型
     * @return Map集合
     */
    public static <K extends Serializable, V extends Serializable> Map<K, V> getMap(Context context, String key) {
        try {
            return (Map<K, V>) get(context, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储Set集合
     *
     * @param context 上下文
     * @param key     键
     * @param set     set数据
     */
    public static void putSet(Context context, String key, Set<? extends Serializable> set) {
        try {
            put(context, key, set);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Set集合
     *
     * @param context 上下文
     * @param key     键
     * @param <E>     指定泛型
     * @return Set集合
     */
    public static <E extends Serializable> Set<E> getSet(Context context, String key) {
        try {
            return (Set<E>) get(context, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储对象
     *
     * @param context 上下文
     * @param key     键
     * @param obj     对象
     * @throws IOException
     */
    private static void put(Context context, String key, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        // 将对象放到OutputStream中
        // 将对象转换成byte数组，并将其进行base64编码
        String objectStr = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
        baos.close();
        oos.close();

        putString(context, key, objectStr);
    }

    /**
     * 获取对象
     *
     * @param context 上下文
     * @param key     键
     * @return 对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Object get(Context context, String key)
            throws IOException, ClassNotFoundException {
        String wordBase64 = getString(context, key);
        // 将base64格式字符串还原成byte数组
        if (TextUtils.isEmpty(wordBase64)) { //不可少，否则在下面会报java.io.StreamCorruptedException异常
            return null;
        }
        byte[] objBytes = Base64.decode(wordBase64.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(objBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        // 将byte数组转换成product对象
        Object obj = ois.readObject();
        bais.close();
        ois.close();
        return obj;
    }
}
