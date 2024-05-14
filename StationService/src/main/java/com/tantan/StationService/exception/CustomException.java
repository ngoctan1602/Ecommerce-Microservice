package com.tantan.StationService.exception;


import com.tantan.StationService.response.DataResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CustomException extends RuntimeException{
    private DataResponse dataResponse;

    public CustomException(DataResponse dataResponse) {
        super(dataResponse.getMessage());
        this.dataResponse = dataResponse;
    }
}
