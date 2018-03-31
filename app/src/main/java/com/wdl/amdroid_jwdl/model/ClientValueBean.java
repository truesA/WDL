package com.wdl.amdroid_jwdl.model;

import java.io.Serializable;

/**
 * author：lhm on 2018/3/29 22:31
 * <p>
 * email：3186834196@qq.com
 */
public class ClientValueBean implements Serializable {


    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"body_shop_sum":0,"body_shop_sum_percent":41,"car_care_sum":0,"car_care_sum_percent":43,"excellent_sum":0,"excellent_sum_percent":45,"id":0,"maint_single":2596,"maint_single_percent":33,"maint_sum":2596,"maint_sum_percent":36,"repair_sum":16725,"repair_sum_percent":38,"value_percent":41,"value_score":200}
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
         * body_shop_sum : 0
         * body_shop_sum_percent : 41
         * car_care_sum : 0
         * car_care_sum_percent : 43
         * excellent_sum : 0
         * excellent_sum_percent : 45
         * id : 0
         * maint_single : 2596
         * maint_single_percent : 33
         * maint_sum : 2596
         * maint_sum_percent : 36
         * repair_sum : 16725
         * repair_sum_percent : 38
         * value_percent : 41
         * value_score : 200
         */

        private int body_shop_sum;
        private int body_shop_sum_percent;
        private int car_care_sum;
        private int car_care_sum_percent;
        private int excellent_sum;
        private int excellent_sum_percent;
        private int id;
        private int maint_single;
        private int maint_single_percent;
        private int maint_sum;
        private int maint_sum_percent;
        private int repair_sum;
        private int repair_sum_percent;
        private int value_percent;
        private int value_score;

        public int getBody_shop_sum() {
            return body_shop_sum;
        }

        public void setBody_shop_sum(int body_shop_sum) {
            this.body_shop_sum = body_shop_sum;
        }

        public int getBody_shop_sum_percent() {
            return body_shop_sum_percent;
        }

        public void setBody_shop_sum_percent(int body_shop_sum_percent) {
            this.body_shop_sum_percent = body_shop_sum_percent;
        }

        public int getCar_care_sum() {
            return car_care_sum;
        }

        public void setCar_care_sum(int car_care_sum) {
            this.car_care_sum = car_care_sum;
        }

        public int getCar_care_sum_percent() {
            return car_care_sum_percent;
        }

        public void setCar_care_sum_percent(int car_care_sum_percent) {
            this.car_care_sum_percent = car_care_sum_percent;
        }

        public int getExcellent_sum() {
            return excellent_sum;
        }

        public void setExcellent_sum(int excellent_sum) {
            this.excellent_sum = excellent_sum;
        }

        public int getExcellent_sum_percent() {
            return excellent_sum_percent;
        }

        public void setExcellent_sum_percent(int excellent_sum_percent) {
            this.excellent_sum_percent = excellent_sum_percent;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMaint_single() {
            return maint_single;
        }

        public void setMaint_single(int maint_single) {
            this.maint_single = maint_single;
        }

        public int getMaint_single_percent() {
            return maint_single_percent;
        }

        public void setMaint_single_percent(int maint_single_percent) {
            this.maint_single_percent = maint_single_percent;
        }

        public int getMaint_sum() {
            return maint_sum;
        }

        public void setMaint_sum(int maint_sum) {
            this.maint_sum = maint_sum;
        }

        public int getMaint_sum_percent() {
            return maint_sum_percent;
        }

        public void setMaint_sum_percent(int maint_sum_percent) {
            this.maint_sum_percent = maint_sum_percent;
        }

        public int getRepair_sum() {
            return repair_sum;
        }

        public void setRepair_sum(int repair_sum) {
            this.repair_sum = repair_sum;
        }

        public int getRepair_sum_percent() {
            return repair_sum_percent;
        }

        public void setRepair_sum_percent(int repair_sum_percent) {
            this.repair_sum_percent = repair_sum_percent;
        }

        public int getValue_percent() {
            return value_percent;
        }

        public void setValue_percent(int value_percent) {
            this.value_percent = value_percent;
        }

        public int getValue_score() {
            return value_score;
        }

        public void setValue_score(int value_score) {
            this.value_score = value_score;
        }
    }
}
