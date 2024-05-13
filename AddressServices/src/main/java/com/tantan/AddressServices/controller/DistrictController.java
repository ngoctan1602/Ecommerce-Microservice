package com.tantan.AddressServices.controller;

import com.tantan.AddressServices.response.district.DistrictResponse;
import com.tantan.AddressServices.response.DataResponse;
import com.tantan.AddressServices.service.district.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address/district")
public class DistrictController {
    @Autowired
    private IDistrictService iDistrictService;
    @GetMapping("/")
    public ResponseEntity<DataResponse> getDistrictByIdProvince(@RequestParam long provinceId) {
        List<DistrictResponse> district = iDistrictService.getDistrictByIdProvince(provinceId);
        if (!district.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse(false, HttpStatus.OK.value(), "Get province successfully", district)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DataResponse(false, HttpStatus.NOT_FOUND.value(), "Not found district with provinceid = "+provinceId, null)
        );
    }
}
