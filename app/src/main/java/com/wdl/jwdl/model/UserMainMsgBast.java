package com.wdl.jwdl.model;

import java.io.Serializable;
import java.util.List;

/**
 * author：lhm on 2018/3/25 20:36
 * <p>
 * email：3186834196@qq.com
 */
public class UserMainMsgBast  implements Serializable{


    /**
     * error_code : 200
     * reason : 用户详细信息已正确返回!
     * result : {"K10":0,"K15":0,"K20":0,"K5":0,"Numb":"","age":"","birthday":"","body_shop":0,"body_shop_sum":0,"body_shop_sum_percent":41,"buy3free1":0,"car_age":"","car_care":0,"car_care_sum":0,"car_care_sum_percent":43,"car_model":"ACV40L-JEAGKC","car_purpose":"","children":"","cred_score":[100,100,300,200,100],"cred_score_percent":[34,42,36,41,38],"day_mile_recent":37,"economy":0,"education":"","excellent_sum":0,"excellent_sum_percent":45,"excent_insurance":0,"extension":0,"gender":"未填写","hobby":"","id":0,"insurance":0,"insurance_date":"","jikuikehu":61,"km_per_day":37,"location":"江西省吉安市永新县禾川镇学背居民区北门路一区","loy_coef":0.44600612557400005,"maint_single":2596,"maint_single_percent":33,"maint_sum":2596,"maint_sum_percent":36,"maint_times":21,"marriage":"","mile_gap":[4575,4966,7340],"name":"谭克福","period":159.190638713,"plate_num":"赣D-T8866","position":"","repair_sum":16725,"repair_sum_percent":38,"repair_times":10,"sale_date":"2007-12-22","small_scratch_number":0,"time_gap":[71,107,113],"wechat_appoint":0,"wechat_id":"Harry_Brown_2019","work_field":"","yuyuegongshi":8.5}
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
         * K10 : 0
         * K15 : 0
         * K20 : 0
         * K5 : 0
         * Numb :
         * age :
         * birthday :
         * body_shop : 0
         * body_shop_sum : 0
         * body_shop_sum_percent : 41
         * buy3free1 : 0
         * car_age :
         * car_care : 0
         * car_care_sum : 0
         * car_care_sum_percent : 43
         * car_model : ACV40L-JEAGKC
         * car_purpose :
         * children :
         * cred_score : [100,100,300,200,100]
         * cred_score_percent : [34,42,36,41,38]
         * day_mile_recent : 37
         * economy : 0
         * education :
         * excellent_sum : 0
         * excellent_sum_percent : 45
         * excent_insurance : 0
         * extension : 0
         * gender : 未填写
         * hobby :
         * id : 0
         * insurance : 0
         * insurance_date :
         * jikuikehu : 61
         * km_per_day : 37
         * location : 江西省吉安市永新县禾川镇学背居民区北门路一区
         * loy_coef : 0.44600612557400005
         * maint_single : 2596
         * maint_single_percent : 33
         * maint_sum : 2596
         * maint_sum_percent : 36
         * maint_times : 21
         * marriage :
         * mile_gap : [4575,4966,7340]
         * name : 谭克福
         * period : 159.190638713
         * plate_num : 赣D-T8866
         * position :
         * repair_sum : 16725
         * repair_sum_percent : 38
         * repair_times : 10
         * sale_date : 2007-12-22
         * small_scratch_number : 0
         * time_gap : [71,107,113]
         * wechat_appoint : 0
         * wechat_id : Harry_Brown_2019
         * work_field :
         * yuyuegongshi : 8.5
         */

        private int K10;
        private int K15;
        private int K20;
        private int K5;
        private String Numb;
        private String age;
        private String birthday;
        private int body_shop;
        private int body_shop_sum;
        private int body_shop_sum_percent;
        private int buy3free1;
        private String car_age;
        private int car_care;
        private int car_care_sum;
        private int car_care_sum_percent;
        private String car_model;
        private String car_purpose;
        private String children;
        private int day_mile_recent;
        private int economy;
        private String education;
        private int excellent_sum;
        private int excellent_sum_percent;
        private int excent_insurance;
        private int extension;
        private String gender;
        private String hobby;
        private int userid;
        private int insurance;
        private String insurance_date;
        private int jikuikehu;
        private int km_per_day;
        private String location;
        private double loy_coef;
        private int maint_single;
        private int maint_single_percent;
        private int maint_sum;
        private int maint_sum_percent;
        private int maint_times;
        private String marriage;
        private String name;
        private double period;
        private String plate_num;
        private String position;
        private int repair_sum;
        private int repair_sum_percent;
        private int repair_times;
        private String sale_date;
        private int small_scratch_number;
        private int wechat_appoint;
        private String wechat_id;
        private String work_field;
        private double yuyuegongshi;
        private List<Integer> cred_score;
        private List<Integer> cred_score_percent;
        private List<Integer> mile_gap;
        private List<Integer> time_gap;

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

        public int getBody_shop() {
            return body_shop;
        }

        public void setBody_shop(int body_shop) {
            this.body_shop = body_shop;
        }

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

        public int getBuy3free1() {
            return buy3free1;
        }

        public void setBuy3free1(int buy3free1) {
            this.buy3free1 = buy3free1;
        }

        public String getCar_age() {
            return car_age;
        }

        public void setCar_age(String car_age) {
            this.car_age = car_age;
        }

        public int getCar_care() {
            return car_care;
        }

        public void setCar_care(int car_care) {
            this.car_care = car_care;
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

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
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

        public int getExcent_insurance() {
            return excent_insurance;
        }

        public void setExcent_insurance(int excent_insurance) {
            this.excent_insurance = excent_insurance;
        }

        public int getExtension() {
            return extension;
        }

        public void setExtension(int extension) {
            this.extension = extension;
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

        public String getInsurance_date() {
            return insurance_date;
        }

        public void setInsurance_date(String insurance_date) {
            this.insurance_date = insurance_date;
        }

        public int getJikuikehu() {
            return jikuikehu;
        }

        public void setJikuikehu(int jikuikehu) {
            this.jikuikehu = jikuikehu;
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

        public int getMaint_times() {
            return maint_times;
        }

        public void setMaint_times(int maint_times) {
            this.maint_times = maint_times;
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

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
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

        public int getRepair_times() {
            return repair_times;
        }

        public void setRepair_times(int repair_times) {
            this.repair_times = repair_times;
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

        public List<Integer> getCred_score_percent() {
            return cred_score_percent;
        }

        public void setCred_score_percent(List<Integer> cred_score_percent) {
            this.cred_score_percent = cred_score_percent;
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
