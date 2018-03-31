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
     * result : {"Numb":"17611499018","age":"","birthday":"","car_age":"","car_model":"ACV40L-JEAGKC","car_purpose":"","children":"","education":"","gender":"未填写","hobby":"","id":0,"identity_percent":34,"identity_score":0,"insurance_date":"","km_per_day":37.735849056603776,"location":"江西省吉安市永新县禾川镇学背居民区北门路一区","marriage":"","name":"谭克福","plate_num":"赣D-T8866","position":"","sale_date":"2007-12-22","small_scratch_number":0,"wechat_id":"Harry_Brown_2019","work_field":""}
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
         * Numb : 17611499018
         * age :
         * birthday :
         * car_age :
         * car_model : ACV40L-JEAGKC
         * car_purpose :
         * children :
         * education :
         * gender : 未填写
         * hobby :
         * id : 0
         * identity_percent : 34
         * identity_score : 0
         * insurance_date :
         * km_per_day : 37.735849056603776
         * location : 江西省吉安市永新县禾川镇学背居民区北门路一区
         * marriage :
         * name : 谭克福
         * plate_num : 赣D-T8866
         * position :
         * sale_date : 2007-12-22
         * small_scratch_number : 0
         * wechat_id : Harry_Brown_2019
         * work_field :
         */

        private String Numb;
        private String age;
        private String birthday;
        private String car_age;
        private String car_model;
        private String car_purpose;
        private String children;
        private String education;
        private String gender;
        private String hobby;
        private int id;
        private int identity_percent;
        private int identity_score;
        private String insurance_date;
        private double km_per_day;
        private String location;
        private String marriage;
        private String name;
        private String plate_num;
        private String position;
        private String sale_date;
        private int small_scratch_number;
        private String wechat_id;
        private String work_field;

        public String getNumb() {
            return Numb;
        }

        public void setNumb(String Numb) {
            this.Numb = Numb;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getCar_age() {
            return car_age;
        }

        public void setCar_age(String car_age) {
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

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
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

        public double getKm_per_day() {
            return km_per_day;
        }

        public void setKm_per_day(double km_per_day) {
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
