package com.tantan.AddressServices.repository;

import com.tantan.AddressServices.entity.District;
import com.tantan.AddressServices.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward,Long> {
    List<Ward> findByDistrict(District district);
}
