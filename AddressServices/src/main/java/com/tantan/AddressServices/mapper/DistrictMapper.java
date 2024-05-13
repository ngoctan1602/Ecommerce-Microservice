package com.tantan.AddressServices.mapper;

import com.tantan.AddressServices.entity.District;
import com.tantan.AddressServices.response.district.DistrictResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "eng_code", target = "eng_code")
    DistrictResponse toResponse(District district);
}
