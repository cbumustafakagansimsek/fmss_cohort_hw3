package com.example.fmss_cohort_hw3.exception;

import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return httpResponse.getStatusCode().is4xxClientError()
                || httpResponse.getStatusCode().is5xxServerError();
    }

    @SneakyThrows
    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode().is5xxServerError()) {
            if (httpResponse.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
                throw new ServiceUnAvailableException("Service is currently unavailable");
            }
            // handle more server errors
        } else if (httpResponse.getStatusCode().is4xxClientError()) {
            if (httpResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new AccessKeyInvalidException("Api key used on server is invalid");
            } else if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new RestTempBadRequestExeption(inputStreamToString(httpResponse.getBody()));
            }
            // handle more client errors
        }
    }

    private String inputStreamToString(InputStream inputStream) throws IOException{
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }
}