package com.simple.core.model.test.persist;

import com.simple.core.model.business.ActivityType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class ActivityTypePersistenceTest extends AbstractPersistenceTest<ActivityType, String> {

    @Test
    public void can_persist_domain(){

        ActivityType domain = new ActivityType();
        //domain.setName("1001");
        domain.setName("type1");
        domain.setDescription("type description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setTemplateInfo("test");

        save(domain);

        ActivityType actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
