package com.tantan.AddressServices.mapper;

import com.tantan.AddressServices.entity.Province;
import com.tantan.AddressServices.request.province.ProvinceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProvinceMapper {
    ProvinceMapper INSTANCE = Mappers.getMapper(ProvinceMapper.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "eng_code", target = "eng_code")
    Province toEntity(ProvinceRequest typeBusRequest);
}
