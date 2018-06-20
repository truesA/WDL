package com.wdl.amdroid_jwdl.model;

import java.io.Serializable;
import java.util.List;

/**
 * author：lhm on 2018/5/27 15:06
 * <p>
 * email：3186834196@qq.com
 */
public class SavingBean implements Serializable{


    /**
     * error_code : 200
     * reason : 奖金池数据已更新!
     * result : {"SA1":{"alive_mn":0,"alive_mn_sign":1,"cash_flow":3456,"cash_flow_sign":1,"customer_nm":564,"lost_mn":5654,"lost_mn_sign":1,"s_M1_num":123,"s_M1_num_sign":0,"s_M2_num":67,"s_M2_num_sign":1,"s_T1_num":0,"s_T1_num_sign":1,"s_add_mn":4565,"s_add_mn_sign":0,"s_appoint_rate":23,"s_appoint_rate_sign":0,"s_mn_achv_rate":0,"s_mn_achv_rate_sign":0,"s_ontime_num":123,"s_ontime_num_sign":0,"s_ontime_rate":89,"s_ontime_rate_sign":1,"s_pool_mn":0,"s_pool_mn_sign":0,"s_times_achv_rate":110,"s_times_achv_rate_sign":1},"SA2":{"alive_mn":0,"alive_mn_sign":0,"cash_flow":3432,"cash_flow_sign":0,"customer_nm":656,"lost_mn":3454,"lost_mn_sign":0,"s_M1_num":146,"s_M1_num_sign":1,"s_M2_num":56,"s_M2_num_sign":0,"s_T1_num":0,"s_T1_num_sign":0,"s_add_mn":6767,"s_add_mn_sign":1,"s_appoint_rate":34,"s_appoint_rate_sign":1,"s_mn_achv_rate":141,"s_mn_achv_rate_sign":1,"s_ontime_num":146,"s_ontime_num_sign":1,"s_ontime_rate":56,"s_ontime_rate_sign":0,"s_pool_mn":550,"s_pool_mn_sign":1,"s_times_achv_rate":105,"s_times_achv_rate_sign":0},"header":{"request_time":"2018-05-27 07:56:15","response_time":"2018-05-27 07:56:17"}}
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
         * SA1 : {"alive_mn":0,"alive_mn_sign":1,"cash_flow":3456,"cash_flow_sign":1,"customer_nm":564,"lost_mn":5654,"lost_mn_sign":1,"s_M1_num":123,"s_M1_num_sign":0,"s_M2_num":67,"s_M2_num_sign":1,"s_T1_num":0,"s_T1_num_sign":1,"s_add_mn":4565,"s_add_mn_sign":0,"s_appoint_rate":23,"s_appoint_rate_sign":0,"s_mn_achv_rate":0,"s_mn_achv_rate_sign":0,"s_ontime_num":123,"s_ontime_num_sign":0,"s_ontime_rate":89,"s_ontime_rate_sign":1,"s_pool_mn":0,"s_pool_mn_sign":0,"s_times_achv_rate":110,"s_times_achv_rate_sign":1}
         * SA2 : {"alive_mn":0,"alive_mn_sign":0,"cash_flow":3432,"cash_flow_sign":0,"customer_nm":656,"lost_mn":3454,"lost_mn_sign":0,"s_M1_num":146,"s_M1_num_sign":1,"s_M2_num":56,"s_M2_num_sign":0,"s_T1_num":0,"s_T1_num_sign":0,"s_add_mn":6767,"s_add_mn_sign":1,"s_appoint_rate":34,"s_appoint_rate_sign":1,"s_mn_achv_rate":141,"s_mn_achv_rate_sign":1,"s_ontime_num":146,"s_ontime_num_sign":1,"s_ontime_rate":56,"s_ontime_rate_sign":0,"s_pool_mn":550,"s_pool_mn_sign":1,"s_times_achv_rate":105,"s_times_achv_rate_sign":0}
         * header : {"request_time":"2018-05-27 07:56:15","response_time":"2018-05-27 07:56:17"}
         */

