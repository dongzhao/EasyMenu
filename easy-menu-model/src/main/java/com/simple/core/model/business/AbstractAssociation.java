package com.simple.core.model.business;

import com.simple.core.model.generic.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by dzhao on 7/06/2015.
 */
@javax.persistence.Entity
@Table(name = "my_association")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="code", length=2)
public abstract class AbstractAssociation extends AbstractDomain {
    @NotNull(message = "association code cannot be null")
    private String code;
    @NotNull(message = "association name cannot be null")
    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Activity activityFrom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Activity activityTo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Entity entityFrom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Entity entityTo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private AssociationType associationType;

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

    public AssociationType getAssociationType() {
        return associationType;
    }

    public void setAssociationType(AssociationType associationType) {
        this.associationType = associationType;
    }

    public Activity getActivityTo() {
        return activityTo;
    }

    public void setActivityTo(Activity activityTo) {
        this.activityTo = activityTo;
    }

    public Entity getEntityTo() {
        return entityTo;
    }

    public void setEntityTo(Entity entityTo) {
        this.entityTo = entityTo;
    }

    public Activity getActivityFrom() {
        return activityFrom;
    }

    public void setActivityFrom(Activity activityFrom) {
        this.activityFrom = activityFrom;
    }

    public Entity getEntityFrom() {
        return entityFrom;
    }

    public void setEntityFrom(Entity entityFrom) {
        this.entityFrom = entityFrom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
