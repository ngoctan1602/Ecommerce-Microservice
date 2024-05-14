package com.tantan.StationService.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardResponse {
    private long id;
    private String name;
    private String eng_code;
    private String fullAddress;
}
