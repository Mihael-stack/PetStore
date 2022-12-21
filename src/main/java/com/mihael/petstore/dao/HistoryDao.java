package com.mihael.petstore.dao;

import com.mihael.petstore.entity.History;

import java.util.List;

public interface HistoryDao {
    void saveHistory(History history);
    List<History> findAllHistoryLogs();
}
