package com.leo.demo.myvmpapps.model;

import com.leo.demo.myvmpapps.model.listener.LoginLisentener;

/**
 * 实际业务逻辑处理
 */
public class LoginMode implements IModel {
    //model 负责数据以及业务逻辑。
    private String mUserName = "admin";
    private String mPassWord = "123456";

    public void login(String username, String password, LoginLisentener lisentener) {
        if (lisentener == null) {
            return;
        }
        if (mUserName.equals(username) && mPassWord.equals(password)) {
            lisentener.onSuccess();
        } else {
            lisentener.onFailed();
        }
    }
}
