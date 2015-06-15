package com.simple.core.model.test.persist;

import com.simple.core.model.business.ActivityAssociation;
import com.simple.core.model.business.ActivityType;
import com.simple.core.model.business.AssociationType;
import com.simple.core.model.business.MyActivity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class ActivityAssociationPersistenceTest extends AbstractPersistenceTest<ActivityAssociation, String> {

    @Test
    public void can_persist_domain(){

        ActivityType activityType = new ActivityType();
        activityType.setName("type1");
        activityType.setDescription("type description");
        activityType.setCreatedBy("user");
        activityType.setCreatedDatetime(new Date());
        activityType.setTemplateInfo("test");

        save(activityType);

        MyActivity domainA = new MyActivity();
        domainA.setName("activity A");
        domainA.setDescription("activity description");
        domainA.setCreatedBy("user");
        domainA.setCreatedDatetime(new Date());
        domainA.setInfoJson("testA");
        domainA.setActivityType(activityType);

        save(domainA);

        MyActivity domainB = new MyActivity();
        domainB.setName("activityB");
        domainB.setDescription("activity description");
        domainB.setCreatedBy("user");
        domainB.setCreatedDatetime(new Date());
        domainB.setInfoJson("testB");
        domainB.setActivityType(activityType);

        save(domainB);


        AssociationType associationType = new AssociationType();
        associationType.setName("type1");
        associationType.setDescription("type description");
        associationType.setCreatedBy("user");
        associationType.setCreatedDatetime(new Date());

        save(associationType);

        ActivityAssociation domain = new ActivityAssociation();
        domain.setName("type1");
        domain.setDescription("type description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setActivity(domainA);
        domain.setLinkedActivity(domainB);
        domain.setAssociationType(associationType);

        save(domain);

        ActivityAssociation actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
