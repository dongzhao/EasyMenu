package com.simple.core.dao.jpa.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.simple.core.dao.api.Dao;
import com.simple.core.model.business.*;
import org.junit.Before;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzhao on 13/06/2015.
 */
public class AbstractJpaDaoTest {
    protected Injector injector;

    protected Dao<MyActivity, String> activityDao;
    protected Dao<MyEntity, String> entityDao;
    protected Dao<ActivityAssociation, String> activityAssociationDao;
    protected Dao<ActivityEntityAssociation, String> activityEntityAssociationDao;
    protected Dao<EntityAssociation, String> entityAssociationDao;
    protected Dao<ActivityType, String> activityTypeDao;
    protected Dao<EntityType, String> entityTypeDao;
    protected Dao<AssociationType, String> associationTypeDao;

    @Before
    public void setUp(){
        injector = Guice.createInjector(new JpaDaoTestModule());
        activityDao = injector.getInstance(new Key<Dao<MyActivity, String>>() {
        });
        entityDao = injector.getInstance(new Key<Dao<MyEntity, String>>(){});
        activityAssociationDao = injector.getInstance(new Key<Dao<ActivityAssociation, String>>(){});
        activityEntityAssociationDao = injector.getInstance(new Key<Dao<ActivityEntityAssociation, String>>(){});
        entityAssociationDao = injector.getInstance(new Key<Dao<EntityAssociation, String>>(){});
        activityTypeDao = injector.getInstance(new Key<Dao<ActivityType, String>>(){});
        entityTypeDao = injector.getInstance(new Key<Dao<EntityType, String>>(){});
        associationTypeDao = injector.getInstance(new Key<Dao<AssociationType, String>>(){});
    }

}
