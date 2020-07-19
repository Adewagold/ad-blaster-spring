package com.adblaster.core.microservice.model.publisher;

import com.adblaster.core.microservice.model.BaseEntity;
import com.adblaster.core.microservice.model.userModel.Publisher;

import javax.persistence.*;
import java.util.List;

/**
 * *  Created by Adewale Adeleye on 2019-07-21
 **/
@Entity
public class Spot extends BaseEntity {
    private String name;
    private String description;
    private String location;
    private String thumbnail;
    private Long availaleSlot;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Publisher_Id")
//    private Publisher publisher;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "Spot_Publisher",
            joinColumns = {@JoinColumn(name = "Spot_Id", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "Publisher_Id", referencedColumnName = "Id")})
    private List<Publisher> publishers;

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getAvailaleSlot() {
        return availaleSlot;
    }

    public void setAvailaleSlot(Long availaleSlot) {
        this.availaleSlot = availaleSlot;
    }
}
