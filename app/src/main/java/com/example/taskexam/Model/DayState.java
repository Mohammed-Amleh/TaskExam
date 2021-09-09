package com.example.taskexam.Model;

import com.google.gson.annotations.SerializedName;

public class DayState {


        @SerializedName("dt")
        private Integer dt;
        @SerializedName("sunrise")

        private Integer sunrise;
        @SerializedName("sunset")

        private Integer sunset;

        @SerializedName("temp")
        private Temp temp;

        @SerializedName("pressure")
        private Integer pressure;

        @SerializedName("humidity")
        private Integer humidity;



        public Integer getDt() {
            return dt;
        }

        public void setDt(Integer dt) {
            this.dt = dt;
        }

        public Integer getSunrise() {
            return sunrise;
        }

        public void setSunrise(Integer sunrise) {
            this.sunrise = sunrise;
        }

        public Integer getSunset() {
            return sunset;
        }

        public void setSunset(Integer sunset) {
            this.sunset = sunset;
        }

        public Temp getTemp() {
            return temp;
        }

        public void setTemp(Temp temp) {
            this.temp = temp;
        }


        public Integer getPressure() {
            return pressure;
        }

        public void setPressure(Integer pressure) {
            this.pressure = pressure;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }



}
