package com.example.fmss_cohort_hw3.service;


import com.example.fmss_cohort_hw3.dto.WeatherDto;

public interface WeatherService {
    //input String output WeatherDto
    WeatherDto getCurrentDayWeather(String location);

    //input String output WeatherDto
    WeatherDto getNextWeekWeather(String location);

    //input String output WeatherDto
    WeatherDto getNextMonthWeather(String location);
}
