package com.example.vinted.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinted.R;
import com.example.vinted.beans.User;
import com.example.vinted.login.ContractLogin;
import com.example.vinted.login.presenter.LoginPresenter;
import com.example.vinted.lstProducts.view.ListProductActivity;

public class LoginActivity extends AppCompatActivity implements ContractLogin.View {

    EditText username;
    EditText password;
    Button send;

    private LoginPresenter presenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        innitcompoinents();
    }

    public void innitcompoinents(){
        username = findViewById(R.id.emailText);
        password = findViewById(R.id.passText);
        send = findViewById(R.id.sendBtn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user  = new User();
                user.setUsername(username.getText().toString());
                user.setToken(password.getText().toString());
                presenter.login(user);
            }
        });

    }


    @Override
    public void successLogin(User user) {
        Intent intent = new Intent(LoginActivity.this, ListProductActivity.class);
        startActivity(intent);
    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}