package ptv.zohar.mvpdemo.data.net;

public class AppApiHelper implements ApiHelper {
    private ApiHeader mApiHeader;

    public AppApiHelper(ApiHeader mApiHeader) {
        this.mApiHeader = mApiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
