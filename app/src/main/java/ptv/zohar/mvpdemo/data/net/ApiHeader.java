package ptv.zohar.mvpdemo.data.net;

public class ApiHeader {
    private PublicApiHeader publicApiHeader;
    private ProtectedApiHeader protectedApiHeader;

    public ApiHeader(PublicApiHeader publicApiHeader, ProtectedApiHeader protectedApiHeader) {
        this.publicApiHeader = publicApiHeader;
        this.protectedApiHeader = protectedApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return publicApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return protectedApiHeader;
    }

    public static class PublicApiHeader {
        private String apiKey;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
    }

    public static class ProtectedApiHeader {
        private String apiKey;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
    }
}
