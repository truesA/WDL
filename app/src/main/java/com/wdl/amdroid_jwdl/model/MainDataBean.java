package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.util.List;

public class MainDataBean implements Serializable {

    /**
     * error_code : 200
     * reason : SA数据已更新!
     * result : {"M1_mn_now":[5547,4662],"M1_times":[13,7],"M2_mn_now":[5492,5107],"M2_times":[11,10],"T1_mn_now":[0,0],"T1_times":[0,0],"appoint_mn_now":[0,0],"appoint_rate":[0,0],"appoint_times":[0,0],"goal_mn_achv_rate":[231,180],"goal_mn_now":[463194,361259],"goal_times":[344,343],"goal_times_achv_rate":[229,228],"header":{"request_time":"2018-03-22 10:55:45.463889","response_time":"2018-03-22 10:55:46.645424"},"m1_rate":[65,58],"m2_rate":[55,52],"maint_mn_now":[77499,63256],"maint_times":[235,233],"mn_rate":[[-94,-92,-84,-78,-71,-74,-78,-80,-65,-64,-55,-36,-35,-30,-29,-28,21,64,58,70,71,70,64,82,78,72,80,75,71,67,131],[-86,-88,-71,-65,-66,-71,-75,-78,-70,-69,-19,-8,-14,-10,-14,-5,2,4,27,36,42,42,43,52,49,44,45,41,43,42,80]],"times_rate":[[-58,-58,-24,-1,11,0,-14,-25,19,15,22,41,43,53,59,61,67,75,72,72,78,88,85,83,85,81,79,78,127,125,129],[3,-38,-10,3,3,-10,-23,-32,-3,-4,1,15,12,26,28,42,39,40,42,41,44,51,51,53,53,51,56,63,116,119,128]],"weekday_mn_now":[0,0],"weekday_times":[0,0],"weekend_mn_now":[0,0],"weekend_times":[0,0]}
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

    public static class ResultBean implements Serializable {
        /**
         * M1_mn_now : [5547,4662]
         * M1_times : [13,7]
         * M2_mn_now : [5492,5107]
         * M2_times : [11,10]
         * T1_mn_now : [0,0]
         * T1_times : [0,0]
         * appoint_mn_now : [0,0]
         * appoint_rate : [0,0]
         * appoint_times : [0,0]
         * goal_mn_achv_rate : [231,180]
         * goal_mn_now : [463194,361259]
         * goal_times : [344,343]
         * goal_times_achv_rate : [229,228]
         * header : {"request_time":"2018-03-22 10:55:45.463889","response_time":"2018-03-22 10:55:46.645424"}
         * m1_rate : [65,58]
         * m2_rate : [55,52]
         * maint_mn_now : [77499,63256]
         * maint_times : [235,233]
         * mn_rate : [[-94,-92,-84,-78,-71,-74,-78,-80,-65,-64,-55,-36,-35,-30,-29,-28,21,64,58,70,71,70,64,82,78,72,80,75,71,67,131],[-86,-88,-71,-65,-66,-71,-75,-78,-70,-69,-19,-8,-14,-10,-14,-5,2,4,27,36,42,42,43,52,49,44,45,41,43,42,80]]
         * times_rate : [[-58,-58,-24,-1,11,0,-14,-25,19,15,22,41,43,53,59,61,67,75,72,72,78,88,85,83,85,81,79,78,127,125,129],[3,-38,-10,3,3,-10,-23,-32,-3,-4,1,15,12,26,28,42,39,40,42,41,44,51,51,53,53,51,56,63,116,119,128]]
         * weekday_mn_now : [0,0]
         * weekday_times : [0,0]
         * weekend_mn_now : [0,0]
         * weekend_times : [0,0]
         */

        private HeaderBean header;
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
        private List<Integer> m1_rate;
        private List<Integer> m2_rate;
        private List<Integer> maint_mn_now;
        private List<Integer> maint_times;
        private List<List<Double>> mn_rate;
        private List<List<Double>> times_rate;
        private List<Double> weekday_mn_now;
        private List<Double> weekday_times;
        private List<Double> weekend_mn_now;
        private List<Double> weekend_times;

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public List<Integer> getM1_mn_now() {
            return M1_mn_now;
        }

        public void setM1_mn_now(List<Integer> M1_mn_now) {
            this.M1_mn_now = M1_mn_now;
        }

        public List<Integer> getM1_times() {
            return M1_times;
        }

