package com.tantan.StationService.mapper;


import com.tantan.StationService.entity.Station;
import com.tantan.StationService.request.StationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StationMapper {
    StationMapper INSTANCE = Mappers.getMapper(StationMapper.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "road", target = "road")
    @Mapping(source = "idWard", target = "idWard")
    Station toEntity(StationRequest district);
}
