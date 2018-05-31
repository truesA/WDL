package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;

public class LoginUesr implements Serializable
{


    /**
     * error_code : 200
     * reason : login successful!
     * result : {"logintype":1,"name":"admin1","password":"123456"}
     */

    private int error_code;
    private String reason;
    private ResultBean result;
    private boolean isLogin;


    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * logintype : 1
         * name : admin1
         * password : 123456
         */

        private int logintype;
        private String name;
        private String password;

        public int getLogintype() {
            return logintype;
        }

        public void setLogintype(int logintype) {
            this.logintype = logintype;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}