package com.simple.core.model.business;

import com.simple.core.model.generic.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
/**
 * Created by dzhao on 7/06/2015.
 */
@Entity
@Table(name = "my_entity")
public class MyEntity extends AbstractDomain {
    @NotNull(message = "entity name cannot be null")
    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String description;
    @Column
    private String infoJson;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id")
    private EntityType entityType;

/*    @OneToMany(mappedBy = "entity")
    private List<AbstractAssociation> associations;*/

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

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

/*
    public List<AbstractAssociation> getAssociations() {
        return associations;
    }

    public void setAssociations(List<AbstractAssociation> associations) {
        this.associations = associations;
    }
*/
}
