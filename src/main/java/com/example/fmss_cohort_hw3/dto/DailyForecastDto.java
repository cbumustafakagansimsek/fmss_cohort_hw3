package com.example.fmss_cohort_hw3.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Getter
@Setter
public class DailyForecastDto{

    private LocalDate datetime;
    private long datetimeEpoch;
    private float temp;
    private float tempmax;
    private float tempmin;
    private float feelslike;
    private float feelslikemax;
    private float feelslikemin;
    private float dew;
    private float humidity;
    private float precip;
    private float precipprob;
    private float precipcover;
    private ArrayList<String> preciptype;
    private float snow;
    private float snowdepth;
    private float windgust;
    private float windspeed;
    private float winddir;
    private float pressure;
    private float cloudcover;
    private float visibility;
    private float solarradiation;
    private float solarenergy;
    private float uvindex;
    private float severerisk;
    private LocalTime sunrise;
    private Long sunriseEpoch;
    private LocalTime sunset;
    private Long sunsetEpoch;
    private float moonphase;
    private String conditions;
    private String description;
    private String icon;
    private ArrayList<String> stations;
    private String source;

}
