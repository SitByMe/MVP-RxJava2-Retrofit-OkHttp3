package ptv.zohar.mvpdemo.ui.base.mvp;

import android.content.Context;

import ptv.zohar.mvpdemo.data.db.DbHelper;
import ptv.zohar.mvpdemo.data.net.ApiHeader;
import ptv.zohar.mvpdemo.data.net.ApiHelper;
import ptv.zohar.mvpdemo.data.sp.SpHelper;

public class AppDataManager implements DataManager {
    private Context mContext;

    private DbHelper mDbHelper;
    private ApiHelper mApiHelper;
    private SpHelper mSpHelper;

    public AppDataManager(Context mContext, DbHelper mDbHelper, ApiHelper mApiHelper, SpHelper mSpHelper) {
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mApiHelper = mApiHelper;
        this.mSpHelper = mSpHelper;
    }

    public <T> T getApiHelper(Class<T> clazz) {
        return (T) mApiHelper;
    }

    @Override
    public void updateApiHeader() {

    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }
}
