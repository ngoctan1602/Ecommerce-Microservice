package com.tantan.AddressServices.service.ward;

import com.tantan.AddressServices.entity.District;
import com.tantan.AddressServices.entity.Ward;
import com.tantan.AddressServices.exception.CustomException;
import com.tantan.AddressServices.mapper.WardMapper;
import com.tantan.AddressServices.repository.DistrictRepository;
import com.tantan.AddressServices.repository.WardRepository;
import com.tantan.AddressServices.response.DataResponse;
import com.tantan.AddressServices.response.ward.WardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService implements IWardService {
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<WardResponse> getWardWithDistrictId(Long idDistrict) {
        District district = districtRepository.findById(idDistrict).orElseThrow(
                () -> new CustomException(new DataResponse(true, HttpStatus.NOT_FOUND.value(), "Not found ward with idDistrict = " + idDistrict, null))
        );
        List<WardResponse> wardResponses = wardRepository.findByDistrict(district).stream().
                map(WardMapper.INSTANCE::toResponse).toList();
        return wardResponses;
    }
}
