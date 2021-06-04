package com.ani.orm.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chId;
    private Boolean isPrg;
    private String compatibility;
}
