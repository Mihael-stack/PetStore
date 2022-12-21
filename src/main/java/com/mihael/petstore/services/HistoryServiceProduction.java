package com.mihael.petstore.services;

import com.mihael.petstore.dao.HistoryDao;
import com.mihael.petstore.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HistoryServiceProduction implements HistoryService{
    private final HistoryDao historyDao;

    @Autowired
    public HistoryServiceProduction(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    @Override
    public List<History> findAllHistoryLogs() {
        return this.historyDao.findAllHistoryLogs();
    }
}
