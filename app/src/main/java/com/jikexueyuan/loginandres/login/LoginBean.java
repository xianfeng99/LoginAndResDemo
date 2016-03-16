package com.jikexueyuan.loginandres.login;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lixianfeng on 16/3/16.
 */
public class LoginBean {

    private String login;
    private String result;

    public LoginBean() {
    }

    public LoginBean(String jsonStr){
        try {
            JSONObject json = new JSONObject(jsonStr);
            login = json.getString("login");
            result = json.getString("result");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String toString(){
        return "LoginBean:" + "login:" + login + ",result:" + result;
    }
}
