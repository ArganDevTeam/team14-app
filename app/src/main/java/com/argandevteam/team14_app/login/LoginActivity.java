package com.argandevteam.team14_app.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.argandevteam.team14_app.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = LoginFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, loginFragment)
                .commit();

        LoginPresenter loginPresenter = new LoginPresenter(loginFragment);
    }
}
