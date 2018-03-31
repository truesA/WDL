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
     * result : {"day_mile_recent":37,"id":0,"loy_coef":0.44600612557400005,"loyalty_percent":36,"loyalty_score":300,"mile_gap":[4575,4966,7340],"period":159.190638713,"time_gap":[71,107,113]}
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
         * day_mile_recent : 37
         * id : 0
         * loy_coef : 0.44600612557400005
         * loyalty_percent : 36
         * loyalty_score : 300
         * mile_gap : [4575,4966,7340]
         * period : 159.190638713
         * time_gap : [71,107,113]
         */

        private int km_per_day;
        private int id;
        private double loy_coef;
        private int loyalty_percent;
        private int loyalty_score;
        private double period;
        private List<Integer> mile_gap;
        private List<Integer> time_gap;

        public int getKm_per_day() {
            return km_per_day;
        }

        public void setKm_per_day(int km_per_day) {
            this.km_per_day = km_per_day;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public double getPeriod() {
            return period;
        }

        public void setPeriod(double period) {
            this.period = period;
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
