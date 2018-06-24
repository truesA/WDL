package com.wdl.jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.util.List;

public class UserAccount
        implements Serializable
{
    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code()
    {
        return this.error_code;
    }

    public String getReason()
    {
        return this.reason;
    }

    public ResultBean getResult()
    {
        return this.result;
    }

    public void setError_code(int paramInt)
    {
        this.error_code = paramInt;
    }

    public void setReason(String paramString)
    {
        this.reason = paramString;
    }

    public void setResult(ResultBean paramResultBean)
    {
        this.result = paramResultBean;
    }

    public static class ResultBean implements Serializable
    {
        private double K10;
        private int K15;
        private int K20;
        private double K5;
        private int Numb;
        private int age;
        private int birthday;
        private int body_;
        private double body_shop_sum;
        private int buy3free1;
        private int car_age;
        private int car_care;
        private double car_care_sum;
        private String car_model;
        private int car_purpose;
        private int children;
        private List<Integer> cred_score;
        private int day_mile_recent;
        private int economic;
        private int education;
        private double excellent_sum;
        private int excent_insurance;
        private int extension;
        private double gender;
        private int hobby;
        private int userid;
        private int insurance;
        private int insurance_date;
        private int km_per_day;
        private String location;
        private double loy_coef;
        private double maint_single;
        private double maint_sum;
        private int maint_times;
        private int marriage;
        private List<Integer> mile_gap;
        private String name;
        private int period;
        private String plate_number;
        private int position;
        private double repair_sum;
        private int repair_times;
        private String sale_date;
        private int small_scratch_number;
        private List<Integer> time_gap;
        private int wechat_appoint;
        private int wechat_id;
        private int work_field;

        public int getAge()
        {
            return this.age;
        }

        public int getBirthday()
        {
            return this.birthday;
        }

        public int getBody_()
        {
            return this.body_;
        }

        public double getBody_shop_sum()
        {
            return this.body_shop_sum;
        }

        public int getBuy3free1()
        {
            return this.buy3free1;
        }

        public int getCar_age()
        {
            return this.car_age;
        }

        public int getCar_care()
        {
            return this.car_care;
        }

        public double getCar_care_sum()
        {
            return this.car_care_sum;
        }

        public String getCar_model()
        {
            return this.car_model;
        }

        public int getCar_purpose()
        {
            return this.car_purpose;
        }

        public int getChildren()
        {
            return this.children;
        }

        public List<Integer> getCred_score()
        {
            return this.cred_score;
        }

        public int getDay_mile_recent()
        {
            return this.day_mile_recent;
        }

        public int getEconomic()
        {
            return this.economic;
        }

        public int getEducation()
        {
            return this.education;
        }

        public double getExcellent_sum()
        {
            return this.excellent_sum;
        }

        public int getExcent_insurance()
        {
            return this.excent_insurance;
        }

        public int getExtension()
        {
            return this.extension;
        }

        public double getGender()
        {
            return this.gender;
        }

        public int getHobby()
        {
            return this.hobby;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getInsurance()
        {
            return this.insurance;
        }

        public int getInsurance_date()
        {
            return this.insurance_date;
        }

        public double getK10()
        {
            return this.K10;
        }

        public int getK15()
        {
            return this.K15;
        }

        public int getK20()
        {
            return this.K20;
        }

        public double getK5()
        {
            return this.K5;
        }

        public int getKm_per_day()
        {
            return this.km_per_day;
        }

        public String getLocation()
        {
            return this.location;
        }

        public double getLoy_coef()
        {
            return this.loy_coef;
        }

        public double getMaint_single()
        {
            return this.maint_single;
        }

        public double getMaint_sum()
        {
            return this.maint_sum;
        }

        public int getMaint_times()
        {
            return this.maint_times;
        }

        public int getMarriage()
        {
            return this.marriage;
        }

        public List<Integer> getMile_gap()
        {
            return this.mile_gap;
        }

        public String getName()
        {
            return this.name;
        }

        public int getNumb()
        {
            return this.Numb;
        }

        public int getPeriod()
        {
            return this.period;
        }

        public String getPlate_number()
        {
            return this.plate_number;
        }

        public int getPosition()
        {
            return this.position;
        }

        public double getRepair_sum()
        {
            return this.repair_sum;
        }

        public int getRepair_times()
        {
            return this.repair_times;
        }

        public String getSale_date()
        {
            return this.sale_date;
        }

        public int getSmall_scratch_number()
        {
            return this.small_scratch_number;
        }

        public List<Integer> getTime_gap()
        {
            return this.time_gap;
        }

        public int getWechat_appoint()
        {
            return this.wechat_appoint;
        }

        public int getWechat_id()
        {
            return this.wechat_id;
        }

        public int getWork_field()
        {
            return this.work_field;
        }

        public void setAge(int paramInt)
        {
            this.age = paramInt;
        }

        public void setBirthday(int paramInt)
        {
            this.birthday = paramInt;
        }

        public void setBody_(int paramInt)
        {
            this.body_ = paramInt;
        }

        public void setBody_shop_sum(double paramDouble)
        {
            this.body_shop_sum = paramDouble;
        }

        public void setBuy3free1(int paramInt)
        {
            this.buy3free1 = paramInt;
        }

        public void setCar_age(int paramInt)
        {
            this.car_age = paramInt;
        }

        public void setCar_care(int paramInt)
        {
            this.car_care = paramInt;
        }

        public void setCar_care_sum(double paramDouble)
        {
            this.car_care_sum = paramDouble;
        }

        public void setCar_model(String paramString)
        {
            this.car_model = paramString;
        }

        public void setCar_purpose(int paramInt)
        {
            this.car_purpose = paramInt;
        }

        public void setChildren(int paramInt)
        {
            this.children = paramInt;
        }

        public void setCred_score(List<Integer> paramList)
        {
            this.cred_score = paramList;
        }

        public void setDay_mile_recent(int paramInt)
        {
            this.day_mile_recent = paramInt;
        }

        public void setEconomic(int paramInt)
        {
            this.economic = paramInt;
        }

        public void setEducation(int paramInt)
        {
            this.education = paramInt;
        }

        public void setExcellent_sum(double paramDouble)
        {
            this.excellent_sum = paramDouble;
        }

        public void setExcent_insurance(int paramInt)
        {
            this.excent_insurance = paramInt;
        }

        public void setExtension(int paramInt)
        {
            this.extension = paramInt;
        }

        public void setGender(double paramDouble)
        {
            this.gender = paramDouble;
        }

        public void setHobby(int paramInt)
        {
            this.hobby = paramInt;
        }


        public void setInsurance(int paramInt)
        {
            this.insurance = paramInt;
        }

        public void setInsurance_date(int paramInt)
        {
            this.insurance_date = paramInt;
        }

        public void setK10(double paramDouble)
        {
            this.K10 = paramDouble;
        }

        public void setK15(int paramInt)
        {
            this.K15 = paramInt;
        }

        public void setK20(int paramInt)
        {
            this.K20 = paramInt;
        }

        public void setK5(double paramDouble)
        {
            this.K5 = paramDouble;
        }

        public void setKm_per_day(int paramInt)
        {
            this.km_per_day = paramInt;
        }

        public void setLocation(String paramString)
        {
            this.location = paramString;
        }

        public void setLoy_coef(double paramDouble)
        {
            this.loy_coef = paramDouble;
        }

        public void setMaint_single(double paramDouble)
        {
            this.maint_single = paramDouble;
        }

        public void setMaint_sum(double paramDouble)
        {
            this.maint_sum = paramDouble;
        }

        public void setMaint_times(int paramInt)
        {
            this.maint_times = paramInt;
        }

        public void setMarriage(int paramInt)
        {
            this.marriage = paramInt;
        }

        public void setMile_gap(List<Integer> paramList)
        {
            this.mile_gap = paramList;
        }

        public void setName(String paramString)
        {
            this.name = paramString;
        }

        public void setNumb(int paramInt)
        {
            this.Numb = paramInt;
        }

        public void setPeriod(int paramInt)
        {
            this.period = paramInt;
        }

        public void setPlate_number(String paramString)
        {
            this.plate_number = paramString;
        }

        public void setPosition(int paramInt)
        {
            this.position = paramInt;
        }

        public void setRepair_sum(double paramDouble)
        {
            this.repair_sum = paramDouble;
        }

        public void setRepair_times(int paramInt)
        {
            this.repair_times = paramInt;
        }

        public void setSale_date(String paramString)
        {
            this.sale_date = paramString;
        }

        public void setSmall_scratch_number(int paramInt)
        {
            this.small_scratch_number = paramInt;
        }

        public void setTime_gap(List<Integer> paramList)
        {
            this.time_gap = paramList;
        }

        public void setWechat_appoint(int paramInt)
        {
            this.wechat_appoint = paramInt;
        }

        public void setWechat_id(int paramInt)
        {
            this.wechat_id = paramInt;
        }

        public void setWork_field(int paramInt)
        {
            this.work_field = paramInt;
        }
    }
}