package com.leo.demo.myvmpapps.view;

public interface ILoginView extends IView {
    String getUserName();

    String getPassword();

    void onLoginSeccess();

    void onLoginFails();
}
