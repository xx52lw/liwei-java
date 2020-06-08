package enums;

public interface Constant {


    // 请求token
    String REQUEST_TOKEN = "token";

    public interface PLATFORM {

        String MANAGE = "manage";

        String APP = "app";
    }

    String COLON = ":";

    public interface Cache {

        String TOKEN = "TOKEN";

        String CAPTCHA_TOKEN = "CAPTCHA_TOKEN";

        String ORG_REGISTER = "ORG_REGISTER";

        String ORG_INFO = "ORG_INFO";

        // 小区经纬度
        String VILLAGE_GEO = "VILLAGE_GEO";
    }


    /**
     * HTTP协议
     */
    public static final String HTTP_PROTOCOL = "http://";

    /**
     * HTTPS协议
     */
    public static final String HTTPS_PROTOCOL = "https://";


    public static final String COMMA_SEPARATOR = ",";

}
