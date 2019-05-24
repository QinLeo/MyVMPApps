package com.leo.demo.myvmpapps.view;

/**
 * View的interface
 */
public interface ILoginView extends IView {
    String getUserName();

    String getPassword();

    void onLoginSeccess();

    void onLoginFails();
}
