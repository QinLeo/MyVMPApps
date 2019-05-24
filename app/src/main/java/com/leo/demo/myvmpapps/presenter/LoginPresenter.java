package com.leo.demo.myvmpapps.presenter;

import com.leo.demo.myvmpapps.model.LoginMode;
import com.leo.demo.myvmpapps.model.listener.LoginLisentener;
import com.leo.demo.myvmpapps.view.ILoginView;
import com.leo.demo.myvmpapps.view.IView;

import java.lang.ref.WeakReference;

public class LoginPresenter extends PresenterFather {

    public LoginPresenter(ILoginView loginView) {
        this.mIModel = new LoginMode();
        this.mViewReference = new WeakReference<IView>(loginView);
    }

    public void login() {
        if (mIModel != null && mViewReference != null && mViewReference.get() != null) {
            ILoginView loginView = (ILoginView) mViewReference.get();
            String name = loginView.getUserName();
            String passWord = loginView.getPassword();
            loginView = null;
            //此时LoginListener作为匿名内部类是持有外部类的引用的。
            ((LoginMode)mIModel).login(name, passWord, new LoginLisentener() {
                @Override
                public void onSuccess() {
                    if (mViewReference.get() != null) {
                        ((ILoginView)mViewReference.get()).onLoginSeccess();
                    }
                }

                @Override
                public void onFailed() {
                    if (mViewReference.get() != null) {
                        if (mViewReference.get() != null) {
                            ((ILoginView)mViewReference.get()).onLoginFails();
                        }
                    }
                }
            });
        }
    }
}
