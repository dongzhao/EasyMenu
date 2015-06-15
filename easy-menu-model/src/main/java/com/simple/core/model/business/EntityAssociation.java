package com.simple.core.model.business;

import javax.persistence.*;

/**
 * Created by dzhao on 7/06/2015.
 */
@Entity
@DiscriminatorValue(value = "EE")
public class EntityAssociation extends AbstractAssociation {
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name="entity_id", nullable=true)
    private MyEntity entity;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name="linked_entity_id", nullable=true)
    private MyEntity linkedEntity;

    public MyEntity getEntity() {
        return entity;
    }

    public void setEntity(MyEntity entity) {
        this.entity = entity;
    }

    public MyEntity getLinkedEntity() {
        return linkedEntity;
    }

    public void setLinkedEntity(MyEntity linkedEntity) {
        this.linkedEntity = linkedEntity;
    }
}
