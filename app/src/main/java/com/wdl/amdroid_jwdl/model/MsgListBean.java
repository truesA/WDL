package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class MsgListBean
        implements Serializable {
    private int error_code;
    private String reason;
    private List<ResultBean> result;

    public int getError_code() {
        return this.error_code;
    }

    public String getReason() {
        return this.reason;
    }

    public List<ResultBean> getResult() {
        return this.result;
    }

    public void setError_code(int paramInt) {
        this.error_code = paramInt;
    }

    public void setReason(String paramString) {
        this.reason = paramString;
    }

    public void setResult(List<ResultBean> paramList) {
        this.result = paramList;
    }

    public static class ResultBean
            implements Serializable {
        private String Level;
        private int Xu;
        private int Zhe;
        private int id;
        private String name;
        private String phone_number;
        private String plate_num;
        private int total_score;
        private String initial;
        private int collection;
        private double loy_coef;
        private int T1_target; //用户是否是T1目标（1-是，0-否）
        private String color;
        private String date;
        private String SAname;

        public String getSAname() {
            return SAname;
        }

        public void setSAname(String SAname) {
            this.SAname = SAname;
        }

        public int getT1_target() {
            return T1_target;
        }

        public void setT1_target(int t1_target) {
            T1_target = t1_target;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getLoy_coef() {

            return loy_coef;
        }

        public void setLoy_coef(double loy_coef) {
            this.loy_coef = loy_coef;
        }

        public String getInitial() {
            return initial;
        }

        public void setInitial(String initial) {
            this.initial = initial;
        }

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public int getId() {
            return this.id;
        }

        public String getLevel() {
            return this.Level;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone_number() {
            return this.phone_number;
        }

        public String getPlate_num() {
            return this.plate_num;
        }

        public int getTotal_score() {
            return this.total_score;
        }

        public int getXu() {
            return this.Xu;
        }

        public int getZhe() {
            return this.Zhe;
        }

        public void setId(int paramInt) {
            this.id = paramInt;
        }

        public void setLevel(String paramString) {
            this.Level = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setPhone_number(String paramString) {
            this.phone_number = paramString;
        }

        public void setPlate_num(String paramString) {
            this.plate_num = paramString;
        }

        public void setTotal_score(int paramInt) {
            this.total_score = paramInt;
        }

        public void setXu(int paramInt) {
            this.Xu = paramInt;
        }

        public void setZhe(int paramInt) {
            this.Zhe = paramInt;
        }
    }
}