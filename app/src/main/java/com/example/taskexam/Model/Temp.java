package com.example.taskexam.Model;

import com.google.gson.annotations.SerializedName;

public class Temp {


        @SerializedName("day")
        private Float day;

        @SerializedName("min")
        private Float min;

        @SerializedName("max")
        private Float max;


        public Float getDay() {
            return day;
        }

        public void setDay(Float day) {
            this.day = day;
        }

        public Float getMin() {
            return min;
        }

        public void setMin(Float min) {
            this.min = min;
        }

        public Float getMax() {
            return max;
        }

        public void setMax(Float max) {
            this.max = max;
        }


    }

