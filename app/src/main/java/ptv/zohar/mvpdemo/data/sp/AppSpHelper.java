package ptv.zohar.mvpdemo.data.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Set;

public class AppSpHelper implements SpHelper {

    private final SharedPreferences sharedPreferences;

    public AppSpHelper(Context context, String spFileName) {
        sharedPreferences = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
    }

    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String getString(String key, @Nullable String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public void putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putFloat(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public float getFloat(String key, float defValue) {
        return sharedPreferences.getFloat(key, defValue);
    }

    public void putLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    public long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public void putStringSet(String key, Set<String> value) {
        sharedPreferences.edit().putStringSet(key, value).apply();
    }

    public Set<String> getStringSet(String key) {
        return sharedPreferences.getStringSet(key, null);
    }
}
