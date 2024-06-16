package com.example.fmss_cohort_hw3.service;


import com.example.fmss_cohort_hw3.dto.WeatherDto;
import com.example.fmss_cohort_hw3.exception.RestTemplateResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class ApiTransferComponent {

    private final String API_KEY = "2ATGL3X58H4KMGG3EN3B4DLDT";
    private final String URL= "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    private final String QUERY_PARAMS = "?unitGroup=metric&include=days%2Ccurrent&key="+API_KEY+"&contentType=json";

    private RestTemplate restTemplate;

    public ApiTransferComponent(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }
    public WeatherDto getCurrentDayWeatherFromApi(String location) {
        WeatherDto weatherData = restTemplate.getForObject(URL+location+"/"+"today"+QUERY_PARAMS,WeatherDto.class);
        return weatherData;

    }
    public WeatherDto getDailyWeatherFromApi(String location,int nextDays) {
        WeatherDto datas = restTemplate.getForObject(URL+location+"/"+getNowLocalDate()+"/"+getNowLocalDate().plusDays(nextDays-1)+QUERY_PARAMS,WeatherDto.class);
        return datas;
    }

    private LocalDate getNowLocalDate() {
        return LocalDate.now();
    }
    }
