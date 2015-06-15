package com.simple.core.model.business;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by dzhao on 7/06/2015.
 */
@Entity
@DiscriminatorValue(value = "AE")
public class ActivityEntityAssociation extends AbstractAssociation {
    @ManyToOne
    @JoinColumn(name="activity_id", nullable=true)
    private MyActivity activity;

    @ManyToOne
    @JoinColumn(name="entity_id", nullable=true)
    private MyEntity entity;

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
    }
}
