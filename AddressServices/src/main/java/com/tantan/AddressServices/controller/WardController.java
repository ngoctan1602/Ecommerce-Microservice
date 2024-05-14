package com.tantan.AddressServices.controller;

import com.tantan.AddressServices.response.DataResponse;
import com.tantan.AddressServices.response.district.DistrictResponse;
import com.tantan.AddressServices.response.ward.WardResponse;
import com.tantan.AddressServices.service.ward.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address/ward")
public class WardController {
    @Autowired
    private IWardService iWardService;
    @GetMapping("/")
    public ResponseEntity<DataResponse> getWardByDistrictID(@RequestParam long districtID) {
        List<WardResponse> wardResponses = iWardService.getWardWithDistrictId(districtID);
        if (!wardResponses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse(false, HttpStatus.OK.value(), "Get ward successfully", wardResponses)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DataResponse(false, HttpStatus.NOT_FOUND.value(), "Not found ward with districtID = "+districtID, null)
        );
    }
    @GetMapping("")
    public ResponseEntity<DataResponse> getWardWithId(@RequestParam long id) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse(false, HttpStatus.OK.value(), "Get ward successfully", iWardService.getWardById(id))
            );
    }
}
