package com.simple.core.dao.jpa.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.simple.core.dao.api.Dao;
import com.simple.core.dao.jpa.JpaDao;
import com.simple.core.dao.jpa.provider.EntityManagerProvider;
import com.simple.core.model.business.*;
import com.simple.core.model.generic.AbstractDomain;

import org.reflections.Reflections;

import javax.persistence.EntityManager;
import java.util.Set;

/**
 * Created by dzhao on 13/06/2015.
 */
public class JpaDaoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EntityManager.class).toProvider(EntityManagerProvider.class).in(Singleton.class);

        Reflections reflections = new Reflections("com.simple.core.model");
        Set<Class<? extends AbstractDomain>> classSet = reflections.getSubTypesOf(AbstractDomain.class);
/*        for (Class<? extends AbstractDomain> clazz : classSet){
            String className = clazz.getName();
            try {
                final T obj = Class.forName(className);
                bind(new TypeLiteral<Dao<obj, String>>(){})
                        .to(new TypeLiteral<JpaDao<obj, String>>(){})
                        .in(Scopes.SINGLETON);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }*/
/*
        bind(new TypeLiteral<Dao<DbFolder, String>>(){}).to(new TypeLiteral<JpaDao<DbFolder, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<DbFile, String>>(){}).to(new TypeLiteral<JpaDao<DbFile, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<DbFileContent, String>>(){}).to(new TypeLiteral<JpaDao<DbFileContent, String>>(){}).in(Scopes.SINGLETON);
*/
        bind(new TypeLiteral<Dao<MyActivity, String>>(){}).to(new TypeLiteral<JpaDao<MyActivity, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<MyEntity, String>>(){}).to(new TypeLiteral<JpaDao<MyEntity, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<ActivityAssociation, String>>(){}).to(new TypeLiteral<JpaDao<ActivityAssociation, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<ActivityEntityAssociation, String>>(){}).to(new TypeLiteral<JpaDao<ActivityEntityAssociation, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<EntityAssociation, String>>(){}).to(new TypeLiteral<JpaDao<EntityAssociation, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<ActivityType, String>>(){}).to(new TypeLiteral<JpaDao<ActivityType, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<EntityType, String>>(){}).to(new TypeLiteral<JpaDao<EntityType, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<AssociationType, String>>(){}).to(new TypeLiteral<JpaDao<AssociationType, String>>(){}).in(Scopes.SINGLETON);
    }
}
