package com.tantan.AddressServices.response.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictResponse {
    private long id;
    private String name;
    private String eng_code;
}
