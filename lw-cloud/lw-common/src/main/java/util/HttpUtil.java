package util;


import enums.Constant;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.codec.Charsets;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

@Slf4j
public final class HttpUtil {

    private static final MediaType CONTENT_TYPE_FORM = MediaType.parse("application/x-www-form-urlencoded");
    private static final MediaType CONTENT_TYPE_JSON = MediaType.parse("application/json");
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36";

    private HttpUtil() {
    }

    public static final String httpClientPost(String url) {
        String result = "";
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        try {
            client.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsString();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            getMethod.releaseConnection();
        }
        return result;
    }

    public static final String httpClientPost(String url, Map<String, Object> header) {
        String result = "";
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        for (Entry<String, Object> entry : header.entrySet()) {
            getMethod.setRequestHeader(entry.getKey(), String.valueOf(entry.getValue()));
        }
        try {
            client.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsString();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            getMethod.releaseConnection();
        }
        return result;
    }

    public static String postJson(String url, String params) {
        String result = "";
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        try {
            RequestEntity se = new StringRequestEntity(params, "application/json", "UTF-8");
            postMethod.setRequestEntity(se);
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            client.executeMethod(postMethod);
            result = postMethod.getResponseBodyAsString();
        } catch (Exception e) {
            log.error("url = " + url + ", params = " + params + ", error = " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static final String httpClientPost(String url, ArrayList<NameValuePair> list) {
        String result = "";
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        try {
            NameValuePair[] params = new NameValuePair[list.size()];
            for (int i = 0; i < list.size(); i++) {
                params[i] = list.get(i);
            }
            postMethod.addParameters(params);
            client.executeMethod(postMethod);
            result = postMethod.getResponseBodyAsString();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            postMethod.releaseConnection();
        }
        return result;
    }

    public static String postXml(String url, String params) {
        RequestBody body = RequestBody.create(CONTENT_TYPE_FORM, params);
        Request request = new Request.Builder().url(url).post(body).build();
        return exec(request);
    }

    public static String postByJson(String url, String jsonStr) {
        RequestBody body = RequestBody.create(CONTENT_TYPE_JSON, jsonStr);
        Request request = new Request.Builder().url(url).post(body).build();
        return exec(request);
    }

    public static String postByJson(String url, String jsonStr, Map<String, Object> headers) {
        RequestBody body = RequestBody.create(CONTENT_TYPE_JSON, jsonStr);
        Request.Builder builder = new Request.Builder().url(url).post(body);
        for (Entry<String, Object> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue().toString());
        }
        Request request = builder.build();
        return exec(request);
    }

    private static String exec(okhttp3.Request request) {

        try {
            okhttp3.Response response = new OkHttpClient().newCall(request).execute();
            if (!response.isSuccessful()) {
                log.error("请求错误！");
            } else {
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String postSSL(String url, String data, String certPath, String certPass) {
        HttpsURLConnection conn = null;
        OutputStream out = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            KeyStore clientStore = KeyStore.getInstance("PKCS12");
            clientStore.load(new FileInputStream(certPath), certPass.toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(clientStore, certPass.toCharArray());
            KeyManager[] kms = kmf.getKeyManagers();
            SSLContext sslContext = SSLContext.getInstance("TLSv1");

            sslContext.init(kms, null, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            URL _url = new URL(url);
            conn = (HttpsURLConnection) _url.openConnection();

            conn.setConnectTimeout(25000);
            conn.setReadTimeout(25000);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("User-Agent", DEFAULT_USER_AGENT);
            conn.connect();

            out = conn.getOutputStream();
            out.write(data.getBytes(Charsets.toCharset("UTF-8")));
            out.flush();

            inputStream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charsets.toCharset("UTF-8")));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(inputStream);
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * URL连接是否可用
     *
     * @param urlAddress
     * @return
     */
    public static boolean isValidUrl(String urlAddress) {
        if (urlAddress.startsWith(Constant.HTTP_PROTOCOL)) {
            HttpURLConnection httpUrl = null;
            URL url = null;
            try {
                //建立链接
                url = new URL(urlAddress);
                httpUrl = (HttpURLConnection) url.openConnection();
                //连接指定的资源
                httpUrl.connect();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else if (urlAddress.startsWith(Constant.HTTPS_PROTOCOL)) {
            HttpsURLConnection httpUrl = null;
            URL url = null;
            try {
                //建立链接
                url = new URL(urlAddress);
                httpUrl = (HttpsURLConnection) url.openConnection();
                //连接指定的资源
                httpUrl.connect();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
