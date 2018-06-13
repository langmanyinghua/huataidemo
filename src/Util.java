import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * Created by 浪漫樱花 on 2018/6/13.
 */
public class Util {

    /**
     * 获取随机字符串
     *
     * @return
     */
    public static String getNonce() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取时间戳（毫秒）
     *
     * @return
     */
    public static Long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public static String getSign(Map<String, String> map) {
        TreeMap<String, String> treeMap = new TreeMap<>(map);
        StringBuffer expressbuf = new StringBuffer();

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            expressbuf.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        // 添加最后的密钥
        expressbuf.append("appsecret=").append(Constant.APPSECRET);
        return DigestUtils.sha1Hex(expressbuf.toString());
    }

    /**
     * 发送post 请求
     *
     * @param url
     * @param map
     */
    public static JSONObject post(String url, Map<String, String> map) {
        JSONObject jsonObject = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            httpPost.addHeader("token", Constant.TOKEN);
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(uefEntity);
            CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
            HttpEntity entity = response.getEntity();

            jsonObject = JSONObject.parseObject(EntityUtils.toString(entity));
            System.out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
