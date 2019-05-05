package com.proface.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="bank")
@Data
@NoArgsConstructor
public class Bank {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="account_number_mask")
    private String accountNumberMask;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

}
