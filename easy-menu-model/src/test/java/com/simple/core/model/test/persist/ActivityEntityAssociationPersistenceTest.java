package com.simple.core.model.test.persist;

import com.simple.core.model.business.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class ActivityEntityAssociationPersistenceTest extends AbstractPersistenceTest<ActivityEntityAssociation, String> {

    @Test
    public void can_persist_domain(){

        ActivityType activityType = new ActivityType();
        activityType.setName("type1");
        activityType.setDescription("type description");
        activityType.setCreatedBy("user");
        activityType.setCreatedDatetime(new Date());
        activityType.setTemplateInfo("test");

        save(activityType);

        EntityType entityType = new EntityType();
        entityType.setName("type1");
        entityType.setDescription("type description");
        entityType.setCreatedBy("user");
        entityType.setCreatedDatetime(new Date());
        entityType.setTemplateInfo("test");

        save(entityType);

        MyActivity domainA = new MyActivity();
        domainA.setName("activity A");
        domainA.setDescription("activity description");
        domainA.setCreatedBy("user");
        domainA.setCreatedDatetime(new Date());
        domainA.setInfoJson("testA");
        domainA.setActivityType(activityType);

        save(domainA);

        MyEntity domainB = new MyEntity();
        domainB.setName("entity B");
        domainB.setDescription("entity description");
        domainB.setCreatedBy("user");
        domainB.setCreatedDatetime(new Date());
        domainB.setInfoJson("testB");
        domainB.setEntityType(entityType);


        AssociationType associationType = new AssociationType();
        associationType.setName("type1");
        associationType.setDescription("type description");
        associationType.setCreatedBy("user");
        associationType.setCreatedDatetime(new Date());

        save(associationType);

        ActivityEntityAssociation domain = new ActivityEntityAssociation();
        domain.setName("type1");
        domain.setDescription("type description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setActivity(domainA);
        domain.setEntity(domainB);
        domain.setAssociationType(associationType);

        save(domain);

        ActivityEntityAssociation actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
