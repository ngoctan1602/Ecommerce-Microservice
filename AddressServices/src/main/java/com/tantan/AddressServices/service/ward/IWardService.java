package com.tantan.AddressServices.service.ward;

import com.tantan.AddressServices.response.ward.WardResponse;

import java.util.List;

public interface IWardService {
    public List<WardResponse> getWardWithDistrictId(Long idDistrict);
}
