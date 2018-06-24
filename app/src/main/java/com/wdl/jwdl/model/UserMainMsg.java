package com.wdl.jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.util.List;

public class UserMainMsg implements Serializable {


    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"M1":0,"M2":0,"Numb":"13766286568","T1_threshold":430,"birthday":"1900-01-31","body_shop_times":0,"car_age":7,"car_care_times":0,"car_model":"汉兰达","continue_insurance_times":0,"count_appoint":0,"count_continue":0,"count_giveup":0,"cred_score":[0,15,0,168,0],"cred_score_ratio":[0,15,0,168,0],"day_km_recent":77,"economy_times":0,"excellent_times":0,"header":{"request_time":"2018-05-23 00:16:43","response_time":"2018-05-23 00:16:43"},"id":0,"insurance_date":"1900-01-31","km_past":179256,"km_per_day":84,"km_period":11004,"loy_coef":9.33827002571,"maint_single":0,"maint_single_pct":33,"maint_sum":0,"maint_sum_pct":36,"maint_times":8,"month_past":71,"name":"罗","period":131.608959327,"plate_num":"赣D-L1838","repair_times":1,"small_scratch_number":0,"submit_appoint":0,"submit_continue":0,"submit_giveup":0,"submit_loss":0,"survey_speed":0,"wechat_appoint":0,"wechat_id":"0.0","zhe":7.5}
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
         * M1 : 0
         * M2 : 0
         * Numb : 13766286568
         * T1_threshold : 430.0
         * birthday : 1900-01-31
         * body_shop_times : 0
         * car_age : 7
         * car_care_times : 0
         * car_model : 汉兰达
         * continue_insurance_times : 0
         * count_appoint : 0
         * count_continue : 0
         * count_giveup : 0
         * cred_score : [0,15,0,168,0]
         * cred_score_ratio : [0,15,0,168,0]
         * day_km_recent : 77
         * economy_times : 0
         * excellent_times : 0
         * header : {"request_time":"2018-05-23 00:16:43","response_time":"2018-05-23 00:16:43"}
         * id : 0
         * insurance_date : 1900-01-31
         * km_past : 179256
         * km_per_day : 84
         * km_period : 11004
         * loy_coef : 9.33827002571
         * maint_single : 0
         * maint_single_pct : 33
         * maint_sum : 0
         * maint_sum_pct : 36
         * maint_times : 8
         * month_past : 71
         * name : 罗
         * period : 131.608959327
         * plate_num : 赣D-L1838
         * repair_times : 1
         * small_scratch_number : 0
         * submit_appoint : 0
         * submit_continue : 0
         * submit_giveup : 0
         * submit_loss : 0
         * survey_speed : 0
         * wechat_appoint : 0
         * wechat_id : 0.0
         * zhe : 7.5
         */

        private int M1;
        private int M2;
        private String Numb;
        private int T1_threshold;
        private String birthday;
        private int body_shop_times;
        private int car_age;
        private int car_care_times;
        private String car_model;
        private int continue_insurance_times;
        private int count_appoint;
        private int count_continue;
        private int count_giveup;
        private int day_km_recent;
        private int economy_times;
        private int excellent_times;
        private HeaderBean header;
        private int userid;
        private String insurance_date;
        private int km_past;
        private int km_per_day;
        private int km_period;
        private double loy_coef;
        private int maint_single;
        private int maint_single_pct;
        private int maint_sum;
        private int maint_sum_pct;
        private int maint_times;
        private int month_past;
        private String name;
        private double period;
        private String plate_num;
        private int repair_times;
        private int small_scratch_number;
        private int submit_appoint;
        private int submit_continue;
        private int submit_giveup;
        private int submit_loss;
        private int survey_speed;
        private int wechat_appoint;
        private String wechat_id;
        private double zhe;
        private List<Integer> cred_score;
        private List<Double> cred_score_ratio;

        public int getM1() {
            return M1;
        }

        public void setM1(int M1) {
            this.M1 = M1;
        }

        public int getM2() {
            return M2;
        }

        public void setM2(int M2) {
            this.M2 = M2;
        }

        public String getNumb() {
            return Numb;
        }

        public void setNumb(String Numb) {
            this.Numb = Numb;
        }

        public int getT1_threshold() {
            return T1_threshold;
        }

        public void setT1_threshold(int T1_threshold) {
            this.T1_threshold = T1_threshold;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getBody_shop_times() {
            return body_shop_times;
        }

        public void setBody_shop_times(int body_shop_times) {
            this.body_shop_times = body_shop_times;
        }

        public int getCar_age() {
            return car_age;
        }

        public void setCar_age(int car_age) {
            this.car_age = car_age;
        }

        public int getCar_care_times() {
            return car_care_times;
        }

        public void setCar_care_times(int car_care_times) {
            this.car_care_times = car_care_times;
        }

        public String getCar_model() {
            return car_model;
        }

        public void setCar_model(String car_model) {
            this.car_model = car_model;
        }

        public int getContinue_insurance_times() {
            return continue_insurance_times;
        }

        public void setContinue_insurance_times(int continue_insurance_times) {
            this.continue_insurance_times = continue_insurance_times;
        }

        public int getCount_appoint() {
            return count_appoint;
        }

        public void setCount_appoint(int count_appoint) {
            this.count_appoint = count_appoint;
        }

        public int getCount_continue() {
            return count_continue;
        }

        public void setCount_continue(int count_continue) {
            this.count_continue = count_continue;
        }

        public int getCount_giveup() {
            return count_giveup;
        }

        public void setCount_giveup(int count_giveup) {
            this.count_giveup = count_giveup;
        }

        public int getDay_km_recent() {
            return day_km_recent;
        }

        public void setDay_km_recent(int day_km_recent) {
            this.day_km_recent = day_km_recent;
        }

        public int getEconomy_times() {
            return economy_times;
        }

        public void setEconomy_times(int economy_times) {
            this.economy_times = economy_times;
        }

        public int getExcellent_times() {
            return excellent_times;
        }

        public void setExcellent_times(int excellent_times) {
            this.excellent_times = excellent_times;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getInsurance_date() {
            return insurance_date;
        }

        public void setInsurance_date(String insurance_date) {
            this.insurance_date = insurance_date;
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

        public int getMaint_single() {
            return maint_single;
        }

        public void setMaint_single(int maint_single) {
            this.maint_single = maint_single;
        }

        public int getMaint_single_pct() {
            return maint_single_pct;
        }

        public void setMaint_single_pct(int maint_single_pct) {
            this.maint_single_pct = maint_single_pct;
        }

        public int getMaint_sum() {
            return maint_sum;
        }

        public void setMaint_sum(int maint_sum) {
            this.maint_sum = maint_sum;
        }

        public int getMaint_sum_pct() {
            return maint_sum_pct;
        }

        public void setMaint_sum_pct(int maint_sum_pct) {
            this.maint_sum_pct = maint_sum_pct;
        }

        public int getMaint_times() {
            return maint_times;
        }

        public void setMaint_times(int maint_times) {
            this.maint_times = maint_times;
        }

        public int getMonth_past() {
            return month_past;
        }

        public void setMonth_past(int month_past) {
            this.month_past = month_past;
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

        public int getSurvey_speed() {
            return survey_speed;
        }

        public void setSurvey_speed(int survey_speed) {
            this.survey_speed = survey_speed;
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

        public double getZhe() {
            return zhe;
        }

        public void setZhe(double zhe) {
            this.zhe = zhe;
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

        public static class HeaderBean {
            /**
             * request_time : 2018-05-23 00:16:43
             * response_time : 2018-05-23 00:16:43
             */

            private String request_time;
            private String response_time;

            public String getRequest_time() {
                return request_time;
            }

            public void setRequest_time(String request_time) {
                this.request_time = request_time;
            }

            public String getResponse_time() {
                return response_time;
            }

            public void setResponse_time(String response_time) {
                this.response_time = response_time;
            }
        }
    }
}