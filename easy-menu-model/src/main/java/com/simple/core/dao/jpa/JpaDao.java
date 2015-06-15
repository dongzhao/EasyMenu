package com.simple.core.dao.jpa;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.simple.core.dao.api.Dao;
import com.simple.core.dao.jpa.provider.EntityManagerProvider;
import com.simple.core.model.generic.BaseDomain;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class JpaDao<T extends BaseDomain<ID>, ID extends Serializable> implements Dao<T, ID> {

    //private static final Logger logger = LoggerFactory.getLogger(Dao.class);

    private final EntityManagerProvider entityManagerProvider;

    protected final Class<T> clazz;

    @Inject
    public JpaDao(TypeLiteral<T> type, EntityManagerProvider entityManagerProvider){
        this.entityManagerProvider = entityManagerProvider;
        this.clazz = (Class<T>)type.getRawType();
/*        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if(types[0] instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) types[0];
            setClazz( (Class<BaseDomain<ID>>) type.getRawType() );
        }else{
            setClazz((Class<BaseDomain<ID>>) types[0]);
        }*/

    }

    public T save(T entity) {
        EntityManager em = entityManagerProvider.get();
        try {
            em.getTransaction().begin();
            if (entity.getId() != null) {
                entity = em.merge(entity);
            } else {
                em.persist(entity);
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            //logger.error(e.getMessage(), e);
            em.getTransaction().rollback();
        } finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
        return entity;
    }

    public void save(final T... entities) {
        for (T entity : entities){
            save(entity);
        }
    }

    public T get(ID id) {
        EntityManager em = entityManagerProvider.get();
        T entity = null;
        try{
            entity = entityManagerProvider.get().find(clazz, id);
        }finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
        return entity;
    }

    @SuppressWarnings("JpaQlInspection")
    public List<T> getAll(){
        EntityManager em = entityManagerProvider.get();
        List<T> results = null;
        try{
            Query query = em.createQuery("select e from " + clazz.getName() + " e");
            results = (List<T>)query.getResultList();
        }finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
        return results;
    }

    public T update(T entity) {
        return save(entity);
    }

    public void delete(final T entity) {
        EntityManager em = entityManagerProvider.get();
        try{
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            //logger.error(e.getMessage(), e);
            em.getTransaction().rollback();
        }finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }
}
