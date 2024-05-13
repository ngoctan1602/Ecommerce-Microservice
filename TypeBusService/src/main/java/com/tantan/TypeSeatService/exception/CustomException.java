package com.tantan.TypeSeatService.exception;

import com.tantan.TypeSeatService.response.DataResponse;
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
