package com.wdl.jwdl.model;

import java.io.Serializable;

/**
 * Created by 62682 on 2018/3/20.
 */

public class BaseBean implements Serializable {
    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return this.error_code;
    }

    public String getReason() {
        return this.reason;
    }

    public ResultBean getResult() {
        return this.result;
    }

    public void setError_code(int paramInt) {
        this.error_code = paramInt;
    }

    public void setReason(String paramString) {
        this.reason = paramString;
    }

    public void setResult(ResultBean paramResultBean) {
        this.result = paramResultBean;
    }

    public static class ResultBean implements Serializable{
        private HeaderBean header;
        private int status;

        public HeaderBean getHeader() {
            return this.header;
        }

        public int getStatus() {
            return this.status;
        }

        public void setHeader(HeaderBean paramHeaderBean) {
            this.header = paramHeaderBean;
        }

        public void setStatus(int paramInt) {
            this.status = paramInt;
        }

        public static class HeaderBean {
            private String request_time;
            private String response_time;

            public String getRequest_time() {
                return this.request_time;
            }

            public String getResponse_time() {
                return this.response_time;
            }

            public void setRequest_time(String paramString) {
                this.request_time = paramString;
            }

            public void setResponse_time(String paramString) {
                this.response_time = paramString;
            }
        }
    }
}