        private SA1Bean SA1;
        private SA2Bean SA2;
        private HeaderBean header;
        private List<String> SAname;
        private String date;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<String> getSAname() {
            return SAname;
        }

        public void setSAname(List<String> SAname) {
            this.SAname = SAname;
        }

        public SA1Bean getSA1() {
            return SA1;
        }

        public void setSA1(SA1Bean SA1) {
            this.SA1 = SA1;
        }

        public SA2Bean getSA2() {
            return SA2;
        }

        public void setSA2(SA2Bean SA2) {
            this.SA2 = SA2;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public static class SA1Bean implements Serializable{
            /**
             * alive_mn : 0
             * alive_mn_sign : 1
             * cash_flow : 3456
             * cash_flow_sign : 1
             * customer_nm : 564
             * lost_mn : 5654
             * lost_mn_sign : 1
             * s_M1_num : 123
             * s_M1_num_sign : 0
             * s_M2_num : 67
             * s_M2_num_sign : 1
             * s_T1_num : 0
             * s_T1_num_sign : 1
             * s_add_mn : 4565
             * s_add_mn_sign : 0
             * s_appoint_rate : 23
             * s_appoint_rate_sign : 0
             * s_mn_achv_rate : 0
             * s_mn_achv_rate_sign : 0
             * s_ontime_num : 123
             * s_ontime_num_sign : 0
             * s_ontime_rate : 89
             * s_ontime_rate_sign : 1
             * s_pool_mn : 0
             * s_pool_mn_sign : 0
             * s_times_achv_rate : 110
             * s_times_achv_rate_sign : 1
             */

            private int alive_mn;
            private int alive_mn_sign;
            private int cash_flow;
            private int cash_flow_sign;
            private int customer_nm;
            private int lost_mn;
            private int lost_mn_sign;
            private int s_M1_num;
            private int s_M1_num_sign;
            private int s_M2_num;
            private int s_M2_num_sign;
            private int s_T1_num;
            private int s_T1_num_sign;
            private int s_add_mn;
            private int s_add_mn_sign;
            private int s_appoint_rate;
            private int s_appoint_rate_sign;
            private int s_mn_achv_rate;
            private int s_mn_achv_rate_sign;
            private int s_ontime_num;
            private int s_ontime_num_sign;
            private int s_ontime_rate;
            private int s_ontime_rate_sign;
            private int s_pool_mn;
            private int s_pool_mn_sign;
            private int s_times_achv_rate;
            private int s_times_achv_rate_sign;

            public int getAlive_mn() {
                return alive_mn;
            }

            public void setAlive_mn(int alive_mn) {
                this.alive_mn = alive_mn;
            }

            public int getAlive_mn_sign() {
                return alive_mn_sign;
            }

            public void setAlive_mn_sign(int alive_mn_sign) {
                this.alive_mn_sign = alive_mn_sign;
            }

            public int getCash_flow() {
                return cash_flow;
            }

            public void setCash_flow(int cash_flow) {
                this.cash_flow = cash_flow;
            }

            public int getCash_flow_sign() {
                return cash_flow_sign;
            }

            public void setCash_flow_sign(int cash_flow_sign) {
                this.cash_flow_sign = cash_flow_sign;
            }

            public int getCustomer_nm() {
                return customer_nm;
            }

            public void setCustomer_nm(int customer_nm) {
                this.customer_nm = customer_nm;
            }

            public int getLost_mn() {
                return lost_mn;
            }

            public void setLost_mn(int lost_mn) {
                this.lost_mn = lost_mn;
            }

            public int getLost_mn_sign() {
                return lost_mn_sign;
            }

            public void setLost_mn_sign(int lost_mn_sign) {
                this.lost_mn_sign = lost_mn_sign;
            }

            public int getS_M1_num() {
                return s_M1_num;
            }

            public void setS_M1_num(int s_M1_num) {
                this.s_M1_num = s_M1_num;
            }

            public int getS_M1_num_sign() {
                return s_M1_num_sign;
            }

            public void setS_M1_num_sign(int s_M1_num_sign) {
                this.s_M1_num_sign = s_M1_num_sign;
            }

            public int getS_M2_num() {
                return s_M2_num;
            }

            public void setS_M2_num(int s_M2_num) {
                this.s_M2_num = s_M2_num;
            }

            public int getS_M2_num_sign() {
                return s_M2_num_sign;
            }

            public void setS_M2_num_sign(int s_M2_num_sign) {
                this.s_M2_num_sign = s_M2_num_sign;
            }

            public int getS_T1_num() {
                return s_T1_num;
            }

            public void setS_T1_num(int s_T1_num) {
                this.s_T1_num = s_T1_num;
            }

            public int getS_T1_num_sign() {
                return s_T1_num_sign;
            }

            public void setS_T1_num_sign(int s_T1_num_sign) {
                this.s_T1_num_sign = s_T1_num_sign;
            }

            public int getS_add_mn() {
                return s_add_mn;
            }

            public void setS_add_mn(int s_add_mn) {
                this.s_add_mn = s_add_mn;
            }

            public int getS_add_mn_sign() {
                return s_add_mn_sign;
            }

            public void setS_add_mn_sign(int s_add_mn_sign) {
                this.s_add_mn_sign = s_add_mn_sign;
            }

            public int getS_appoint_rate() {
                return s_appoint_rate;
            }

            public void setS_appoint_rate(int s_appoint_rate) {
                this.s_appoint_rate = s_appoint_rate;
            }

            public int getS_appoint_rate_sign() {
                return s_appoint_rate_sign;
            }

            public void setS_appoint_rate_sign(int s_appoint_rate_sign) {
                this.s_appoint_rate_sign = s_appoint_rate_sign;
            }

            public int getS_mn_achv_rate() {
                return s_mn_achv_rate;
            }

            public void setS_mn_achv_rate(int s_mn_achv_rate) {
                this.s_mn_achv_rate = s_mn_achv_rate;
            }

            public int getS_mn_achv_rate_sign() {
                return s_mn_achv_rate_sign;
            }

            public void setS_mn_achv_rate_sign(int s_mn_achv_rate_sign) {
                this.s_mn_achv_rate_sign = s_mn_achv_rate_sign;
            }

            public int getS_ontime_num() {
                return s_ontime_num;
            }

            public void setS_ontime_num(int s_ontime_num) {
                this.s_ontime_num = s_ontime_num;
            }

            public int getS_ontime_num_sign() {
                return s_ontime_num_sign;
            }

            public void setS_ontime_num_sign(int s_ontime_num_sign) {
                this.s_ontime_num_sign = s_ontime_num_sign;
            }

            public int getS_ontime_rate() {
                return s_ontime_rate;
            }

            public void setS_ontime_rate(int s_ontime_rate) {
                this.s_ontime_rate = s_ontime_rate;
            }

            public int getS_ontime_rate_sign() {
                return s_ontime_rate_sign;
            }

            public void setS_ontime_rate_sign(int s_ontime_rate_sign) {
                this.s_ontime_rate_sign = s_ontime_rate_sign;
            }

            public int getS_pool_mn() {
                return s_pool_mn;
            }

            public void setS_pool_mn(int s_pool_mn) {
                this.s_pool_mn = s_pool_mn;
            }

            public int getS_pool_mn_sign() {
                return s_pool_mn_sign;
            }

            public void setS_pool_mn_sign(int s_pool_mn_sign) {
                this.s_pool_mn_sign = s_pool_mn_sign;
            }

            public int getS_times_achv_rate() {
                return s_times_achv_rate;
            }

            public void setS_times_achv_rate(int s_times_achv_rate) {
                this.s_times_achv_rate = s_times_achv_rate;
            }

            public int getS_times_achv_rate_sign() {
                return s_times_achv_rate_sign;
            }

            public void setS_times_achv_rate_sign(int s_times_achv_rate_sign) {
                this.s_times_achv_rate_sign = s_times_achv_rate_sign;
            }
        }

        public static class SA2Bean implements Serializable{
            /**
             * alive_mn : 0
             * alive_mn_sign : 0
             * cash_flow : 3432
             * cash_flow_sign : 0
             * customer_nm : 656
             * lost_mn : 3454
             * lost_mn_sign : 0
             * s_M1_num : 146
             * s_M1_num_sign : 1
             * s_M2_num : 56
             * s_M2_num_sign : 0
             * s_T1_num : 0
             * s_T1_num_sign : 0
             * s_add_mn : 6767
             * s_add_mn_sign : 1
             * s_appoint_rate : 34
             * s_appoint_rate_sign : 1
             * s_mn_achv_rate : 141
             * s_mn_achv_rate_sign : 1
             * s_ontime_num : 146
             * s_ontime_num_sign : 1
             * s_ontime_rate : 56
             * s_ontime_rate_sign : 0
             * s_pool_mn : 550
             * s_pool_mn_sign : 1
             * s_times_achv_rate : 105
             * s_times_achv_rate_sign : 0
             */

            private int alive_mn;
            private int alive_mn_sign;
            private int cash_flow;
            private int cash_flow_sign;
            private int customer_nm;
            private int lost_mn;
            private int lost_mn_sign;
            private int s_M1_num;
            private int s_M1_num_sign;
            private int s_M2_num;
            private int s_M2_num_sign;
            private int s_T1_num;
            private int s_T1_num_sign;
            private int s_add_mn;
            private int s_add_mn_sign;
            private int s_appoint_rate;
            private int s_appoint_rate_sign;
            private int s_mn_achv_rate;
            private int s_mn_achv_rate_sign;
            private int s_ontime_num;
            private int s_ontime_num_sign;
            private int s_ontime_rate;
            private int s_ontime_rate_sign;
            private int s_pool_mn;
            private int s_pool_mn_sign;
            private int s_times_achv_rate;
            private int s_times_achv_rate_sign;

            public int getAlive_mn() {
                return alive_mn;
            }

            public void setAlive_mn(int alive_mn) {
                this.alive_mn = alive_mn;
            }

            public int getAlive_mn_sign() {
                return alive_mn_sign;
            }

            public void setAlive_mn_sign(int alive_mn_sign) {
                this.alive_mn_sign = alive_mn_sign;
            }

            public int getCash_flow() {
                return cash_flow;
            }

            public void setCash_flow(int cash_flow) {
                this.cash_flow = cash_flow;
            }

            public int getCash_flow_sign() {
                return cash_flow_sign;
            }

            public void setCash_flow_sign(int cash_flow_sign) {
                this.cash_flow_sign = cash_flow_sign;
            }

            public int getCustomer_nm() {
                return customer_nm;
            }

            public void setCustomer_nm(int customer_nm) {
                this.customer_nm = customer_nm;
            }

            public int getLost_mn() {
                return lost_mn;
            }

            public void setLost_mn(int lost_mn) {
                this.lost_mn = lost_mn;
            }

            public int getLost_mn_sign() {
                return lost_mn_sign;
            }

            public void setLost_mn_sign(int lost_mn_sign) {
                this.lost_mn_sign = lost_mn_sign;
            }

            public int getS_M1_num() {
                return s_M1_num;
            }

            public void setS_M1_num(int s_M1_num) {
                this.s_M1_num = s_M1_num;
            }

            public int getS_M1_num_sign() {
                return s_M1_num_sign;
            }

            public void setS_M1_num_sign(int s_M1_num_sign) {
                this.s_M1_num_sign = s_M1_num_sign;
            }

            public int getS_M2_num() {
                return s_M2_num;
            }

            public void setS_M2_num(int s_M2_num) {
                this.s_M2_num = s_M2_num;
            }

            public int getS_M2_num_sign() {
                return s_M2_num_sign;
            }

            public void setS_M2_num_sign(int s_M2_num_sign) {
                this.s_M2_num_sign = s_M2_num_sign;
            }

            public int getS_T1_num() {
                return s_T1_num;
            }

            public void setS_T1_num(int s_T1_num) {
                this.s_T1_num = s_T1_num;
            }

            public int getS_T1_num_sign() {
                return s_T1_num_sign;
            }

            public void setS_T1_num_sign(int s_T1_num_sign) {
                this.s_T1_num_sign = s_T1_num_sign;
            }

            public int getS_add_mn() {
                return s_add_mn;
            }

            public void setS_add_mn(int s_add_mn) {
                this.s_add_mn = s_add_mn;
            }

            public int getS_add_mn_sign() {
                return s_add_mn_sign;
            }

            public void setS_add_mn_sign(int s_add_mn_sign) {
                this.s_add_mn_sign = s_add_mn_sign;
            }

            public int getS_appoint_rate() {
                return s_appoint_rate;
            }

            public void setS_appoint_rate(int s_appoint_rate) {
                this.s_appoint_rate = s_appoint_rate;
            }

            public int getS_appoint_rate_sign() {
                return s_appoint_rate_sign;
            }

            public void setS_appoint_rate_sign(int s_appoint_rate_sign) {
                this.s_appoint_rate_sign = s_appoint_rate_sign;
            }

            public int getS_mn_achv_rate() {
                return s_mn_achv_rate;
            }

            public void setS_mn_achv_rate(int s_mn_achv_rate) {
                this.s_mn_achv_rate = s_mn_achv_rate;
            }

            public int getS_mn_achv_rate_sign() {
                return s_mn_achv_rate_sign;
            }

            public void setS_mn_achv_rate_sign(int s_mn_achv_rate_sign) {
                this.s_mn_achv_rate_sign = s_mn_achv_rate_sign;
            }

            public int getS_ontime_num() {
                return s_ontime_num;
            }

            public void setS_ontime_num(int s_ontime_num) {
                this.s_ontime_num = s_ontime_num;
            }

            public int getS_ontime_num_sign() {
                return s_ontime_num_sign;
            }

            public void setS_ontime_num_sign(int s_ontime_num_sign) {
                this.s_ontime_num_sign = s_ontime_num_sign;
            }

            public int getS_ontime_rate() {
                return s_ontime_rate;
            }

            public void setS_ontime_rate(int s_ontime_rate) {
                this.s_ontime_rate = s_ontime_rate;
            }

            public int getS_ontime_rate_sign() {
                return s_ontime_rate_sign;
            }

            public void setS_ontime_rate_sign(int s_ontime_rate_sign) {
                this.s_ontime_rate_sign = s_ontime_rate_sign;
            }

            public int getS_pool_mn() {
                return s_pool_mn;
            }

            public void setS_pool_mn(int s_pool_mn) {
                this.s_pool_mn = s_pool_mn;
            }

            public int getS_pool_mn_sign() {
                return s_pool_mn_sign;
            }

            public void setS_pool_mn_sign(int s_pool_mn_sign) {
                this.s_pool_mn_sign = s_pool_mn_sign;
            }

            public int getS_times_achv_rate() {
                return s_times_achv_rate;
            }

            public void setS_times_achv_rate(int s_times_achv_rate) {
                this.s_times_achv_rate = s_times_achv_rate;
            }

            public int getS_times_achv_rate_sign() {
                return s_times_achv_rate_sign;
            }

            public void setS_times_achv_rate_sign(int s_times_achv_rate_sign) {
                this.s_times_achv_rate_sign = s_times_achv_rate_sign;
            }
        }

        public static class HeaderBean {
            /**
             * request_time : 2018-05-27 07:56:15
             * response_time : 2018-05-27 07:56:17
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
