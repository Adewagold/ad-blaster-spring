package com.adblaster.core.microservice.model.userModel;

import com.adblaster.core.microservice.model.publisher.Spot;
import com.adblaster.core.microservice.model.security.User;

import javax.persistence.*;
import java.util.List;

/**
 * *  Created by Adewale Adeleye on 2019-07-19
 **/
@Entity
@Table(name = "Publisher")
public class Publisher extends UserType {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany(mappedBy = "publishers", fetch = FetchType.LAZY)
    private List<Spot> spots;

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    private String website;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
