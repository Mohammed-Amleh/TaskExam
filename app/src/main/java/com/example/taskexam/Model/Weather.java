package com.example.taskexam.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather{

        @SerializedName("cnt")
        private Integer cnt;

        @SerializedName("list")
        private List<DayState> list = null;


        public Integer getCnt() {
            return cnt;
        }

        public void setCnt(Integer cnt) {
            this.cnt = cnt;
        }

        public List<DayState> getList() {
            return list;
        }

        public void setList(List<DayState> list) {
            this.list = list;
        }


}