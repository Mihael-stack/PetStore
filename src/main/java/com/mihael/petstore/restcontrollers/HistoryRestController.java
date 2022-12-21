package com.mihael.petstore.restcontrollers;

import com.mihael.petstore.representations.HistoryCollectionRepresentation;
import com.mihael.petstore.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryRestController {
    private final HistoryService historyService;

    @Autowired
    public HistoryRestController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/history-log")
    public HistoryCollectionRepresentation findAllHistoryLogs(){
        return new HistoryCollectionRepresentation(this.historyService.findAllHistoryLogs());
    }

}
