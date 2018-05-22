package com.wdl.amdroid_jwdl.model;

import java.io.Serializable;
import java.util.List;

/**
 * author：lhm on 2018/3/29 22:32
 * <p>
 * email：3186834196@qq.com
 */
public class ClientLoyaltyBean implements Serializable {


    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"id":0,"km_past":179172,"km_per_day":77,"km_period":11004,"loy_coef":9.33827002571,"loyalty_percent":86,"loyalty_score":0,"mile_gap":[147189,44079,28188],"month_past":71,"speed_average":84,"speed_recent":77,"speed_survey":0,"time_gap":[117,350,362]}
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

    public static class ResultBean {
        /**
         * id : 0
         * km_past : 179172
         * km_per_day : 77
         * km_period : 11004
         * loy_coef : 9.33827002571
         * loyalty_percent : 86
         * loyalty_score : 0
         * mile_gap : [147189,44079,28188]
         * month_past : 71
         * speed_average : 84
         * speed_recent : 77
         * speed_survey : 0
         * time_gap : [117,350,362]
         */

        private int id;
        private int km_past;
        private int km_per_day;
        private int km_period;
        private double loy_coef;
        private int loyalty_percent;
        private int loyalty_score;
        private int month_past;
        private int speed_average;
        private int speed_recent;
        private int speed_survey;
        private List<Integer> mile_gap;
        private List<Integer> time_gap;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getKm_past() {
            return km_past;
        }

        public void setKm_past(int km_past) {
            this.km_past = km_past;
        }

        public int getKm_per_day() {
            return km_per_day;
        }

        public void setKm_per_day(int km_per_day) {
            this.km_per_day = km_per_day;
        }

        public int getKm_period() {
            return km_period;
        }

        public void setKm_period(int km_period) {
            this.km_period = km_period;
        }

        public double getLoy_coef() {
            return loy_coef;
        }

        public void setLoy_coef(double loy_coef) {
            this.loy_coef = loy_coef;
        }

        public int getLoyalty_percent() {
            return loyalty_percent;
        }

        public void setLoyalty_percent(int loyalty_percent) {
            this.loyalty_percent = loyalty_percent;
        }

        public int getLoyalty_score() {
            return loyalty_score;
        }

        public void setLoyalty_score(int loyalty_score) {
            this.loyalty_score = loyalty_score;
        }

        public int getMonth_past() {
            return month_past;
        }

        public void setMonth_past(int month_past) {
            this.month_past = month_past;
        }

        public int getSpeed_average() {
            return speed_average;
        }

        public void setSpeed_average(int speed_average) {
            this.speed_average = speed_average;
        }

        public int getSpeed_recent() {
            return speed_recent;
        }

        public void setSpeed_recent(int speed_recent) {
            this.speed_recent = speed_recent;
        }

        public int getSpeed_survey() {
            return speed_survey;
        }

        public void setSpeed_survey(int speed_survey) {
            this.speed_survey = speed_survey;
        }

        public List<Integer> getMile_gap() {
            return mile_gap;
        }

        public void setMile_gap(List<Integer> mile_gap) {
            this.mile_gap = mile_gap;
        }

        public List<Integer> getTime_gap() {
            return time_gap;
        }

        public void setTime_gap(List<Integer> time_gap) {
            this.time_gap = time_gap;
        }
    }
}
