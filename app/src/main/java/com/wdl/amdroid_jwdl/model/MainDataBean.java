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
     * result : {"KPI":{"appoint_enter_max":500,"appoint_enter_me":0,"appoint_enter_other":0,"appoint_max":500,"appoint_me":0,"appoint_other":0,"appoint_success_rate_max":100,"appoint_success_rate_me":0,"appoint_success_rate_other":0,"collection_max":1000,"collection_me":0,"collection_other":0,"continue_max":500,"continue_me":0,"continue_other":0,"enter_success_rate_max":100,"enter_success_rate_me":0,"enter_success_rate_other":0,"giveup_max":100,"giveup_me":0,"giveup_other":0,"loss_max":100,"loss_me":0,"loss_other":0,"unsolved_collection_max":100,"unsolved_collection_me":0,"unsolved_collection_other":0},"KPI_appoint_rank":[1,1],"KPI_enter_rank":[1,1],"KPI_enter_times_me":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],"KPI_enter_times_other":[0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"SA":["SA2"],"SA_month":1,"SA_year":2018,"appoint_rate":[0,0],"backgrounddown":[0,0,0,0,0,0,-150,-150,0,0,0,0,0,-150,-150,0,0,0,0,0,-150,-150,0,0,0,0,0,-150,-150,0,0],"backgroundup":[0,0,0,0,0,0,150,150,0,0,0,0,0,150,150,0,0,0,0,0,150,150,0,0,0,0,0,150,150,0,0],"goal_mn_achv_rate":[0,0],"goal_times_achv_rate":[0,1],"header":{"request_time":"2018-06-19 01:48:55","response_time":"2018-06-19 01:48:57"},"mn":{"M1_mn_now_max":100000,"M1_mn_now_me":0,"M1_mn_now_other":0,"M2_mn_now_max":100000,"M2_mn_now_me":0,"M2_mn_now_other":0,"T1_mn_now_max":300000,"T1_mn_now_me":0,"T1_mn_now_other":1800,"add_mn_now_max":100000,"add_mn_now_me":0,"add_mn_now_other":0,"appoint_mn_now_max":200000,"appoint_mn_now_me":0,"appoint_mn_now_other":0,"excelt_mn_now_max":100000,"excelt_mn_now_me":0,"excelt_mn_now_other":0,"goal_mn_now_max":300000,"goal_mn_now_me":0,"goal_mn_now_other":1800,"maint_mn_now_max":200000,"maint_mn_now_me":0,"maint_mn_now_other":0,"repair_mn_now_max":200000,"repair_mn_now_me":0,"repair_mn_now_other":0},"mn_rate_me":[-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100],"mn_rate_other":[-100,-100,-100,-100,-100,-100,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99],"times":{"M1_goal_max":100,"M1_goal_me":19,"M1_goal_other":19,"M1_star_goal_max":100,"M1_star_goal_me":0,"M1_star_goal_other":0,"M1_times_max":135,"M1_times_me":0,"M1_times_other":0,"M2_goal_max":100,"M2_goal_me":19,"M2_goal_other":19,"M2_star_goal_max":100,"M2_star_goal_me":0,"M2_star_goal_other":0,"M2_times_max":135,"M2_times_me":0,"M2_times_other":0,"T1_times_max":405,"T1_times_me":1,"T1_times_other":3,"add_times_max":135,"add_times_me":0,"add_times_other":0,"appoint_times_max":270,"appoint_times_me":0,"appoint_times_other":0,"excelt_times_max":135,"excelt_times_me":0,"excelt_times_other":0,"goal_times_max":405,"goal_times_me":1,"goal_times_other":3,"maint_times_max":270,"maint_times_me":0,"maint_times_other":0,"ontime_times_max":405,"ontime_times_me":0,"ontime_times_other":0,"repair_times_max":270,"repair_times_me":0,"repair_times_other":0},"times_rate_me":[-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-99],"times_rate_other":[-100,-100,-100,-100,-100,-100,-98,-98,-98,-98,-98,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-98],"weekday_mn_now":[201,199],"weekday_times":[270,268],"weekend_mn_now":[281,278],"weekend_times":[377,374]}
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
         * KPI : {"appoint_enter_max":500,"appoint_enter_me":0,"appoint_enter_other":0,"appoint_max":500,"appoint_me":0,"appoint_other":0,"appoint_success_rate_max":100,"appoint_success_rate_me":0,"appoint_success_rate_other":0,"collection_max":1000,"collection_me":0,"collection_other":0,"continue_max":500,"continue_me":0,"continue_other":0,"enter_success_rate_max":100,"enter_success_rate_me":0,"enter_success_rate_other":0,"giveup_max":100,"giveup_me":0,"giveup_other":0,"loss_max":100,"loss_me":0,"loss_other":0,"unsolved_collection_max":100,"unsolved_collection_me":0,"unsolved_collection_other":0}
         * KPI_appoint_rank : [1,1]
         * KPI_enter_rank : [1,1]
         * KPI_enter_times_me : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
         * KPI_enter_times_other : [0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
         * SA : ["SA2"]
         * SA_month : 1
         * SA_year : 2018
         * appoint_rate : [0,0]
         * backgrounddown : [0,0,0,0,0,0,-150,-150,0,0,0,0,0,-150,-150,0,0,0,0,0,-150,-150,0,0,0,0,0,-150,-150,0,0]
         * backgroundup : [0,0,0,0,0,0,150,150,0,0,0,0,0,150,150,0,0,0,0,0,150,150,0,0,0,0,0,150,150,0,0]
         * goal_mn_achv_rate : [0,0]
         * goal_times_achv_rate : [0,1]
         * header : {"request_time":"2018-06-19 01:48:55","response_time":"2018-06-19 01:48:57"}
         * mn : {"M1_mn_now_max":100000,"M1_mn_now_me":0,"M1_mn_now_other":0,"M2_mn_now_max":100000,"M2_mn_now_me":0,"M2_mn_now_other":0,"T1_mn_now_max":300000,"T1_mn_now_me":0,"T1_mn_now_other":1800,"add_mn_now_max":100000,"add_mn_now_me":0,"add_mn_now_other":0,"appoint_mn_now_max":200000,"appoint_mn_now_me":0,"appoint_mn_now_other":0,"excelt_mn_now_max":100000,"excelt_mn_now_me":0,"excelt_mn_now_other":0,"goal_mn_now_max":300000,"goal_mn_now_me":0,"goal_mn_now_other":1800,"maint_mn_now_max":200000,"maint_mn_now_me":0,"maint_mn_now_other":0,"repair_mn_now_max":200000,"repair_mn_now_me":0,"repair_mn_now_other":0}
         * mn_rate_me : [-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100]
         * mn_rate_other : [-100,-100,-100,-100,-100,-100,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99]
         * times : {"M1_goal_max":100,"M1_goal_me":19,"M1_goal_other":19,"M1_star_goal_max":100,"M1_star_goal_me":0,"M1_star_goal_other":0,"M1_times_max":135,"M1_times_me":0,"M1_times_other":0,"M2_goal_max":100,"M2_goal_me":19,"M2_goal_other":19,"M2_star_goal_max":100,"M2_star_goal_me":0,"M2_star_goal_other":0,"M2_times_max":135,"M2_times_me":0,"M2_times_other":0,"T1_times_max":405,"T1_times_me":1,"T1_times_other":3,"add_times_max":135,"add_times_me":0,"add_times_other":0,"appoint_times_max":270,"appoint_times_me":0,"appoint_times_other":0,"excelt_times_max":135,"excelt_times_me":0,"excelt_times_other":0,"goal_times_max":405,"goal_times_me":1,"goal_times_other":3,"maint_times_max":270,"maint_times_me":0,"maint_times_other":0,"ontime_times_max":405,"ontime_times_me":0,"ontime_times_other":0,"repair_times_max":270,"repair_times_me":0,"repair_times_other":0}
         * times_rate_me : [-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-99]
         * times_rate_other : [-100,-100,-100,-100,-100,-100,-98,-98,-98,-98,-98,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-99,-98]
         * weekday_mn_now : [201,199]
         * weekday_times : [270,268]
         * weekend_mn_now : [281,278]
         * weekend_times : [377,374]
         */

        private KPIBean KPI;
        private int sa_month;
        private int sa_year;
        private HeaderBean header;
        private MnBean mn;
        private TimesBean times;
        private List<Integer> KPI_appoint_rank;
        private List<Integer> KPI_enter_rank;
        private List<Double> KPI_enter_times_me;
        private List<Double> KPI_enter_times_other;
        private List<String> SAname;
        private List<Integer> appoint_rate;
        private List<Integer> backgrounddown;
        private List<Integer> backgroundup;
        private List<Integer> goal_mn_achv_rate;
        private List<Integer> goal_times_achv_rate;
        private List<Double> mn_rate_me;
        private List<Double> mn_rate_other;
        private List<Double> times_rate_me;
        private List<Double> times_rate_other;
        private List<Double> weekday_mn_now;
        private List<Double> weekday_times;
        private List<Double> weekend_mn_now;
        private List<Double> weekend_times;

        public KPIBean getKPI() {
            return KPI;
        }

        public void setKPI(KPIBean KPI) {
            this.KPI = KPI;
        }

        public int getSa_month() {
            return sa_month;
        }

        public void setSa_month(int sa_month) {
            this.sa_month = sa_month;
        }

        public int getSa_year() {
            return sa_year;
        }

        public void setSa_year(int sa_year) {
            this.sa_year = sa_year;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public MnBean getMn() {
            return mn;
        }

        public void setMn(MnBean mn) {
            this.mn = mn;
        }

        public TimesBean getTimes() {
            return times;
        }

        public void setTimes(TimesBean times) {
            this.times = times;
        }

        public List<Integer> getKPI_appoint_rank() {
            return KPI_appoint_rank;
        }

        public void setKPI_appoint_rank(List<Integer> KPI_appoint_rank) {
            this.KPI_appoint_rank = KPI_appoint_rank;
        }

        public List<Integer> getKPI_enter_rank() {
            return KPI_enter_rank;
        }

        public void setKPI_enter_rank(List<Integer> KPI_enter_rank) {
            this.KPI_enter_rank = KPI_enter_rank;
        }

        public List<Double> getKPI_enter_times_me() {
            return KPI_enter_times_me;
        }

        public void setKPI_enter_times_me(List<Double> KPI_enter_times_me) {
            this.KPI_enter_times_me = KPI_enter_times_me;
        }

        public List<Double> getKPI_enter_times_other() {
            return KPI_enter_times_other;
        }

        public void setKPI_enter_times_other(List<Double> KPI_enter_times_other) {
            this.KPI_enter_times_other = KPI_enter_times_other;
        }

        public List<String> getSAname() {
            return SAname;
        }

        public void setSAname(List<String> SAname) {
            this.SAname = SAname;
        }

        public List<Integer> getAppoint_rate() {
            return appoint_rate;
        }

        public void setAppoint_rate(List<Integer> appoint_rate) {
            this.appoint_rate = appoint_rate;
        }

        public List<Integer> getBackgrounddown() {
            return backgrounddown;
        }

        public void setBackgrounddown(List<Integer> backgrounddown) {
            this.backgrounddown = backgrounddown;
        }

        public List<Integer> getBackgroundup() {
            return backgroundup;
        }

        public void setBackgroundup(List<Integer> backgroundup) {
            this.backgroundup = backgroundup;
        }

        public List<Integer> getGoal_mn_achv_rate() {
            return goal_mn_achv_rate;
        }

        public void setGoal_mn_achv_rate(List<Integer> goal_mn_achv_rate) {
            this.goal_mn_achv_rate = goal_mn_achv_rate;
        }

        public List<Integer> getGoal_times_achv_rate() {
            return goal_times_achv_rate;
        }

        public void setGoal_times_achv_rate(List<Integer> goal_times_achv_rate) {
            this.goal_times_achv_rate = goal_times_achv_rate;
        }

        public List<Double> getMn_rate_me() {
            return mn_rate_me;
        }

        public void setMn_rate_me(List<Double> mn_rate_me) {
            this.mn_rate_me = mn_rate_me;
        }

        public List<Double> getMn_rate_other() {
            return mn_rate_other;
        }

        public void setMn_rate_other(List<Double> mn_rate_other) {
            this.mn_rate_other = mn_rate_other;
        }

        public List<Double> getTimes_rate_me() {
            return times_rate_me;
        }

        public void setTimes_rate_me(List<Double> times_rate_me) {
            this.times_rate_me = times_rate_me;
        }

        public List<Double> getTimes_rate_other() {
            return times_rate_other;
        }

        public void setTimes_rate_other(List<Double> times_rate_other) {
            this.times_rate_other = times_rate_other;
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

        public static class KPIBean {
            /**
             * appoint_enter_max : 500
             * appoint_enter_me : 0
             * appoint_enter_other : 0
             * appoint_max : 500
             * appoint_me : 0
             * appoint_other : 0
             * appoint_success_rate_max : 100
             * appoint_success_rate_me : 0
             * appoint_success_rate_other : 0
             * collection_max : 1000
             * collection_me : 0
             * collection_other : 0
             * continue_max : 500
             * continue_me : 0
             * continue_other : 0
             * enter_success_rate_max : 100
             * enter_success_rate_me : 0
             * enter_success_rate_other : 0
             * giveup_max : 100
             * giveup_me : 0
             * giveup_other : 0
             * loss_max : 100
             * loss_me : 0
             * loss_other : 0
             * unsolved_collection_max : 100
             * unsolved_collection_me : 0
             * unsolved_collection_other : 0
             */

            private int appoint_enter_max;
            private int appoint_enter_me;
            private int appoint_enter_other;
            private int appoint_max;
            private int appoint_me;
            private int appoint_other;
            private int appoint_success_rate_max;
            private int appoint_success_rate_me;
            private int appoint_success_rate_other;
            private int collection_max;
            private int collection_me;
            private int collection_other;
            private int continue_max;
            private int continue_me;
            private int continue_other;
            private int enter_success_rate_max;
            private int enter_success_rate_me;
            private int enter_success_rate_other;
            private int giveup_max;
            private int giveup_me;
            private int giveup_other;
            private int loss_max;
            private int loss_me;
            private int loss_other;
            private int unsolved_collection_max;
            private int unsolved_collection_me;
            private int unsolved_collection_other;

            public int getAppoint_enter_max() {
                return appoint_enter_max;
            }

            public void setAppoint_enter_max(int appoint_enter_max) {
                this.appoint_enter_max = appoint_enter_max;
            }

            public int getAppoint_enter_me() {
                return appoint_enter_me;
            }

            public void setAppoint_enter_me(int appoint_enter_me) {
                this.appoint_enter_me = appoint_enter_me;
            }

            public int getAppoint_enter_other() {
                return appoint_enter_other;
            }

            public void setAppoint_enter_other(int appoint_enter_other) {
                this.appoint_enter_other = appoint_enter_other;
            }

            public int getAppoint_max() {
                return appoint_max;
            }

            public void setAppoint_max(int appoint_max) {
                this.appoint_max = appoint_max;
            }

            public int getAppoint_me() {
                return appoint_me;
            }

            public void setAppoint_me(int appoint_me) {
                this.appoint_me = appoint_me;
            }

            public int getAppoint_other() {
                return appoint_other;
            }

            public void setAppoint_other(int appoint_other) {
                this.appoint_other = appoint_other;
            }

            public int getAppoint_success_rate_max() {
                return appoint_success_rate_max;
            }

            public void setAppoint_success_rate_max(int appoint_success_rate_max) {
                this.appoint_success_rate_max = appoint_success_rate_max;
            }

            public int getAppoint_success_rate_me() {
                return appoint_success_rate_me;
            }

            public void setAppoint_success_rate_me(int appoint_success_rate_me) {
                this.appoint_success_rate_me = appoint_success_rate_me;
            }

            public int getAppoint_success_rate_other() {
                return appoint_success_rate_other;
            }

            public void setAppoint_success_rate_other(int appoint_success_rate_other) {
                this.appoint_success_rate_other = appoint_success_rate_other;
            }

            public int getCollection_max() {
                return collection_max;
            }

            public void setCollection_max(int collection_max) {
                this.collection_max = collection_max;
            }

            public int getCollection_me() {
                return collection_me;
            }

            public void setCollection_me(int collection_me) {
                this.collection_me = collection_me;
            }

            public int getCollection_other() {
                return collection_other;
            }

            public void setCollection_other(int collection_other) {
                this.collection_other = collection_other;
            }

            public int getContinue_max() {
                return continue_max;
            }

            public void setContinue_max(int continue_max) {
                this.continue_max = continue_max;
            }

            public int getContinue_me() {
                return continue_me;
            }

            public void setContinue_me(int continue_me) {
                this.continue_me = continue_me;
            }

            public int getContinue_other() {
                return continue_other;
            }

            public void setContinue_other(int continue_other) {
                this.continue_other = continue_other;
            }

            public int getEnter_success_rate_max() {
                return enter_success_rate_max;
            }

            public void setEnter_success_rate_max(int enter_success_rate_max) {
                this.enter_success_rate_max = enter_success_rate_max;
            }

            public int getEnter_success_rate_me() {
                return enter_success_rate_me;
            }

            public void setEnter_success_rate_me(int enter_success_rate_me) {
                this.enter_success_rate_me = enter_success_rate_me;
            }

            public int getEnter_success_rate_other() {
                return enter_success_rate_other;
            }

            public void setEnter_success_rate_other(int enter_success_rate_other) {
                this.enter_success_rate_other = enter_success_rate_other;
            }

            public int getGiveup_max() {
                return giveup_max;
            }

            public void setGiveup_max(int giveup_max) {
                this.giveup_max = giveup_max;
            }

            public int getGiveup_me() {
                return giveup_me;
            }

            public void setGiveup_me(int giveup_me) {
                this.giveup_me = giveup_me;
            }

            public int getGiveup_other() {
                return giveup_other;
            }

            public void setGiveup_other(int giveup_other) {
                this.giveup_other = giveup_other;
            }

            public int getLoss_max() {
                return loss_max;
            }

            public void setLoss_max(int loss_max) {
                this.loss_max = loss_max;
            }

            public int getLoss_me() {
                return loss_me;
            }

            public void setLoss_me(int loss_me) {
                this.loss_me = loss_me;
            }

            public int getLoss_other() {
                return loss_other;
            }

            public void setLoss_other(int loss_other) {
                this.loss_other = loss_other;
            }

            public int getUnsolved_collection_max() {
                return unsolved_collection_max;
            }

            public void setUnsolved_collection_max(int unsolved_collection_max) {
                this.unsolved_collection_max = unsolved_collection_max;
            }

            public int getUnsolved_collection_me() {
                return unsolved_collection_me;
            }

            public void setUnsolved_collection_me(int unsolved_collection_me) {
                this.unsolved_collection_me = unsolved_collection_me;
            }

            public int getUnsolved_collection_other() {
                return unsolved_collection_other;
            }

            public void setUnsolved_collection_other(int unsolved_collection_other) {
                this.unsolved_collection_other = unsolved_collection_other;
            }
        }

        public static class HeaderBean {
            /**
             * request_time : 2018-06-19 01:48:55
             * response_time : 2018-06-19 01:48:57
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

        public static class MnBean {
            /**
             * M1_mn_now_max : 100000
             * M1_mn_now_me : 0
             * M1_mn_now_other : 0
             * M2_mn_now_max : 100000
             * M2_mn_now_me : 0
             * M2_mn_now_other : 0
             * T1_mn_now_max : 300000
             * T1_mn_now_me : 0.0
             * T1_mn_now_other : 1800.0
             * add_mn_now_max : 100000
             * add_mn_now_me : 0.0
             * add_mn_now_other : 0.0
             * appoint_mn_now_max : 200000
             * appoint_mn_now_me : 0.0
             * appoint_mn_now_other : 0.0
             * excelt_mn_now_max : 100000
             * excelt_mn_now_me : 0
             * excelt_mn_now_other : 0
             * goal_mn_now_max : 300000
             * goal_mn_now_me : 0
             * goal_mn_now_other : 1800
             * maint_mn_now_max : 200000
             * maint_mn_now_me : 0
             * maint_mn_now_other : 0
             * repair_mn_now_max : 200000
             * repair_mn_now_me : 0
             * repair_mn_now_other : 0
             */

            private int M1_mn_now_max;
            private int M1_mn_now_me;
            private int M1_mn_now_other;
            private int M2_mn_now_max;
            private int M2_mn_now_me;
            private int M2_mn_now_other;
            private int T1_mn_now_max;
            private int T1_mn_now_me;
            private int T1_mn_now_other;
            private int add_mn_now_max;
            private int add_mn_now_me;
            private int add_mn_now_other;
            private int appoint_mn_now_max;
            private int appoint_mn_now_me;
            private int appoint_mn_now_other;
            private int excelt_mn_now_max;
            private int excelt_mn_now_me;
            private int excelt_mn_now_other;
            private int goal_mn_now_max;
            private int goal_mn_now_me;
            private int goal_mn_now_other;
            private int maint_mn_now_max;
            private int maint_mn_now_me;
            private int maint_mn_now_other;
            private int repair_mn_now_max;
            private int repair_mn_now_me;
            private int repair_mn_now_other;

            public int getM1_mn_now_max() {
                return M1_mn_now_max;
            }

            public void setM1_mn_now_max(int M1_mn_now_max) {
                this.M1_mn_now_max = M1_mn_now_max;
            }

            public int getM1_mn_now_me() {
                return M1_mn_now_me;
            }

            public void setM1_mn_now_me(int M1_mn_now_me) {
                this.M1_mn_now_me = M1_mn_now_me;
            }

            public int getM1_mn_now_other() {
                return M1_mn_now_other;
            }

            public void setM1_mn_now_other(int M1_mn_now_other) {
                this.M1_mn_now_other = M1_mn_now_other;
            }

            public int getM2_mn_now_max() {
                return M2_mn_now_max;
            }

            public void setM2_mn_now_max(int M2_mn_now_max) {
                this.M2_mn_now_max = M2_mn_now_max;
            }

            public int getM2_mn_now_me() {
                return M2_mn_now_me;
            }

            public void setM2_mn_now_me(int M2_mn_now_me) {
                this.M2_mn_now_me = M2_mn_now_me;
            }

            public int getM2_mn_now_other() {
                return M2_mn_now_other;
            }

            public void setM2_mn_now_other(int M2_mn_now_other) {
                this.M2_mn_now_other = M2_mn_now_other;
            }

            public int getT1_mn_now_max() {
                return T1_mn_now_max;
            }

            public void setT1_mn_now_max(int T1_mn_now_max) {
                this.T1_mn_now_max = T1_mn_now_max;
            }

            public int getT1_mn_now_me() {
                return T1_mn_now_me;
            }

            public void setT1_mn_now_me(int T1_mn_now_me) {
                this.T1_mn_now_me = T1_mn_now_me;
            }

            public int getT1_mn_now_other() {
                return T1_mn_now_other;
            }

            public void setT1_mn_now_other(int T1_mn_now_other) {
                this.T1_mn_now_other = T1_mn_now_other;
            }

            public int getAdd_mn_now_max() {
                return add_mn_now_max;
            }

            public void setAdd_mn_now_max(int add_mn_now_max) {
                this.add_mn_now_max = add_mn_now_max;
            }

            public int getAdd_mn_now_me() {
                return add_mn_now_me;
            }

            public void setAdd_mn_now_me(int add_mn_now_me) {
                this.add_mn_now_me = add_mn_now_me;
            }

            public int getAdd_mn_now_other() {
                return add_mn_now_other;
            }

            public void setAdd_mn_now_other(int add_mn_now_other) {
                this.add_mn_now_other = add_mn_now_other;
            }

            public int getAppoint_mn_now_max() {
                return appoint_mn_now_max;
            }

            public void setAppoint_mn_now_max(int appoint_mn_now_max) {
                this.appoint_mn_now_max = appoint_mn_now_max;
            }

            public int getAppoint_mn_now_me() {
                return appoint_mn_now_me;
            }

            public void setAppoint_mn_now_me(int appoint_mn_now_me) {
                this.appoint_mn_now_me = appoint_mn_now_me;
            }

            public int getAppoint_mn_now_other() {
                return appoint_mn_now_other;
            }

            public void setAppoint_mn_now_other(int appoint_mn_now_other) {
                this.appoint_mn_now_other = appoint_mn_now_other;
            }

            public int getExcelt_mn_now_max() {
                return excelt_mn_now_max;
            }

            public void setExcelt_mn_now_max(int excelt_mn_now_max) {
                this.excelt_mn_now_max = excelt_mn_now_max;
            }

            public int getExcelt_mn_now_me() {
                return excelt_mn_now_me;
            }

            public void setExcelt_mn_now_me(int excelt_mn_now_me) {
                this.excelt_mn_now_me = excelt_mn_now_me;
            }

            public int getExcelt_mn_now_other() {
                return excelt_mn_now_other;
            }

            public void setExcelt_mn_now_other(int excelt_mn_now_other) {
                this.excelt_mn_now_other = excelt_mn_now_other;
            }

            public int getGoal_mn_now_max() {
                return goal_mn_now_max;
            }

            public void setGoal_mn_now_max(int goal_mn_now_max) {
                this.goal_mn_now_max = goal_mn_now_max;
            }

            public int getGoal_mn_now_me() {
                return goal_mn_now_me;
            }

            public void setGoal_mn_now_me(int goal_mn_now_me) {
                this.goal_mn_now_me = goal_mn_now_me;
            }

            public int getGoal_mn_now_other() {
                return goal_mn_now_other;
            }

            public void setGoal_mn_now_other(int goal_mn_now_other) {
                this.goal_mn_now_other = goal_mn_now_other;
            }

            public int getMaint_mn_now_max() {
                return maint_mn_now_max;
            }

            public void setMaint_mn_now_max(int maint_mn_now_max) {
                this.maint_mn_now_max = maint_mn_now_max;
            }

            public int getMaint_mn_now_me() {
                return maint_mn_now_me;
            }

            public void setMaint_mn_now_me(int maint_mn_now_me) {
                this.maint_mn_now_me = maint_mn_now_me;
            }

            public int getMaint_mn_now_other() {
                return maint_mn_now_other;
            }

            public void setMaint_mn_now_other(int maint_mn_now_other) {
                this.maint_mn_now_other = maint_mn_now_other;
            }

            public int getRepair_mn_now_max() {
                return repair_mn_now_max;
            }

            public void setRepair_mn_now_max(int repair_mn_now_max) {
                this.repair_mn_now_max = repair_mn_now_max;
            }

            public int getRepair_mn_now_me() {
                return repair_mn_now_me;
            }

            public void setRepair_mn_now_me(int repair_mn_now_me) {
                this.repair_mn_now_me = repair_mn_now_me;
            }

            public int getRepair_mn_now_other() {
                return repair_mn_now_other;
            }

            public void setRepair_mn_now_other(int repair_mn_now_other) {
                this.repair_mn_now_other = repair_mn_now_other;
            }
        }

        public static class TimesBean {
            /**
             * M1_goal_max : 100
             * M1_goal_me : 19
             * M1_goal_other : 19
             * M1_star_goal_max : 100
             * M1_star_goal_me : 0
             * M1_star_goal_other : 0
             * M1_times_max : 135
             * M1_times_me : 0
             * M1_times_other : 0
             * M2_goal_max : 100
             * M2_goal_me : 19
             * M2_goal_other : 19
             * M2_star_goal_max : 100
             * M2_star_goal_me : 0
             * M2_star_goal_other : 0
             * M2_times_max : 135
             * M2_times_me : 0
             * M2_times_other : 0
             * T1_times_max : 405
             * T1_times_me : 1
             * T1_times_other : 3
             * add_times_max : 135
             * add_times_me : 0
             * add_times_other : 0
             * appoint_times_max : 270
             * appoint_times_me : 0
             * appoint_times_other : 0
             * excelt_times_max : 135
             * excelt_times_me : 0
             * excelt_times_other : 0
             * goal_times_max : 405
             * goal_times_me : 1
             * goal_times_other : 3
             * maint_times_max : 270
             * maint_times_me : 0
             * maint_times_other : 0
             * ontime_times_max : 405
             * ontime_times_me : 0
             * ontime_times_other : 0
             * repair_times_max : 270
             * repair_times_me : 0
             * repair_times_other : 0
             */

            private int M1_goal_max;
            private int M1_goal_me;
            private int M1_goal_other;
            private int M1_star_goal_max;
            private int M1_star_goal_me;
            private int M1_star_goal_other;
            private int M1_times_max;
            private int M1_times_me;
            private int M1_times_other;
            private int M2_goal_max;
            private int M2_goal_me;
            private int M2_goal_other;
            private int M2_star_goal_max;
            private int M2_star_goal_me;
            private int M2_star_goal_other;
            private int M2_times_max;
            private int M2_times_me;
            private int M2_times_other;
            private int T1_times_max;
            private int T1_times_me;
            private int T1_times_other;
            private int add_times_max;
            private int add_times_me;
            private int add_times_other;
            private int appoint_times_max;
            private int appoint_times_me;
            private int appoint_times_other;
            private int excelt_times_max;
            private int excelt_times_me;
            private int excelt_times_other;
            private int goal_times_max;
            private int goal_times_me;
            private int goal_times_other;
            private int maint_times_max;
            private int maint_times_me;
            private int maint_times_other;
            private int ontime_times_max;
            private int ontime_times_me;
            private int ontime_times_other;
            private int repair_times_max;
            private int repair_times_me;
            private int repair_times_other;

            public int getM1_goal_max() {
                return M1_goal_max;
            }

            public void setM1_goal_max(int M1_goal_max) {
                this.M1_goal_max = M1_goal_max;
            }

            public int getM1_goal_me() {
                return M1_goal_me;
            }

            public void setM1_goal_me(int M1_goal_me) {
                this.M1_goal_me = M1_goal_me;
            }

            public int getM1_goal_other() {
                return M1_goal_other;
            }

            public void setM1_goal_other(int M1_goal_other) {
                this.M1_goal_other = M1_goal_other;
            }

            public int getM1_star_goal_max() {
                return M1_star_goal_max;
            }

            public void setM1_star_goal_max(int M1_star_goal_max) {
                this.M1_star_goal_max = M1_star_goal_max;
            }

            public int getM1_star_goal_me() {
                return M1_star_goal_me;
            }

            public void setM1_star_goal_me(int M1_star_goal_me) {
                this.M1_star_goal_me = M1_star_goal_me;
            }

            public int getM1_star_goal_other() {
                return M1_star_goal_other;
            }

            public void setM1_star_goal_other(int M1_star_goal_other) {
                this.M1_star_goal_other = M1_star_goal_other;
            }

            public int getM1_times_max() {
                return M1_times_max;
            }

            public void setM1_times_max(int M1_times_max) {
                this.M1_times_max = M1_times_max;
            }

            public int getM1_times_me() {
                return M1_times_me;
            }

            public void setM1_times_me(int M1_times_me) {
                this.M1_times_me = M1_times_me;
            }

            public int getM1_times_other() {
                return M1_times_other;
            }

            public void setM1_times_other(int M1_times_other) {
                this.M1_times_other = M1_times_other;
            }

            public int getM2_goal_max() {
                return M2_goal_max;
            }

            public void setM2_goal_max(int M2_goal_max) {
                this.M2_goal_max = M2_goal_max;
            }

            public int getM2_goal_me() {
                return M2_goal_me;
            }

            public void setM2_goal_me(int M2_goal_me) {
                this.M2_goal_me = M2_goal_me;
            }

            public int getM2_goal_other() {
                return M2_goal_other;
            }

            public void setM2_goal_other(int M2_goal_other) {
                this.M2_goal_other = M2_goal_other;
            }

            public int getM2_star_goal_max() {
                return M2_star_goal_max;
            }

            public void setM2_star_goal_max(int M2_star_goal_max) {
                this.M2_star_goal_max = M2_star_goal_max;
            }

            public int getM2_star_goal_me() {
                return M2_star_goal_me;
            }

            public void setM2_star_goal_me(int M2_star_goal_me) {
                this.M2_star_goal_me = M2_star_goal_me;
            }

            public int getM2_star_goal_other() {
                return M2_star_goal_other;
            }

            public void setM2_star_goal_other(int M2_star_goal_other) {
                this.M2_star_goal_other = M2_star_goal_other;
            }

            public int getM2_times_max() {
                return M2_times_max;
            }

            public void setM2_times_max(int M2_times_max) {
                this.M2_times_max = M2_times_max;
            }

            public int getM2_times_me() {
                return M2_times_me;
            }

            public void setM2_times_me(int M2_times_me) {
                this.M2_times_me = M2_times_me;
            }

            public int getM2_times_other() {
                return M2_times_other;
            }

            public void setM2_times_other(int M2_times_other) {
                this.M2_times_other = M2_times_other;
            }

            public int getT1_times_max() {
                return T1_times_max;
            }

            public void setT1_times_max(int T1_times_max) {
                this.T1_times_max = T1_times_max;
            }

            public int getT1_times_me() {
                return T1_times_me;
            }

            public void setT1_times_me(int T1_times_me) {
                this.T1_times_me = T1_times_me;
            }

            public int getT1_times_other() {
                return T1_times_other;
            }

            public void setT1_times_other(int T1_times_other) {
                this.T1_times_other = T1_times_other;
            }

            public int getAdd_times_max() {
                return add_times_max;
            }

            public void setAdd_times_max(int add_times_max) {
                this.add_times_max = add_times_max;
            }

            public int getAdd_times_me() {
                return add_times_me;
            }

            public void setAdd_times_me(int add_times_me) {
                this.add_times_me = add_times_me;
            }

            public int getAdd_times_other() {
                return add_times_other;
            }

            public void setAdd_times_other(int add_times_other) {
                this.add_times_other = add_times_other;
            }

            public int getAppoint_times_max() {
                return appoint_times_max;
            }

            public void setAppoint_times_max(int appoint_times_max) {
                this.appoint_times_max = appoint_times_max;
            }

            public int getAppoint_times_me() {
                return appoint_times_me;
            }

            public void setAppoint_times_me(int appoint_times_me) {
                this.appoint_times_me = appoint_times_me;
            }

            public int getAppoint_times_other() {
                return appoint_times_other;
            }

            public void setAppoint_times_other(int appoint_times_other) {
                this.appoint_times_other = appoint_times_other;
            }

            public int getExcelt_times_max() {
                return excelt_times_max;
            }

            public void setExcelt_times_max(int excelt_times_max) {
                this.excelt_times_max = excelt_times_max;
            }

            public int getExcelt_times_me() {
                return excelt_times_me;
            }

            public void setExcelt_times_me(int excelt_times_me) {
                this.excelt_times_me = excelt_times_me;
            }

            public int getExcelt_times_other() {
                return excelt_times_other;
            }

            public void setExcelt_times_other(int excelt_times_other) {
                this.excelt_times_other = excelt_times_other;
            }

            public int getGoal_times_max() {
                return goal_times_max;
            }

            public void setGoal_times_max(int goal_times_max) {
                this.goal_times_max = goal_times_max;
            }

            public int getGoal_times_me() {
                return goal_times_me;
            }

            public void setGoal_times_me(int goal_times_me) {
                this.goal_times_me = goal_times_me;
            }

            public int getGoal_times_other() {
                return goal_times_other;
            }

            public void setGoal_times_other(int goal_times_other) {
                this.goal_times_other = goal_times_other;
            }

            public int getMaint_times_max() {
                return maint_times_max;
            }

            public void setMaint_times_max(int maint_times_max) {
                this.maint_times_max = maint_times_max;
            }

            public int getMaint_times_me() {
                return maint_times_me;
            }

            public void setMaint_times_me(int maint_times_me) {
                this.maint_times_me = maint_times_me;
            }

            public int getMaint_times_other() {
                return maint_times_other;
            }

            public void setMaint_times_other(int maint_times_other) {
                this.maint_times_other = maint_times_other;
            }

            public int getOntime_times_max() {
                return ontime_times_max;
            }

            public void setOntime_times_max(int ontime_times_max) {
                this.ontime_times_max = ontime_times_max;
            }

            public int getOntime_times_me() {
                return ontime_times_me;
            }

            public void setOntime_times_me(int ontime_times_me) {
                this.ontime_times_me = ontime_times_me;
            }

            public int getOntime_times_other() {
                return ontime_times_other;
            }

            public void setOntime_times_other(int ontime_times_other) {
                this.ontime_times_other = ontime_times_other;
            }

            public int getRepair_times_max() {
                return repair_times_max;
            }

            public void setRepair_times_max(int repair_times_max) {
                this.repair_times_max = repair_times_max;
            }

            public int getRepair_times_me() {
                return repair_times_me;
            }

            public void setRepair_times_me(int repair_times_me) {
                this.repair_times_me = repair_times_me;
            }

            public int getRepair_times_other() {
                return repair_times_other;
            }

            public void setRepair_times_other(int repair_times_other) {
                this.repair_times_other = repair_times_other;
            }
        }
    }
}