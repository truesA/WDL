package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.util.List;

public class MainDataBean
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
        private List<Integer> M1_mn_now;
        private List<Integer> M1_times;
        private List<Integer> M2_mn_now;
        private List<Integer> M2_times;
        private List<Integer> T1_mn_now;
        private List<Integer> T1_times;
        private List<Integer> appoint_mn_now;
        private List<Integer> appoint_rate;
        private List<Integer> appoint_times;
        private List<Integer> goal_mn_achv_rate;
        private List<Integer> goal_mn_now;
        private List<Integer> goal_times;
        private List<Integer> goal_times_achv_rate;
        private HeaderBean header;
        private List<Integer> m1_rate;
        private List<Integer> m2_rate;
        private List<Integer> maint_mn_now;
        private List<Integer> maint_times;
        private List<List<Double>> mn_rate;
        private List<List<Double>> times_rate;
        private List<Integer> weekday_mn_now;
        private List<Integer> weekday_times;
        private List<Integer> weekend_mn_now;
        private List<Integer> weekend_times;

        public List<Integer> getAppoint_mn_now()
        {
            return this.appoint_mn_now;
        }

        public List<Integer> getAppoint_rate()
        {
            return this.appoint_rate;
        }

        public List<Integer> getAppoint_times()
        {
            return this.appoint_times;
        }

        public List<Integer> getGoal_mn_achv_rate()
        {
            return this.goal_mn_achv_rate;
        }

        public List<Integer> getGoal_mn_now()
        {
            return this.goal_mn_now;
        }

        public List<Integer> getGoal_times()
        {
            return this.goal_times;
        }

        public List<Integer> getGoal_times_achv_rate()
        {
            return this.goal_times_achv_rate;
        }

        public HeaderBean getHeader()
        {
            return this.header;
        }

        public List<Integer> getM1_mn_now()
        {
            return this.M1_mn_now;
        }

        public List<Integer> getM1_rate()
        {
            return this.m1_rate;
        }

        public List<Integer> getM1_times()
        {
            return this.M1_times;
        }

        public List<Integer> getM2_mn_now()
        {
            return this.M2_mn_now;
        }

        public List<Integer> getM2_rate()
        {
            return this.m2_rate;
        }

        public List<Integer> getM2_times()
        {
            return this.M2_times;
        }

        public List<Integer> getMaint_mn_now()
        {
            return this.maint_mn_now;
        }

        public List<Integer> getMaint_times()
        {
            return this.maint_times;
        }

        public List<List<Double>> getMn_rate()
        {
            return this.mn_rate;
        }

        public List<Integer> getT1_mn_now()
        {
            return this.T1_mn_now;
        }

        public List<Integer> getT1_times()
        {
            return this.T1_times;
        }

        public List<List<Double>> getTimes_rate()
        {
            return this.times_rate;
        }

        public List<Integer> getWeekday_mn_now()
        {
            return this.weekday_mn_now;
        }

        public List<Integer> getWeekday_times()
        {
            return this.weekday_times;
        }

        public List<Integer> getWeekend_mn_now()
        {
            return this.weekend_mn_now;
        }

        public List<Integer> getWeekend_times()
        {
            return this.weekend_times;
        }

        public void setAppoint_mn_now(List<Integer> paramList)
        {
            this.appoint_mn_now = paramList;
        }

        public void setAppoint_rate(List<Integer> paramList)
        {
            this.appoint_rate = paramList;
        }

        public void setAppoint_times(List<Integer> paramList)
        {
            this.appoint_times = paramList;
        }

        public void setGoal_mn_achv_rate(List<Integer> paramList)
        {
            this.goal_mn_achv_rate = paramList;
        }

        public void setGoal_mn_now(List<Integer> paramList)
        {
            this.goal_mn_now = paramList;
        }

        public void setGoal_times(List<Integer> paramList)
        {
            this.goal_times = paramList;
        }

        public void setGoal_times_achv_rate(List<Integer> paramList)
        {
            this.goal_times_achv_rate = paramList;
        }

        public void setHeader(HeaderBean paramHeaderBean)
        {
            this.header = paramHeaderBean;
        }

        public void setM1_mn_now(List<Integer> paramList)
        {
            this.M1_mn_now = paramList;
        }

        public void setM1_rate(List<Integer> paramList)
        {
            this.m1_rate = paramList;
        }

        public void setM1_times(List<Integer> paramList)
        {
            this.M1_times = paramList;
        }

        public void setM2_mn_now(List<Integer> paramList)
        {
            this.M2_mn_now = paramList;
        }

        public void setM2_rate(List<Integer> paramList)
        {
            this.m2_rate = paramList;
        }

        public void setM2_times(List<Integer> paramList)
        {
            this.M2_times = paramList;
        }

        public void setMaint_mn_now(List<Integer> paramList)
        {
            this.maint_mn_now = paramList;
        }

        public void setMaint_times(List<Integer> paramList)
        {
            this.maint_times = paramList;
        }

        public void setMn_rate(List<List<Double>> paramList)
        {
            this.mn_rate = paramList;
        }

        public void setT1_mn_now(List<Integer> paramList)
        {
            this.T1_mn_now = paramList;
        }

        public void setT1_times(List<Integer> paramList)
        {
            this.T1_times = paramList;
        }

        public void setTimes_rate(List<List<Double>> paramList)
        {
            this.times_rate = paramList;
        }

        public void setWeekday_mn_now(List<Integer> paramList)
        {
            this.weekday_mn_now = paramList;
        }

        public void setWeekday_times(List<Integer> paramList)
        {
            this.weekday_times = paramList;
        }

        public void setWeekend_mn_now(List<Integer> paramList)
        {
            this.weekend_mn_now = paramList;
        }

        public void setWeekend_times(List<Integer> paramList)
        {
            this.weekend_times = paramList;
        }

        public static class HeaderBean
                implements Serializable
        {
            private String request_time;
            private String response_time;

            public String getRequest_time()
            {
                return this.request_time;
            }

            public String getResponse_time()
            {
                return this.response_time;
            }

            public void setRequest_time(String paramString)
            {
                this.request_time = paramString;
            }

            public void setResponse_time(String paramString)
            {
                this.response_time = paramString;
            }
        }
    }
}