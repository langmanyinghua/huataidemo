import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Constant.TOKEN = "3b894afd06ed0e15b56936749f825c2b";
        // 自行调用静态方法
        message_send();
    }

    // ******************** 用户 start  ******************** //

    public static void login() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.ACCOUNT_LOGIN);
        map.put("username", "13800000000");
        map.put("password", "123456");
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.ACCOUNT_LOGIN, map);
        Constant.TOKEN = jsonObject.getString("result");

       // checkToken();
    }

    public static void me() {
        // f174dbb9cda80cf180e1f0a27e4b34ea
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.ACCOUNT_ME);
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.ACCOUNT_ME, map);
        System.out.println(jsonObject.toString());

    }

    public static void checkToken() {
        // f174dbb9cda80cf180e1f0a27e4b34ea
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.ACCOUNT_CHECKTOKEN);
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.ACCOUNT_CHECKTOKEN, map);
        System.out.println(jsonObject.toString());

    }

    // ******************** 用户 end  ******************** //


    // ******************** 群组 start  ******************** //

    public static void createGroup() {
        // f174dbb9cda80cf180e1f0a27e4b34ea
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.GROUP_CREATE);
        map.put("friendids", "984384,984392,984393");
        map.put("nickname", "测试一群");
        map.put("robotid", "52");
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.GROUP_CREATE, map);
        System.out.println(jsonObject.toString());

    }

    public static void group_list() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.GROUP_LIST);
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.GROUP_LIST, map);
        System.out.println(jsonObject.toString());
    }

    public static void group_get() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.GROUP_GET);
//        map.put("id", "3178");
        map.put("wxid", "9660005773@chatroom");
        map.put("sign", Util.getSign(map));

        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.GROUP_GET, map);
        System.out.println(jsonObject.toString());
    }

    // ******************** 群组 end  ******************** //

    // ******************** 消息 start  ******************** //
    public static void message_list() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.MESSAGE_LIST);
        map.put("wxid", "9660005773@chatroom");
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.MESSAGE_LIST, map);
        System.out.println(jsonObject.toString());
    }

    public static void message_send() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.MESSAGE_SEND);

        Map<String,Object> message = new HashMap<>();
        message.put("wxid","9660005773@chatroom");
        message.put("messagetype","TXT");
        Map<String,String> body = new HashMap<>();
        body.put("txtcontent","测试，测试");
        message.put("body",body);

        map.put("message", JSON.toJSONString(message));
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.MESSAGE_SEND, map);
        System.out.println(jsonObject.toString());
    }
    // ******************** 消息 end  ******************** //


    // ******************** 好友 start  ******************** //
    public static void friend_list() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.FRIEND_LIST);
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.FRIEND_LIST, map);
        System.out.println(jsonObject.toString());
    }

    public static void friend_get() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.FRIEND_GET);
        map.put("id", "990068");
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.FRIEND_GET, map);
        System.out.println(jsonObject.toString());
    }
    // ******************** 好友 end  ******************** //


    // ******************** 任务 start  ******************** //
    public static void task_get() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", Constant.APPKEY);
        map.put("nonce", Util.getNonce());
        map.put("timestamp", Util.getTimeStamp() + "");
        map.put("version", Constant.VERSION);
        map.put("uri", Constant.URI.TASK_GET);
        map.put("id", "9308");
        map.put("sign", Util.getSign(map));
        JSONObject jsonObject = Util.post(Constant.IP + Constant.URI.TASK_GET, map);
        System.out.println(jsonObject.toString());
    }
    // ******************** 任务 end  ******************** //

}
