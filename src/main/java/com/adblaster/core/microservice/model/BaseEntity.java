package com.adblaster.core.microservice.model;

import javax.persistence.*;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
