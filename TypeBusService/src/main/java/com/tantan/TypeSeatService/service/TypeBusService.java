package com.tantan.TypeSeatService.service;

import com.tantan.TypeSeatService.entity.Status;
import com.tantan.TypeSeatService.entity.TypeBus;
import com.tantan.TypeSeatService.exception.CustomException;
import com.tantan.TypeSeatService.mapper.TypeBusMapper;
import com.tantan.TypeSeatService.repository.TypeBusRepository;
import com.tantan.TypeSeatService.request.TypeBusRequest;
import com.tantan.TypeSeatService.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeBusService implements ITypeBusService {
    @Autowired
    private TypeBusRepository typeBusRepository;

    @Override
    public boolean createNewTypeBus(TypeBusRequest typeBusRequest) {
        TypeBus typeBus = TypeBusMapper.INSTANCE.toEntity(typeBusRequest);
        typeBus.setStatus(Status.CREATE);
        try {
            typeBusRepository.save(typeBus);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public TypeBus updateTypeBus(Long idTypebus, TypeBusRequest typeBusRequest) {
        TypeBus typeBus = typeBusRepository.findById(idTypebus).orElse(null);
        if (typeBus == null) {
            throw new CustomException(
                    new DataResponse(true, HttpStatus.NOT_FOUND.value(), "Not found typebus with id = " + idTypebus, null)
            );
        }
        typeBus.setName(typeBusRequest.getName());
        typeBus.setDescription(typeBusRequest.getDescription());
        try {
            return typeBusRepository.save(typeBus);
        } catch (Exception exception) {
            throw new CustomException(new DataResponse(true, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Have internal error", null));
        }

    }

    @Override
    public List<TypeBus> getAllTypeBus() {
        return typeBusRepository.findAll().stream().toList();
    }

    @Override
    public List<TypeBus> searchTypeBusByName(String name) {
        return typeBusRepository.searchByName(name).stream().toList();
    }
}
