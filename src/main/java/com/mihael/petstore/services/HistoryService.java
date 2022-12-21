package com.mihael.petstore.services;

import com.mihael.petstore.entity.History;

import java.util.List;

public interface HistoryService {
    List<History> findAllHistoryLogs();
}
