package com.ikubinfo.project.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceSingleton {
    instance;

    private EntityManagerFactory entityManagerFactory;

    private EntityManagerFactory setupEntityManagerFactory() {
        return Persistence.createEntityManagerFactory( "akademia" );
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null){
            entityManagerFactory = setupEntityManagerFactory();
        }
        return entityManagerFactory;
    }

    public void destroy() {
        entityManagerFactory.close();
    }
}
