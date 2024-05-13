package com.tantan.AddressServices.service.district;

import com.tantan.AddressServices.response.district.DistrictResponse;

import java.util.List;

public interface IDistrictService {
    public List<DistrictResponse> getDistrictByIdProvince(Long idProvince);
}
