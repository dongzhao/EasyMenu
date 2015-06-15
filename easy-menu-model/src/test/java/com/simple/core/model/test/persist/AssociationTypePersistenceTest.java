package com.simple.core.model.test.persist;

import com.simple.core.model.business.AssociationType;
import com.simple.core.model.business.EntityType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dzhao on 8/06/2015.
 */
public class AssociationTypePersistenceTest extends AbstractPersistenceTest<AssociationType, String> {

    @Test
    public void can_persist_domain(){

        AssociationType domain = new AssociationType();
        domain.setName("type1");
        domain.setDescription("type description");
        domain.setCreatedBy("user");
        domain.setCreatedDatetime(new Date());

        save(domain);

        AssociationType actrual = get(domain.getId());
        Assert.assertNotNull(actrual);
    }
}
