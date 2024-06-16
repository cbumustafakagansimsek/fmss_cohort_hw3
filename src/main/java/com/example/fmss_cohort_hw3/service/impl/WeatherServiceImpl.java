package com.example.fmss_cohort_hw3.service.impl;


import com.example.fmss_cohort_hw3.dto.WeatherDto;
import com.example.fmss_cohort_hw3.service.ApiTransferComponent;
import com.example.fmss_cohort_hw3.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final ApiTransferComponent apiTransferComponent;

    @Override
    public WeatherDto getCurrentDayWeather(String location){
        return apiTransferComponent.getCurrentDayWeatherFromApi(location);
    }

    @Override
    public WeatherDto getNextWeekWeather(String location){
        return apiTransferComponent.getDailyWeatherFromApi(location,7);
    }

    @Override
    public WeatherDto getNextMonthWeather(String location){
        return apiTransferComponent.getDailyWeatherFromApi(location,30);
    }
}
