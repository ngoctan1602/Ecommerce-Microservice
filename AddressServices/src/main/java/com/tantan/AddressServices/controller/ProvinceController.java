package com.tantan.AddressServices.controller;

import com.tantan.AddressServices.request.province.ProvinceRequest;
import com.tantan.AddressServices.response.DataResponse;
import com.tantan.AddressServices.service.province.IProvinceService;
import com.tantan.AddressServices.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address/province")
public class ProvinceController {
    @Autowired
    private IProvinceService iProvinceService;
    @PostMapping("/create")
    public ResponseEntity<DataResponse> createProvince(@RequestBody ProvinceRequest provinceRequest) {
        boolean typeBuses = iProvinceService.insertProvince(provinceRequest);
        if (typeBuses) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new DataResponse(false, HttpStatus.CREATED.value(), "Insert province successfully", null)
            );
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL_SERVER_ERROR", null)
        );
    }
}
