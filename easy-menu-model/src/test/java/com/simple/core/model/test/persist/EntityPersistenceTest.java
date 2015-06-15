package com.simple.core.model.test.persist;

import com.simple.core.model.business.ActivityType;
import com.simple.core.model.business.EntityType;
import com.simple.core.model.business.MyActivity;
import com.simple.core.model.business.MyEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class EntityPersistenceTest extends AbstractPersistenceTest<MyEntity, String> {

    @Test
    public void can_persist_domain(){

        EntityType entityType = new EntityType();
        entityType.setName("type1");
        entityType.setDescription("type description");
        entityType.setCreatedBy("user");
        entityType.setCreatedDatetime(new Date());
        entityType.setTemplateInfo("test");

        save(entityType);

   /*     ActivityType actrual = get(activityType.getId());
        Assert.assertNotNull(actrual);*/

        MyEntity domain = new MyEntity();
        domain.setName("entity name");
        domain.setDescription("entity description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setInfoJson("test");
        domain.setEntityType(entityType);

        save(domain);

        MyEntity actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
