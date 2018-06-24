package com.wdl.jwdl.model;

import java.io.Serializable;

/**
 * author：lhm on 2018/3/29 22:30
 * <p>
 * email：3186834196@qq.com
 */
public class ClientStickyBean implements Serializable{


    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"buy3free1":0,"excent_insurance":0,"id":0,"sticky_percent":38,"sticky_score":0}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

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

    public static class ResultBean implements Serializable{
        /**
         * buy3free1 : 0
         * excent_insurance : 0
         * id : 0
         * sticky_percent : 38
         * sticky_score : 0
         */

        private int buy3free1;
        private int excent_insurance;
        private int userid;
        private int sticky_percent;
        private int sticky_score;

        public int getBuy3free1() {
            return buy3free1;
        }

        public void setBuy3free1(int buy3free1) {
            this.buy3free1 = buy3free1;
        }

        public int getExcent_insurance() {
            return excent_insurance;
        }

        public void setExcent_insurance(int excent_insurance) {
            this.excent_insurance = excent_insurance;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getSticky_percent() {
            return sticky_percent;
        }

        public void setSticky_percent(int sticky_percent) {
            this.sticky_percent = sticky_percent;
        }

        public int getSticky_score() {
            return sticky_score;
        }

        public void setSticky_score(int sticky_score) {
            this.sticky_score = sticky_score;
        }
    }
}
