package com.simple.core.model.business;

import com.simple.core.model.generic.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dzhao on 7/06/2015.
 */
@javax.persistence.Entity
@Table(name = "my_activity")
public class Activity extends AbstractDomain {

    @NotNull(message = "activity name cannot be null")
    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String description;
    @Column
    private String infoJson;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ActivityType activityType;

    @OneToMany(mappedBy = "activity")
    private List<AbstractAssociation> associations;

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

    public String getInfoJson() {
        return infoJson;
    }

    public void setInfoJson(String infoJson) {
        this.infoJson = infoJson;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public List<AbstractAssociation> getAssociations() {
        return associations;
    }

    public void setAssociations(List<AbstractAssociation> associations) {
        this.associations = associations;
    }
}


