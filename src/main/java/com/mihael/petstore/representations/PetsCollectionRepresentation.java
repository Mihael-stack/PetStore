package com.mihael.petstore.representations;

import com.mihael.petstore.entity.Pets;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pets")
public class PetsCollectionRepresentation {
    private List<Pets> pets;

    public PetsCollectionRepresentation() {
    }
    public PetsCollectionRepresentation(List<Pets> pets) {
        this.pets = pets;
    }

    public List<Pets> getPets() {
        return pets;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }
}
