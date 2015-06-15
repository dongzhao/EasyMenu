package com.simple.core.model.test.persist;

import com.simple.core.model.business.ActivityType;
import com.simple.core.model.business.MyActivity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class ActivityPersistenceTest extends AbstractPersistenceTest<MyActivity, String> {

    @Test
    public void can_persist_domain(){

        ActivityType activityType = new ActivityType();
        activityType.setName("type1");
        activityType.setDescription("type description");
        activityType.setCreatedBy("user");
        activityType.setCreatedDatetime(new Date());
        activityType.setTemplateInfo("test");

        save(activityType);

   /*     ActivityType actrual = get(activityType.getId());
        Assert.assertNotNull(actrual);*/

        MyActivity domain = new MyActivity();
        domain.setName("activity test name");
        domain.setDescription("activity description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setInfoJson("test");
        domain.setActivityType(activityType);

        save(domain);

        MyActivity actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
