package com.tantan.AddressServices.service.province;

import com.tantan.AddressServices.entity.Province;
import com.tantan.AddressServices.mapper.ProvinceMapper;
import com.tantan.AddressServices.repository.ProvinceRepository;
import com.tantan.AddressServices.request.province.ProvinceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public boolean insertProvince(ProvinceRequest provinceRequest) {
        Province province = ProvinceMapper.INSTANCE.toEntity(provinceRequest);
        try {
            provinceRepository.save(province);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
