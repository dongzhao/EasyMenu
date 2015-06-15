package com.simple.core.dao.jpa.test;

import com.simple.core.model.business.ActivityType;
import com.simple.core.model.business.MyActivity;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dzhao on 13/06/2015.
 */
public class MyActivityDaoTest extends AbstractJpaDaoTest{

    @Test
    public void can_save(){
        ActivityType activityType = new ActivityType();
        activityType.setName("type1");
        activityType.setDescription("type description");
        activityType.setCreatedBy("user");
        activityType.setCreatedDatetime(new Date());
        activityType.setTemplateInfo("test");

        activityTypeDao.save(activityType);

   /*     ActivityType actrual = get(activityType.getId());
        Assert.assertNotNull(actrual);*/

        MyActivity domain = new MyActivity();
        domain.setName("activity test name");
        domain.setDescription("activity description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());
        domain.setInfoJson("test");
        domain.setActivityType(activityType);

        activityDao.save(domain);

        MyActivity actrual = activityDao.get(domain.getId());

        Assert.assertNotNull(actrual);

/*        Assert.assertEquals("incorrect Name",testName, actrual.getName());
        Assert.assertEquals("incorrect CreatedBy",testUser, actrual.getCreatedBy());
        Assert.assertEquals("incorrect LastModifiedBy",testUser, actrual.getLastModifiedBy());
        Assert.assertEquals("incorrect CreationDate",sdf.format(testDate), sdf.format(actrual.getCreationDate()));
        Assert.assertEquals("incorrect LastModificationDate",sdf.format(testDate), sdf.format(actrual.getLastModificationDate()));
        Assert.assertEquals("incorrect Description",testDescription, actrual.getDescription());
        Assert.assertEquals("incorrect Title",testTitle, actrual.getTitle());
        Assert.assertEquals("incorrect FolderPath",testFolderPath, actrual.getPath());*/


    }
}
