package com.leo.demo.myvmpapps;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leo.demo.myvmpapps.presenter.LoginPresenter;
import com.leo.demo.myvmpapps.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    Button submit;

    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        submit = findViewById(R.id.login);

        setView();
        setData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //记得在销毁的时候断掉引用链，养成良好的习惯
        this.mPresenter = null;
    }

    private void setView() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
                mPresenter.login();
            }
        });
    }

    private void setData() {
        this.mPresenter = new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return mEmailView.getEditableText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordView.getEditableText().toString();
    }

    @Override
    public void onLoginSeccess() {
        this.finish();
    }

    @Override
    public void onLoginFails() {
        Toast.makeText(this,"失败",Toast.LENGTH_SHORT).show();
    }
}

