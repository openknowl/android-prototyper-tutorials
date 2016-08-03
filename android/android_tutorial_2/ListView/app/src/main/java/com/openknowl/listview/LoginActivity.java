package com.openknowl.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by gracefulife on 16. 8. 3.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText idEditText;
    EditText passwordEditText;
    Button loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEditText = (EditText) findViewById(R.id.idEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (loginButton.getId() == view.getId()) {
            Toast.makeText(LoginActivity.this, "로그인 정보는 아래와 같습니다.\n"
                    + idEditText.getText() + " / " + passwordEditText.getText(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(LoginActivity.this, ListViewActivity.class);
            Intent intent = new Intent(LoginActivity.this, SpinnerActivity.class);
            startActivity(intent);
        }
    }
}
