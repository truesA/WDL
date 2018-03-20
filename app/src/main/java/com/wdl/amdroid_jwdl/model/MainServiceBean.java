package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.util.List;

public class MainServiceBean
        implements Serializable {
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

    public static class ResultBean
            implements Serializable {
        private List<Integer> T1;
        private List<Integer> chanzhilv;
        private List<Integer> chuxu;
        private HeaderBean header;
        private List<Integer> huoqi;
        private List<Integer> jiangjinchi;

        public List<Integer> getChanzhilv() {
            return this.chanzhilv;
        }

        public List<Integer> getChuxu() {
            return this.chuxu;
        }

        public HeaderBean getHeader() {
            return this.header;
        }

        public List<Integer> getHuoqi() {
            return this.huoqi;
        }

        public List<Integer> getJiangjinchi() {
            return this.jiangjinchi;
        }

        public List<Integer> getT1() {
            return this.T1;
        }

        public void setChanzhilv(List<Integer> paramList) {
            this.chanzhilv = paramList;
        }

        public void setChuxu(List<Integer> paramList) {
            this.chuxu = paramList;
        }

        public void setHeader(HeaderBean paramHeaderBean) {
            this.header = paramHeaderBean;
        }

        public void setHuoqi(List<Integer> paramList) {
            this.huoqi = paramList;
        }

        public void setJiangjinchi(List<Integer> paramList) {
            this.jiangjinchi = paramList;
        }

        public void setT1(List<Integer> paramList) {
            this.T1 = paramList;
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