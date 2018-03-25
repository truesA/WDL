package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.util.List;

public class UserMainMsg implements Serializable {


    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"K15":0,"K20":0,"Numb":"","birthday":"","buy3free1":0,"car_care":0,"car_purpose":"","cred_score":[0,0,270,168,0,438],"cred_score_ratio":[0,0,0.9,0.84,0],"day_mile_recent":8,"economy":0,"excent_insurance":0,"id":11,"jikuikehu":61,"km_per_day":8.23045267489712,"loy_coef":0.9279610067090001,"maint_single":0,"maint_sum":0,"maint_times":12,"mile_gap":[571,6108,3698],"name":"张其祥","period":729.5565170360001,"plate_num":"赣D-Z1566","repair_times":2,"small_scratch_number":0,"submit_appoint":0,"submit_continue":0,"submit_giveup":0,"submit_loss":0,"time_gap":[7,226,85],"wechat_appoint":0,"wechat_id":"Harry_Brown_2019","work_field":"","yuyuegongshi":8.5}
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
         * K15 : 0
         * K20 : 0
         * Numb :
         * birthday :
         * buy3free1 : 0
         * car_care : 0
         * car_purpose :
         * cred_score : [0,0,270,168,0,438]
         * cred_score_ratio : [0,0,0.9,0.84,0] 身份，行为，忠诚，价值，粘性
         * day_mile_recent : 8
         * economy : 0
         * excent_insurance : 0
         * id : 11
         * jikuikehu : 61
         * km_per_day : 8.23045267489712
         * loy_coef : 0.9279610067090001
         * maint_single : 0
         * maint_sum : 0
         * maint_times : 12
         * mile_gap : [571,6108,3698]
         * name : 张其祥
         * period : 729.5565170360001
         * plate_num : 赣D-Z1566
         * repair_times : 2
         * small_scratch_number : 0
         * submit_appoint : 0
         * submit_continue : 0
         * submit_giveup : 0
         * submit_loss : 0
         * time_gap : [7,226,85]
         * wechat_appoint : 0
         * wechat_id : Harry_Brown_2019
         * work_field :
         * yuyuegongshi : 8.5
         */

        private int K15;
        private int K20;
        private String Numb;
        private String birthday;
        private int buy3free1;
        private int car_care;
        private String car_purpose;
        private int day_mile_recent;
        private int economy;
        private int excent_insurance;
        private int id;
        private int jikuikehu;
        private double km_per_day;
        private double loy_coef;
        private int maint_single;
        private int maint_sum;
        private int maint_times;
        private String name;
        private double period;
        private String plate_num;
        private int repair_times;
        private int small_scratch_number;
        private int submit_appoint;
        private int submit_continue;
        private int submit_giveup;
        private int submit_loss;
        private int wechat_appoint;
        private String wechat_id;
        private String work_field;
        private double yuyuegongshi;
        private List<Integer> cred_score;
        private List<Double> cred_score_ratio;
        private List<Integer> mile_gap;
        private List<Integer> time_gap;

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

        public String getNumb() {
            return Numb;
        }

        public void setNumb(String Numb) {
            this.Numb = Numb;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getBuy3free1() {
            return buy3free1;
        }

        public void setBuy3free1(int buy3free1) {
            this.buy3free1 = buy3free1;
        }

        public int getCar_care() {
            return car_care;
        }

        public void setCar_care(int car_care) {
            this.car_care = car_care;
        }

        public String getCar_purpose() {
            return car_purpose;
        }

        public void setCar_purpose(String car_purpose) {
            this.car_purpose = car_purpose;
        }

        public int getDay_mile_recent() {
            return day_mile_recent;
        }

        public void setDay_mile_recent(int day_mile_recent) {
            this.day_mile_recent = day_mile_recent;
        }

        public int getEconomy() {
            return economy;
        }

        public void setEconomy(int economy) {
            this.economy = economy;
        }

        public int getExcent_insurance() {
            return excent_insurance;
        }

        public void setExcent_insurance(int excent_insurance) {
            this.excent_insurance = excent_insurance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getJikuikehu() {
            return jikuikehu;
        }

        public void setJikuikehu(int jikuikehu) {
            this.jikuikehu = jikuikehu;
        }

        public double getKm_per_day() {
            return km_per_day;
        }

        public void setKm_per_day(double km_per_day) {
            this.km_per_day = km_per_day;
        }

        public double getLoy_coef() {
            return loy_coef;
        }

        public void setLoy_coef(double loy_coef) {
            this.loy_coef = loy_coef;
        }

        public int getMaint_single() {
            return maint_single;
        }

        public void setMaint_single(int maint_single) {
            this.maint_single = maint_single;
        }

        public int getMaint_sum() {
            return maint_sum;
        }

        public void setMaint_sum(int maint_sum) {
            this.maint_sum = maint_sum;
        }

        public int getMaint_times() {
            return maint_times;
        }

        public void setMaint_times(int maint_times) {
            this.maint_times = maint_times;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPeriod() {
            return period;
        }

        public void setPeriod(double period) {
            this.period = period;
        }

        public String getPlate_num() {
            return plate_num;
        }

        public void setPlate_num(String plate_num) {
            this.plate_num = plate_num;
        }

        public int getRepair_times() {
            return repair_times;
        }

        public void setRepair_times(int repair_times) {
            this.repair_times = repair_times;
        }

        public int getSmall_scratch_number() {
            return small_scratch_number;
        }

        public void setSmall_scratch_number(int small_scratch_number) {
            this.small_scratch_number = small_scratch_number;
        }

        public int getSubmit_appoint() {
            return submit_appoint;
        }

        public void setSubmit_appoint(int submit_appoint) {
            this.submit_appoint = submit_appoint;
        }

        public int getSubmit_continue() {
            return submit_continue;
        }

        public void setSubmit_continue(int submit_continue) {
            this.submit_continue = submit_continue;
        }

        public int getSubmit_giveup() {
            return submit_giveup;
        }

        public void setSubmit_giveup(int submit_giveup) {
            this.submit_giveup = submit_giveup;
        }

        public int getSubmit_loss() {
            return submit_loss;
        }

        public void setSubmit_loss(int submit_loss) {
            this.submit_loss = submit_loss;
        }

        public int getWechat_appoint() {
            return wechat_appoint;
        }

        public void setWechat_appoint(int wechat_appoint) {
            this.wechat_appoint = wechat_appoint;
        }

        public String getWechat_id() {
            return wechat_id;
        }

        public void setWechat_id(String wechat_id) {
            this.wechat_id = wechat_id;
        }

        public String getWork_field() {
            return work_field;
        }

        public void setWork_field(String work_field) {
            this.work_field = work_field;
        }

        public double getYuyuegongshi() {
            return yuyuegongshi;
        }

        public void setYuyuegongshi(double yuyuegongshi) {
            this.yuyuegongshi = yuyuegongshi;
        }

        public List<Integer> getCred_score() {
            return cred_score;
        }

        public void setCred_score(List<Integer> cred_score) {
            this.cred_score = cred_score;
        }

        public List<Double> getCred_score_ratio() {
            return cred_score_ratio;
        }

        public void setCred_score_ratio(List<Double> cred_score_ratio) {
            this.cred_score_ratio = cred_score_ratio;
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