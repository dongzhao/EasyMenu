package com.simple.core.model.test.persist;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.simple.core.model.generic.BaseDomain;
import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by dzhao on 7/06/2015.
 */
public abstract class PersistenceTest<T extends BaseDomain<ID>, ID extends Serializable> {

    protected Injector injector;
    protected static EntityManagerFactory emf;
    protected Class<T> clazz;

    public PersistenceTest(){
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (types[0] instanceof ParameterizedType) {
            // If the class has parameterized types, it takes the raw type.
            ParameterizedType type = (ParameterizedType) types[0];
            clazz = (Class<T>) type.getRawType();
        } else {
            clazz = (Class<T>) types[0];
        }
    }

    @Before
    public void setUp(){
        injector = Guice.createInjector(new PersistenceTestModule());
        emf = injector.getInstance(EntityManagerFactory.class);
    }

    @After
    public void tearDown(){
        emf.close();
    }

    protected <T> void save(T domain){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(domain);
        em.getTransaction().commit();
    }

    protected <T> T get(ID id){
        EntityManager em = emf.createEntityManager();
        return (T)em.find(clazz, id);
    }

}