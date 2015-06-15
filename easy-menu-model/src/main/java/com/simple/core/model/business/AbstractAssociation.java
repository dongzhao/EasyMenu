package com.simple.core.model.business;

import com.simple.core.model.generic.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

/**
 * Created by dzhao on 7/06/2015.
 */
@Entity
@Table(name = "my_association")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="code", length=2)
public abstract class AbstractAssociation extends AbstractDomain {
/*    @NotNull(message = "association code cannot be null")
    private String code;*/
    @NotNull(message = "association name cannot be null")
    @Column(length = 50)
    protected String name;
    @Column(length = 100)
    protected String description;

/*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="activity_id", nullable=true)
    private MyActivity activity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="linked_activity_id", nullable=true)
    private MyActivity linkedActivity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="entity_id", nullable=true)
    private MyEntity entity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="linked_entity_id", nullable=true)
    private MyEntity linkedEntity;
*/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="type_id")
    protected AssociationType associationType;

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

 /*   public MyActivity getLinkedActivity() {
        return linkedActivity;
    }

    public void setLinkedActivity(MyActivity linkedActivity) {
        this.linkedActivity = linkedActivity;
    }

    public MyEntity getLinkedEntity() {
        return linkedEntity;
    }

    public void setLinkedEntity(MyEntity linkedEntity) {
        this.linkedEntity = linkedEntity;
    }

    public MyActivity getActivity() {
        return activity;
    }

    public void setActivity(MyActivity activity) {
        this.activity = activity;
    }

    public MyEntity getEntity() {
        return entity;
    }

    public void setEntity(MyEntity entity) {
        this.entity = entity;
    }*/

/*    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }*/
}
