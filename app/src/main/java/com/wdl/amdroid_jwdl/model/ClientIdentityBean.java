package com.wdl.amdroid_jwdl.model;

import java.io.Serializable;

/**
 * author：lhm on 2018/3/29 22:32
 * <p>
 * email：3186834196@qq.com
 */
public class ClientIdentityBean implements Serializable {


    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"Numb":"13766286568","age":0,"birthday":"1900-01-31","car_age":7,"car_model":"汉兰达","car_purpose":"未填","children":0,"continue_insurance_date":"0000-00-00","continue_notes":"0.0","displacement":"2.7L","feature_notes":"0.0","gender":"男","giveup_notes":"0.0","hobby":"0.0","id":0,"identity_percent":49,"identity_score":0,"insurance_date":"1900-01-31","km_per_day":84,"location":"吉安市","marriage":"0.0","name":"罗","plate_num":"赣D-L1838","position":"未填","sale_date":"2011-02-15","small_scratch_number":0,"survey_speed":0,"wechat_id":"0.0","work_field":"未填"}
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
         * Numb : 13766286568
         * age : 0.0
         * birthday : 1900-01-31
         * car_age : 7
         * car_model : 汉兰达
         * car_purpose : 未填
         * children : 0
         * continue_insurance_date : 0000-00-00
         * continue_notes : 0.0
         * displacement : 2.7L
         * feature_notes : 0.0
         * gender : 男
         * giveup_notes : 0.0
         * hobby : 0.0
         * id : 0
         * identity_percent : 49
         * identity_score : 0
         * insurance_date : 1900-01-31
         * km_per_day : 84
         * location : 吉安市
         * marriage : 0.0
         * name : 罗
         * plate_num : 赣D-L1838
         * position : 未填
         * sale_date : 2011-02-15
         * small_scratch_number : 0
         * survey_speed : 0
         * wechat_id : 0.0
         * work_field : 未填
         */

        private String Numb;
        private double age;
        private String birthday;
        private int car_age;
        private String car_model;
        private String car_purpose;
        private String children;
        private String continue_insurance_date;
        private String continue_notes;
        private String displacement;
        private String feature_notes;
        private String gender;
        private String giveup_notes;
        private String hobby;
        private int id;
        private int identity_percent;
        private int identity_score;
        private String insurance_date;
        private int km_per_day;
        private String location;
        private String marriage;
        private String name;
        private String plate_num;
        private String position;
        private String sale_date;
        private int small_scratch_number;
        private int survey_speed;
        private String wechat_id;
        private String work_field;

        public String getNumb() {
            return Numb;
        }

        public void setNumb(String Numb) {
            this.Numb = Numb;
        }

        public double getAge() {
            return age;
        }

        public void setAge(double age) {
            this.age = age;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getCar_age() {
            return car_age;
        }

        public void setCar_age(int car_age) {
            this.car_age = car_age;
        }

        public String getCar_model() {
            return car_model;
        }

        public void setCar_model(String car_model) {
            this.car_model = car_model;
        }

        public String getCar_purpose() {
            return car_purpose;
        }

        public void setCar_purpose(String car_purpose) {
            this.car_purpose = car_purpose;
        }

        public String getChildren() {
            return children;
        }

        public void setChildren(String children) {
            this.children = children;
        }

        public String getContinue_insurance_date() {
            return continue_insurance_date;
        }

        public void setContinue_insurance_date(String continue_insurance_date) {
            this.continue_insurance_date = continue_insurance_date;
        }

        public String getContinue_notes() {
            return continue_notes;
        }

        public void setContinue_notes(String continue_notes) {
            this.continue_notes = continue_notes;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public String getFeature_notes() {
            return feature_notes;
        }

        public void setFeature_notes(String feature_notes) {
            this.feature_notes = feature_notes;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getGiveup_notes() {
            return giveup_notes;
        }

        public void setGiveup_notes(String giveup_notes) {
            this.giveup_notes = giveup_notes;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdentity_percent() {
            return identity_percent;
        }

        public void setIdentity_percent(int identity_percent) {
            this.identity_percent = identity_percent;
        }

        public int getIdentity_score() {
            return identity_score;
        }

        public void setIdentity_score(int identity_score) {
            this.identity_score = identity_score;
        }

        public String getInsurance_date() {
            return insurance_date;
        }

        public void setInsurance_date(String insurance_date) {
            this.insurance_date = insurance_date;
        }

        public int getKm_per_day() {
            return km_per_day;
        }

        public void setKm_per_day(int km_per_day) {
            this.km_per_day = km_per_day;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getMarriage() {
            return marriage;
        }

        public void setMarriage(String marriage) {
            this.marriage = marriage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlate_num() {
            return plate_num;
        }

        public void setPlate_num(String plate_num) {
            this.plate_num = plate_num;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getSale_date() {
            return sale_date;
        }

        public void setSale_date(String sale_date) {
            this.sale_date = sale_date;
        }

        public int getSmall_scratch_number() {
            return small_scratch_number;
        }

        public void setSmall_scratch_number(int small_scratch_number) {
            this.small_scratch_number = small_scratch_number;
        }

        public int getSurvey_speed() {
            return survey_speed;
        }

        public void setSurvey_speed(int survey_speed) {
            this.survey_speed = survey_speed;
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
    }
}
