package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
      EditText usernameEditText;
     TextView  loginTitleTextView;
     EditText passwordEditText;
      Button submitButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        submitButton = findViewById(R.id.btn_submit);

        submitButton.setOnClickListener(view -> {
            loginTitleTextView=findViewById(R.id.loginTitleTextView);
            if (usernameEditText.getText().toString().equals("rishabh") && passwordEditText.getText().toString().equals("password")) {
            loginTitleTextView.setText("Success");


            }else {
                loginTitleTextView.setText("Failure");
            }
        });
    }

}

