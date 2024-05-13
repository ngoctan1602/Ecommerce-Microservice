package com.tantan.TypeSeatService.service;

import com.tantan.TypeSeatService.entity.TypeBus;
import com.tantan.TypeSeatService.request.TypeBusRequest;

import java.util.List;

public interface ITypeBusService {
    public boolean createNewTypeBus(TypeBusRequest typeBusRequest);
    public TypeBus updateTypeBus(Long idTypeBus,TypeBusRequest typeBusRequest);
    public List<TypeBus> getAllTypeBus();
    public List<TypeBus> searchTypeBusByName(String name);
}
