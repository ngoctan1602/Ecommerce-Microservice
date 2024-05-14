package com.tantan.StationService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tantan.StationService.client.AddressClient;
import com.tantan.StationService.client.response.WardResponse;
import com.tantan.StationService.entity.Station;
import com.tantan.StationService.mapper.StationMapper;
import com.tantan.StationService.repository.StationRepository;
import com.tantan.StationService.request.StationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.DataInput;
import java.io.IOException;
import java.util.Objects;

@Service
public class StationService implements IStationService {
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    AddressClient addressClient;

    @Override
    @Transactional
    public boolean createNewStation(StationRequest stationRequest) {
        ObjectMapper mapper = new ObjectMapper();
        Object object = addressClient.getWardWithId(stationRequest.getIdWard()).getBody().getData();

        WardResponse wardResponse = mapper.convertValue(object, WardResponse.class);
        Station station = StationMapper.INSTANCE.toEntity(stationRequest);
        station.setFullAddress(wardResponse.getFullAddress());
        try {
            stationRepository.save(station);
            return true;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
