/**
 * Created by 浪漫樱花 on 2018/6/13.
 */
public class Constant {
    public static final String IP = "http://127.0.0.1:8082";                                                            //访问地址
    public static final String APPKEY = "5dbbbcbddda03658dc559846be338576";                                             //固定
    public static final String APPSECRET = "81370d57c2a6a34446c7af2a7a7f09b50c96162d";                                  //固定
    public static final String VERSION = "1";                                                                           //版本号 默认为1
    public static String TOKEN = "";                                                                                    //token

    public static class URI {
        public static final String ACCOUNT_LOGIN = "/custom/account/login";                                             //登录
        public static final String ACCOUNT_ME = "/custom/account/me";                                                   //个人信息
        public static final String ACCOUNT_CHECKTOKEN = "/custom/account/checktoken";                                   //检查token

        public static final String GROUP_CREATE = "/custom/group/create";                                               //创建群聊
        public static final String GROUP_LIST = "/custom/group/list";                                                   //查询群聊列表
        public static final String GROUP_GET = "/custom/group/get";                                                     //获取群详情
        public static final String GROUP_PULLIN = "/custom/group/pullin";                                               //拉人
        public static final String GROUP_PUSHOUT = "/custom/group/pushout";                                             //踢人

        public static final String MESSAGE_LIST = "/custom/message/list";                                               //获取消息
        public static final String MESSAGE_SEND = "/custom/message/send";                                               //发送消息

        public static final String FRIEND_LIST = "/custom/friend/list";                                                 //好友列表
        public static final String FRIEND_GET = "/custom/friend/get";                                                   //好友详情

        public static final String TASK_GET = "/custom/task/get";                                                       //任务详情
    }
}
