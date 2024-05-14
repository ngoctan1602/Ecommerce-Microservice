package com.tantan.StationService.client;

import com.tantan.StationService.client.config.MyFeignClientConfiguration;
import com.tantan.StationService.response.DataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ward", url = "http://localhost:8331/address", configuration = MyFeignClientConfiguration.class)
public interface AddressClient {
    @GetMapping("/ward")
    public ResponseEntity<DataResponse> getWardWithId(@RequestParam long id);
}
