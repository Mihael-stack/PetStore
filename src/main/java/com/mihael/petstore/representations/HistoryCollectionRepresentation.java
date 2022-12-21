package com.mihael.petstore.representations;

import com.mihael.petstore.entity.History;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class HistoryCollectionRepresentation {
    private List<History> list;

    public HistoryCollectionRepresentation() {
    }

    public HistoryCollectionRepresentation(List<History> list) {
        this.list = list;
    }

    public List<History> getList() {
        return list;
    }

    public void setList(List<History> list) {
        this.list = list;
    }
}
