package com.wdl.jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */
import java.io.Serializable;

public class SeachBean
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
        private String Level;
        private int Xu;
        private int Zhe;
        private int userid;
        private String name;
        private String phone_number;
        private String plate_num;
        private int total_score;

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getLevel()
        {
            return this.Level;
        }

        public String getName()
        {
            return this.name;
        }

        public String getPhone_number()
        {
            return this.phone_number;
        }

        public String getPlate_num()
        {
            return this.plate_num;
        }

        public int getTotal_score()
        {
            return this.total_score;
        }

        public int getXu()
        {
            return this.Xu;
        }

        public int getZhe()
        {
            return this.Zhe;
        }


        public void setLevel(String paramString)
        {
            this.Level = paramString;
        }

        public void setName(String paramString)
        {
            this.name = paramString;
        }

        public void setPhone_number(String paramString)
        {
            this.phone_number = paramString;
        }

        public void setPlate_num(String paramString)
        {
            this.plate_num = paramString;
        }

        public void setTotal_score(int paramInt)
        {
            this.total_score = paramInt;
        }

        public void setXu(int paramInt)
        {
            this.Xu = paramInt;
        }

        public void setZhe(int paramInt)
        {
            this.Zhe = paramInt;
        }
    }
}