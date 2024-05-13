package com.tantan.AddressServices.mapper;

import com.tantan.AddressServices.entity.District;
import com.tantan.AddressServices.entity.Ward;
import com.tantan.AddressServices.response.district.DistrictResponse;
import com.tantan.AddressServices.response.ward.WardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WardMapper {
    WardMapper INSTANCE = Mappers.getMapper(WardMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "eng_code", target = "eng_code")
    WardResponse toResponse(Ward district);
}
