package com.mihael.petstore.dao;

import com.mihael.petstore.entity.History;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Component
public class HistoryDaoProduction implements HistoryDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveHistory(History history) {
        this.em.persist(history);
    }
}
