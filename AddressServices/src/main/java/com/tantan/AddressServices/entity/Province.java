package com.tantan.AddressServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "province")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String eng_code;
    private String name;
    @OneToMany(mappedBy = "province")
    private List<District> districts= new ArrayList<>();

}
