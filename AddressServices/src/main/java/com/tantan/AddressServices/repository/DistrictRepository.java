package com.tantan.AddressServices.repository;

import com.tantan.AddressServices.entity.District;
import com.tantan.AddressServices.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
    List<District> findByProvince(Province province);
}
