package com.tantan.TypeSeatService.repository;

import com.tantan.TypeSeatService.entity.TypeBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeBusRepository extends JpaRepository<TypeBus,Long> {
   @Query(nativeQuery = true,value = "select * from `type-bus` where name like %?1% ")
    List<TypeBus> searchByName(String name);
}
