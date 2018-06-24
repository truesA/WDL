package com.wdl.jwdl.model;

import java.io.Serializable;

/**
 * author：lhm on 2018/3/29 22:32
 * <p>
 * email：3186834196@qq.com
 */
public class ClientBehaviorBean implements Serializable {

    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"K10":0,"K15":0,"K20":0,"K5":0,"behavior_percent":42,"behavior_score":15,"body_shop":0,"car_care":0,"economy":0,"extension":0,"id":0,"insurance":0,"maint_times":21,"repair_times":10,"wechat_appoint":0}
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

    public static class ResultBean implements Serializable {
        /**
         * K10 : 0
         * K15 : 0
         * K20 : 0
         * K5 : 0
         * behavior_percent : 42
         * behavior_score : 15
         * body_shop : 0
         * car_care : 0
         * economy : 0
         * extension : 0
         * id : 0
         * insurance : 0
         * maint_times : 21
         * repair_times : 10
         * wechat_appoint : 0
         */

        private int K10;
        private int K15;
        private int K20;
        private int K5;
        private int behavior_percent;
        private int behavior_score;
        private int body_shop;
        private int car_care;
        private int economy;
        private int extension;
        private int userid;
        private int insurance;
        private int maint_times;
        private int repair_times;
        private int wechat_appoint;

        public int getK10() {
            return K10;
        }

        public void setK10(int K10) {
            this.K10 = K10;
        }

        public int getK15() {
            return K15;
        }

        public void setK15(int K15) {
            this.K15 = K15;
        }

        public int getK20() {
            return K20;
        }

        public void setK20(int K20) {
            this.K20 = K20;
        }

        public int getK5() {
            return K5;
        }

        public void setK5(int K5) {
            this.K5 = K5;
        }

        public int getBehavior_percent() {
            return behavior_percent;
        }

        public void setBehavior_percent(int behavior_percent) {
            this.behavior_percent = behavior_percent;
        }

        public int getBehavior_score() {
            return behavior_score;
        }

        public void setBehavior_score(int behavior_score) {
            this.behavior_score = behavior_score;
        }

        public int getBody_shop() {
            return body_shop;
        }

        public void setBody_shop(int body_shop) {
            this.body_shop = body_shop;
        }

        public int getCar_care() {
            return car_care;
        }

        public void setCar_care(int car_care) {
            this.car_care = car_care;
        }

        public int getEconomy() {
            return economy;
        }

        public void setEconomy(int economy) {
            this.economy = economy;
        }

        public int getExtension() {
            return extension;
        }

        public void setExtension(int extension) {
            this.extension = extension;
        }


        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getInsurance() {
            return insurance;
        }

        public void setInsurance(int insurance) {
            this.insurance = insurance;
        }

        public int getMaint_times() {
            return maint_times;
        }

        public void setMaint_times(int maint_times) {
            this.maint_times = maint_times;
        }

        public int getRepair_times() {
            return repair_times;
        }

        public void setRepair_times(int repair_times) {
            this.repair_times = repair_times;
        }

        public int getWechat_appoint() {
            return wechat_appoint;
        }

        public void setWechat_appoint(int wechat_appoint) {
            this.wechat_appoint = wechat_appoint;
        }
    }
}
