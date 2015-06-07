package com.simple.core.model.test.persist;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by dzhao on 8/06/2015.
 */
public class PersistenceTestModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    EntityManagerFactory provideEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("unit-test");
    }
}

