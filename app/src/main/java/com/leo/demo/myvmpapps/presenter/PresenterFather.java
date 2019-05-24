package com.leo.demo.myvmpapps.presenter;

import com.leo.demo.myvmpapps.model.IModel;
import com.leo.demo.myvmpapps.view.IView;

import java.lang.ref.WeakReference;

/**
 * 所有presenter的父类，presenter会持有View以及Model部分
 */
public class PresenterFather {
    protected IModel mIModel;

    //此处View个人感觉最好用一个弱引用。
    //防止内存泄漏
    protected WeakReference<IView> mViewReference;
}
