package com.tantan.TypeSeatService.mapper;

import com.tantan.TypeSeatService.entity.TypeBus;
import com.tantan.TypeSeatService.request.TypeBusRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TypeBusMapper {
    TypeBusMapper INSTANCE = Mappers.getMapper(TypeBusMapper.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    TypeBus toEntity(TypeBusRequest typeBusRequest);
}
