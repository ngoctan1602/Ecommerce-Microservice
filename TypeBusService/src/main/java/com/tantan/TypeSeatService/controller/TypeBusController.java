package com.tantan.TypeSeatService.controller;

import com.tantan.TypeSeatService.entity.TypeBus;
import com.tantan.TypeSeatService.request.TypeBusRequest;
import com.tantan.TypeSeatService.response.DataResponse;
import com.tantan.TypeSeatService.service.ITypeBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typebus")
public class TypeBusController {
    @Autowired
    private ITypeBusService iTypeBusService;

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createNewTypeBus(@RequestBody TypeBusRequest typeBusRequest) {
        boolean created = iTypeBusService.createNewTypeBus(typeBusRequest);
        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new DataResponse(false, HttpStatus.CREATED.value(), "Type bus created", null)
            );
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DataResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Type bus faileds", null)
        );
    }

    @PutMapping("/update")
    public ResponseEntity<DataResponse> updateTypeBus(@RequestParam Long idTypeBus, @RequestBody TypeBusRequest typeBusRequest) {
        TypeBus typeBus = iTypeBusService.updateTypeBus(idTypeBus, typeBusRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse(false, HttpStatus.OK.value(), "Type bus update successfully", typeBus)
        );
    }

    @GetMapping("/")
    public ResponseEntity<DataResponse> getAllTypebus() {
        List<TypeBus> typeBuses = iTypeBusService.getAllTypeBus();
        if (!typeBuses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse(false, HttpStatus.CREATED.value(), "Get type bus successfully", typeBuses)
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse(false, HttpStatus.OK.value(), "Not found type bus", null)
        );
    }

    @GetMapping("/search")
    public ResponseEntity<DataResponse> searchByName(@RequestParam String name) {
        List<TypeBus> typeBuses = iTypeBusService.searchTypeBusByName(name);
        if (!typeBuses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse(false, HttpStatus.CREATED.value(), "Get type bus by name successfully", typeBuses)
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse(false, HttpStatus.OK.value(), "Not found type bus", null)
        );
    }
}
