package com.adblaster.core.microservice.model;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * *  Created by Adewale Adeleye on 2019-07-06
 **/
@Entity
public class Country extends BaseEntity {
    private String countryCode;
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return Objects.equals(countryCode, country1.countryCode) &&
                Objects.equals(country, country1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, country);
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + getId() +
                ",countryCode:'" + countryCode + '\'' +
                ", country:'" + country + '\'' +
                '}';
    }
}
