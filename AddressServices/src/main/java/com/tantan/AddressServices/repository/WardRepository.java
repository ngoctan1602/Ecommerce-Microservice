package com.tantan.AddressServices.repository;

import com.tantan.AddressServices.entity.District;
import com.tantan.AddressServices.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward,Long> {
    List<Ward> findByDistrict(District district);

    @Query(nativeQuery = true,
    value = "select concat(ward.name,\", \",district.name,\", \",province.name) as fullAddress from ward \n" +
            "join district on ward.district_id = district.id and ward.id =?\n" +
            "join province on district.province_id = province.id ")
    String  getFullAddressWithId(Long idWard);
}
