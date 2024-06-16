# FMSS_COHORT_HW3
Patika.dev FMSS Bilişim Teknoloji Fullstack Web Bootcamp Cohort third homework


## About Project
Reflecting the data drawn from the weather API to the user on a daily, weekly and monthly basis.

* Java 21
* Maven

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

## Project Content
We're going to make a weather API. **https://www.visualcrossing.com/weather-api** is used as an api from this application.

Our main goal is to write an API to communicate with these APIs. Let's show the daily, weekly and monthly weather report according to the country / city information that we will get from the user.

The request will first come to the API you will write, then after you receive the request, you will request the Free Weather APIs and return this information.

You can use the very easy to use RestTemplate class for this process.

what is expected

* Making a correct API structure.
* Making validations on your models or parameters.
* Handling exceptions.

## URL

* http://localhost:8080/api/weather/today/{location}
* http://localhost:8080/api/weather/week/{location}
* http://localhost:8080/api/weather/month/{location}

### Installation

1. Clone the repo
```
git clone https://github.com/cbumustafakagansimsek/fmss_cohort_hw3.git
```
### Usage

1. go to folder of the project
```
cd .../fmss_cohort_hw3
```
2. run project
```
mvn spring-boot:run