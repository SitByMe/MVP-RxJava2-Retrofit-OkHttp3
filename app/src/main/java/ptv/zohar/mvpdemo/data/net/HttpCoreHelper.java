package ptv.zohar.mvpdemo.data.net;

import module.zohar.prt.net.http.HttpCore;
import ptv.zohar.mvpdemo.BuildConfig;

public class HttpCoreHelper extends HttpCore {

    public static <S> S getService(Class<S> iServer) {
        return HttpCore.getService(iServer, BuildConfig.API_HOST);
    }
}
