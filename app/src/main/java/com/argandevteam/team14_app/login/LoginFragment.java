package com.argandevteam.team14_app.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.argandevteam.team14_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View {


    private LoginContract.Presenter presenter;
    private LoginActivity loginActivity;
    @BindView(R.id.et_username)
    EditText etUserName;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        loginActivity = (LoginActivity) getActivity();

        return view;
    }

    @OnClick(R.id.btn_login)
    void onLoginButtonClicked(View view) {
        String userName = etUserName.getText().toString();
        presenter.onLoginButtonClicked(userName);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToPlaces(String username) {
        loginActivity.navigateToMainActivity(username);
    }

    @Override
    public void showError() {
        Toast.makeText(loginActivity, "Error while logging in.", Toast.LENGTH_SHORT).show();
    }
}