        public void setM1_times(List<Integer> M1_times) {
            this.M1_times = M1_times;
        }

        public List<Integer> getM2_mn_now() {
            return M2_mn_now;
        }

        public void setM2_mn_now(List<Integer> M2_mn_now) {
            this.M2_mn_now = M2_mn_now;
        }

        public List<Integer> getM2_times() {
            return M2_times;
        }

        public void setM2_times(List<Integer> M2_times) {
            this.M2_times = M2_times;
        }

        public List<Integer> getT1_mn_now() {
            return T1_mn_now;
        }

        public void setT1_mn_now(List<Integer> T1_mn_now) {
            this.T1_mn_now = T1_mn_now;
        }

        public List<Integer> getT1_times() {
            return T1_times;
        }

        public void setT1_times(List<Integer> T1_times) {
            this.T1_times = T1_times;
        }

        public List<Integer> getAppoint_mn_now() {
            return appoint_mn_now;
        }

        public void setAppoint_mn_now(List<Integer> appoint_mn_now) {
            this.appoint_mn_now = appoint_mn_now;
        }

        public List<Integer> getAppoint_rate() {
            return appoint_rate;
        }

        public void setAppoint_rate(List<Integer> appoint_rate) {
            this.appoint_rate = appoint_rate;
        }

        public List<Integer> getAppoint_times() {
            return appoint_times;
        }

        public void setAppoint_times(List<Integer> appoint_times) {
            this.appoint_times = appoint_times;
        }

        public List<Integer> getGoal_mn_achv_rate() {
            return goal_mn_achv_rate;
        }

        public void setGoal_mn_achv_rate(List<Integer> goal_mn_achv_rate) {
            this.goal_mn_achv_rate = goal_mn_achv_rate;
        }

        public List<Integer> getGoal_mn_now() {
            return goal_mn_now;
        }

        public void setGoal_mn_now(List<Integer> goal_mn_now) {
            this.goal_mn_now = goal_mn_now;
        }

        public List<Integer> getGoal_times() {
            return goal_times;
        }

        public void setGoal_times(List<Integer> goal_times) {
            this.goal_times = goal_times;
        }

        public List<Integer> getGoal_times_achv_rate() {
            return goal_times_achv_rate;
        }

        public void setGoal_times_achv_rate(List<Integer> goal_times_achv_rate) {
            this.goal_times_achv_rate = goal_times_achv_rate;
        }

        public List<Integer> getM1_rate() {
            return m1_rate;
        }

        public void setM1_rate(List<Integer> m1_rate) {
            this.m1_rate = m1_rate;
        }

        public List<Integer> getM2_rate() {
            return m2_rate;
        }

        public void setM2_rate(List<Integer> m2_rate) {
            this.m2_rate = m2_rate;
        }

        public List<Integer> getMaint_mn_now() {
            return maint_mn_now;
        }

        public void setMaint_mn_now(List<Integer> maint_mn_now) {
            this.maint_mn_now = maint_mn_now;
        }

        public List<Integer> getMaint_times() {
            return maint_times;
        }

        public void setMaint_times(List<Integer> maint_times) {
            this.maint_times = maint_times;
        }

        public List<List<Double>> getMn_rate() {
            return mn_rate;
        }

        public void setMn_rate(List<List<Double>> mn_rate) {
            this.mn_rate = mn_rate;
        }

        public List<List<Double>> getTimes_rate() {
            return times_rate;
        }

        public void setTimes_rate(List<List<Double>> times_rate) {
            this.times_rate = times_rate;
        }

        public List<Double> getWeekday_mn_now() {
            return weekday_mn_now;
        }

        public void setWeekday_mn_now(List<Double> weekday_mn_now) {
            this.weekday_mn_now = weekday_mn_now;
        }

        public List<Double> getWeekday_times() {
            return weekday_times;
        }

        public void setWeekday_times(List<Double> weekday_times) {
            this.weekday_times = weekday_times;
        }

        public List<Double> getWeekend_mn_now() {
            return weekend_mn_now;
        }

        public void setWeekend_mn_now(List<Double> weekend_mn_now) {
            this.weekend_mn_now = weekend_mn_now;
        }

        public List<Double> getWeekend_times() {
            return weekend_times;
        }

        public void setWeekend_times(List<Double> weekend_times) {
            this.weekend_times = weekend_times;
        }

        public static class HeaderBean {
            /**
             * request_time : 2018-03-22 10:55:45.463889
             * response_time : 2018-03-22 10:55:46.645424
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