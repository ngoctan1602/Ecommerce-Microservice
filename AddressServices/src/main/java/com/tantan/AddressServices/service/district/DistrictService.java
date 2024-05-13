package com.tantan.AddressServices.service.district;

import com.tantan.AddressServices.entity.Province;
import com.tantan.AddressServices.exception.CustomException;
import com.tantan.AddressServices.mapper.DistrictMapper;
import com.tantan.AddressServices.repository.DistrictRepository;
import com.tantan.AddressServices.repository.ProvinceRepository;
import com.tantan.AddressServices.response.district.DistrictResponse;
import com.tantan.AddressServices.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService implements IDistrictService{
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public List<DistrictResponse> getDistrictByIdProvince(Long idProvince) {
        Province province = provinceRepository.findById(idProvince).orElseThrow(
                ()-> new CustomException(new DataResponse(
                        false, HttpStatus.NOT_FOUND.value(),"Not found district with id = "+ idProvince,null
                ))
        );
        return districtRepository.findByProvince(province).stream().map(
                DistrictMapper.INSTANCE::toResponse
        ).toList();
    }
}
