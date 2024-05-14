package com.tantan.StationService.client.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.tantan.StationService.exception.CustomException;
import com.tantan.StationService.response.DataResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class CustomErrorDecoder implements ErrorDecoder {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        String requestUrl = response.request().url();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        if (responseStatus.is5xxServerError()) {
            return new CustomException(
                    new DataResponse(true, responseStatus.value(), "Internal error", null)
            );
        } else if (responseStatus.is4xxClientError()) {
            // Extract error message from JSON response body
            String errorMessage = "";
            try {
                if (response.body() != null) {
                    errorMessage = objectMapper.readTree(response.body().asInputStream())
                            .get("message").asText();
                }
            } catch (IOException e) {
                // Handle error reading response body or parsing JSON
                e.printStackTrace();
            }
            // Include error message in DataResponse
            return new CustomException(
                    new DataResponse(true, responseStatus.value(), errorMessage, null)
            );
        } else {
            return new Exception("Generic exception");
        }
    }
}
