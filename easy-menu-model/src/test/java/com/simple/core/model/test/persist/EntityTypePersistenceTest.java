package com.simple.core.model.test.persist;

import com.simple.core.model.business.ActivityType;
import com.simple.core.model.business.EntityType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class EntityTypePersistenceTest extends AbstractPersistenceTest<EntityType, String> {

    @Test
    public void can_persist_domain(){

        EntityType domain = new EntityType();
        domain.setName("type1");
        domain.setDescription("type description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setTemplateInfo("test");

        save(domain);

        EntityType actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
