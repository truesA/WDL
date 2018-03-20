package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.util.List;

public class UserMainMsg
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

    public static class ResultBean
            implements Serializable
    {
        private int K15;
        private int K20;
        private String birthday;
        private int buy3free1;
        private int car_care;
        private String car_purpose;
        private List<Integer> cred_score;
        private int day_mile_recent;
        private int economy;
        private int excent_insurance;
        private int id;
        private int jikuikehu;
        private int km_per_day;
        private double loy_coef;
        private int maint_single;
        private int maint_sum;
        private int maint_times;
        private List<Integer> mile_gap;
        private String name;
        private int period;
        private String plate_num;
        private int repair_times;
        private int small_scratch_number;
        private List<Integer> time_gap;
        private int wechat_appoint;
        private String work_field;
        private double yuyuegongshi;

        public String getBirthday()
        {
            return this.birthday;
        }

        public int getBuy3free1()
        {
            return this.buy3free1;
        }

        public int getCar_care()
        {
            return this.car_care;
        }

        public String getCar_purpose()
        {
            return this.car_purpose;
        }

        public List<Integer> getCred_score()
        {
            return this.cred_score;
        }

        public int getDay_mile_recent()
        {
            return this.day_mile_recent;
        }

        public int getEconomy()
        {
            return this.economy;
        }

        public int getExcent_insurance()
        {
            return this.excent_insurance;
        }

        public int getId()
        {
            return this.id;
        }

        public int getJikuikehu()
        {
            return this.jikuikehu;
        }

        public int getK15()
        {
            return this.K15;
        }

        public int getK20()
        {
            return this.K20;
        }

        public int getKm_per_day()
        {
            return this.km_per_day;
        }

        public double getLoy_coef()
        {
            return this.loy_coef;
        }

        public int getMaint_single()
        {
            return this.maint_single;
        }

        public int getMaint_sum()
        {
            return this.maint_sum;
        }

        public int getMaint_times()
        {
            return this.maint_times;
        }

        public List<Integer> getMile_gap()
        {
            return this.mile_gap;
        }

        public String getName()
        {
            return this.name;
        }

        public int getPeriod()
        {
            return this.period;
        }

        public String getPlate_num()
        {
            return this.plate_num;
        }

        public int getRepair_times()
        {
            return this.repair_times;
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

        public String getWork_field()
        {
            return this.work_field;
        }

        public double getYuyuegongshi()
        {
            return this.yuyuegongshi;
        }

        public void setBirthday(String paramString)
        {
            this.birthday = paramString;
        }

        public void setBuy3free1(int paramInt)
        {
            this.buy3free1 = paramInt;
        }

        public void setCar_care(int paramInt)
        {
            this.car_care = paramInt;
        }

        public void setCar_purpose(String paramString)
        {
            this.car_purpose = paramString;
        }

        public void setCred_score(List<Integer> paramList)
        {
            this.cred_score = paramList;
        }

        public void setDay_mile_recent(int paramInt)
        {
            this.day_mile_recent = paramInt;
        }

        public void setEconomy(int paramInt)
        {
            this.economy = paramInt;
        }

        public void setExcent_insurance(int paramInt)
        {
            this.excent_insurance = paramInt;
        }

        public void setId(int paramInt)
        {
            this.id = paramInt;
        }

        public void setJikuikehu(int paramInt)
        {
            this.jikuikehu = paramInt;
        }

        public void setK15(int paramInt)
        {
            this.K15 = paramInt;
        }

        public void setK20(int paramInt)
        {
            this.K20 = paramInt;
        }

        public void setKm_per_day(int paramInt)
        {
            this.km_per_day = paramInt;
        }

        public void setLoy_coef(double paramDouble)
        {
            this.loy_coef = paramDouble;
        }

        public void setMaint_single(int paramInt)
        {
            this.maint_single = paramInt;
        }

        public void setMaint_sum(int paramInt)
        {
            this.maint_sum = paramInt;
        }

        public void setMaint_times(int paramInt)
        {
            this.maint_times = paramInt;
        }

        public void setMile_gap(List<Integer> paramList)
        {
            this.mile_gap = paramList;
        }

        public void setName(String paramString)
        {
            this.name = paramString;
        }

        public void setPeriod(int paramInt)
        {
            this.period = paramInt;
        }

        public void setPlate_num(String paramString)
        {
            this.plate_num = paramString;
        }

        public void setRepair_times(int paramInt)
        {
            this.repair_times = paramInt;
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

        public void setWork_field(String paramString)
        {
            this.work_field = paramString;
        }

        public void setYuyuegongshi(double paramDouble)
        {
            this.yuyuegongshi = paramDouble;
        }
    }
}