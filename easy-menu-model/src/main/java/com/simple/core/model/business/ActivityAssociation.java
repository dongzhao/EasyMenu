package com.simple.core.model.business;

import javax.persistence.*;

/**
 * Created by dzhao on 7/06/2015.
 */
@Entity
@DiscriminatorValue(value = "AA")
public class ActivityAssociation extends AbstractAssociation {


    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name="activity_id", nullable=true)
    private MyActivity activity;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name="linked_activity_id", nullable=true)
    private MyActivity linkedActivity;

    public MyActivity getActivity() {
        return activity;
    }

    public void setActivity(MyActivity activity) {
        this.activity = activity;
    }

    public MyActivity getLinkedActivity() {
        return linkedActivity;
    }

    public void setLinkedActivity(MyActivity linkedActivity) {
        this.linkedActivity = linkedActivity;
    }
}
