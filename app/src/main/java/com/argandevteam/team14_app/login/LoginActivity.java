package com.argandevteam.team14_app.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.argandevteam.team14_app.MainActivity;
import com.argandevteam.team14_app.R;
import com.argandevteam.team14_app.data.source.UsersRepository;
import com.argandevteam.team14_app.data.source.remote.UsersRemoteDataSource;

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


        UsersRemoteDataSource usersRemoteDataSource = UsersRemoteDataSource.getInstance();

        UsersRepository usersRepository = new UsersRepository(usersRemoteDataSource);

        LoginPresenter loginPresenter = new LoginPresenter(usersRepository, loginFragment);
    }

    public void navigateToMainActivity(String userName) {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        mainActivityIntent.putExtra("userName", userName);
        startActivity(mainActivityIntent);
        finish();
    }
}
