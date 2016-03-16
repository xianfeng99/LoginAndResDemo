package com.jikexueyuan.loginandres.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jikexueyuan.loginandres.Global;
import com.jikexueyuan.loginandres.MainActivity;
import com.jikexueyuan.loginandres.NetManager;
import com.jikexueyuan.loginandres.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText login_name;
    private EditText login_pwd;
    private Button login_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_name = (EditText) findViewById(R.id.login_name);
        login_pwd = (EditText) findViewById(R.id.login_pwd);
        login_ok = (Button) findViewById(R.id.login_ok);

        login_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = login_name.getText().toString();
                String password = login_pwd.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(login_pwd.getText())) {

                    Toast.makeText(LoginActivity.this, "用户明或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                login(username, password);
            }
        });



    }

    private void login(String username, String password){
        StringRequest sr = new StringRequest(Global.LOGIN + "username=" + username + "&password=" + password, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LoginBean loginBean = new LoginBean(response);
                Log.e("=======>", "response:" + loginBean);

                if(loginBean.getLogin().equals("success")){

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "用户明或密码错误", Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("=======>", "error:" + error);
            }
        });

        NetManager.getInstance().addRequest(sr);
    }
}
