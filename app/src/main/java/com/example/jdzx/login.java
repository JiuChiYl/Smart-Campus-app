package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText login_username = findViewById(R.id.login_username);
        EditText login_password = findViewById(R.id.login_password);
        Button click_login = findViewById(R.id.click_login);
        CheckBox checkBox = findViewById(R.id.user_login_checkbox);




        click_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean chk = checkBox.isChecked();
                String usn = login_username.getText().toString();
                String pwd = login_password.getText().toString();
                if (chk){
                    if (!usn.equals("") && !pwd.equals("")) {
                        Toast.makeText(login.this, "登录成功！欢迎回来", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this,MainActivity.class));
                    } else {
                        Toast.makeText(login.this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(login.this, "请勾选《用户隐私》协议", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}