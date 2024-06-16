package com.example.fmss_cohort_hw3.controller;


import com.example.fmss_cohort_hw3.dto.WeatherDto;
import com.example.fmss_cohort_hw3.service.WeatherService;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/weather")
@RestController
@AllArgsConstructor
@Validated
public class WeatherController {
    private final WeatherService weatherService;

    //today's weather data
    @GetMapping("/today/{location}")
    public ResponseEntity<WeatherDto> getTodayWeatherData(@PathVariable
                                                                        @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s-]+[a-zA-Z]$",
                                                                                message = "Invalid location found. Please check your location parameter")
                                                                        String location) {
        return ResponseEntity.ok(weatherService.getCurrentDayWeather(location));
    }
    //weather data for the next 7 days
    @GetMapping("/week/{location}")
    public ResponseEntity<WeatherDto> getNextWeekWeatherDatas(@PathVariable
                                                                        @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s-]+[a-zA-Z]$",
                                                                                message = "Invalid location found. Please check your location parameter")
                                                                        String location) {
        return ResponseEntity.ok(weatherService.getNextWeekWeather(location));
    }
    //weather data for the next 30 days
    @GetMapping("/month/{location}")
    public ResponseEntity<WeatherDto> getNextMonthWeatherDatas(@PathVariable
                                                                         @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s-]+[a-zA-Z]$",
                                                                                 message = "Invalid location found. Please check your location parameter")
                                                                         String location) {
        return ResponseEntity.ok(weatherService.getNextMonthWeather(location));
    }

}
