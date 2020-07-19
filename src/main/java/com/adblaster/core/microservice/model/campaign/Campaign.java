package com.adblaster.core.microservice.model.campaign;

import com.adblaster.core.microservice.model.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * *  Created by Adewale Adeleye on 2019-07-20
 **/
@Entity
public class Campaign extends BaseEntity {
    private String name;
    private String id;
    private Date startDate;
    private Date endDate;
    private Double budget;
    private String action;
}
