package com.tantan.AddressServices.exception;

import com.tantan.AddressServices.response.DataResponse;
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
