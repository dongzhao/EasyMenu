package com.simple.core.model.test.persist;

import com.simple.core.model.business.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class EntityAssociationPersistenceTest extends AbstractPersistenceTest<EntityAssociation, String> {

    @Test
    public void can_persist_domain(){

        EntityType entityType = new EntityType();
        entityType.setName("type1");
        entityType.setDescription("type description");
        entityType.setCreatedBy("user");
        entityType.setCreatedDatetime(new Date());
        entityType.setTemplateInfo("test");

        save(entityType);

        MyEntity domainA = new MyEntity();
        domainA.setName("entity A");
        domainA.setDescription("entity description");
        domainA.setCreatedBy("user");
        domainA.setCreatedDatetime(new Date());
        domainA.setInfoJson("testA");
        domainA.setEntityType(entityType);

        save(domainA);

        MyEntity domainB = new MyEntity();
        domainB.setName("entity B");
        domainB.setDescription("entity description");
        domainB.setCreatedBy("user");
        domainB.setCreatedDatetime(new Date());
        domainB.setInfoJson("testB");
        domainB.setEntityType(entityType);

        save(domainB);


        AssociationType associationType = new AssociationType();
        associationType.setName("type1");
        associationType.setDescription("type description");
        associationType.setCreatedBy("user");
        associationType.setCreatedDatetime(new Date());

        save(associationType);

        EntityAssociation domain = new EntityAssociation();
        domain.setName("type1");
        domain.setDescription("type description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setEntity(domainA);
        domain.setLinkedEntity(domainB);
        domain.setAssociationType(associationType);

        save(domain);

        EntityAssociation actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
