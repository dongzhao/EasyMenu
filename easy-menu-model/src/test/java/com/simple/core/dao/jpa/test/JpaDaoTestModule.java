package com.simple.core.dao.jpa.test;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.simple.core.dao.jpa.inject.JpaDaoModule;

/**
 * Created by dzhao on 13/06/2015.
 */
public class JpaDaoTestModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new JpaDaoModule());
    }

    @Provides
    @Named("persistenceUnit")
    String providePersistenceUnitName(){
        return "unit-test";
    }
}
