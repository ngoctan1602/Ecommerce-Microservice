package com.tantan.AddressServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ward")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String eng_code;
    private String name;
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}
