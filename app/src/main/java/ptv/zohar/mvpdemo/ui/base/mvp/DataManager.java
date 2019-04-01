package ptv.zohar.mvpdemo.ui.base.mvp;

import ptv.zohar.mvpdemo.data.db.DbHelper;
import ptv.zohar.mvpdemo.data.net.ApiHelper;
import ptv.zohar.mvpdemo.data.sp.SpHelper;

public interface DataManager extends DbHelper, ApiHelper, SpHelper {

    void updateApiHeader();
}
