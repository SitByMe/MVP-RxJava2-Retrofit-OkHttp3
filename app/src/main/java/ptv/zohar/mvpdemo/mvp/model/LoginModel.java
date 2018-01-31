package ptv.zohar.mvpdemo.mvp.model;

import ptv.zohar.mvpdemo.http.HttpUtils;

/**
 * Created by Zohar on 2018/1/23.
 * desc:
 */
public class LoginModel extends BaseModel {

    /**
     * 登录
     *
     * @param phoneNo        手机号
     * @param password       密码
     * @param registerId     注册码
     * @param resultListener 回调接口
     */
    public void login(String phoneNo, String password, String registerId, final HttpUtils.OnHttpResultListener resultListener) {
        resultListener.onResult("登陆成功" + "\nphoneNo:" + phoneNo + "\npassword:" + password);
    }
}
