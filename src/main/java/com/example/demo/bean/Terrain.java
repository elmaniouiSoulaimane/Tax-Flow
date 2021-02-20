package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Terrain {
    @Id @GeneratedValue
    private Long id;
    private String reference;
    private String adresse;
    private Float surface;
    private String categorie;


    //GETTERs
    public long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getAdresse() {
        return adresse;
    }

    public float getSurface() {
        return surface;
    }

    public String getCategorie() {
        return categorie;
    }

    //SETTERS

    public void setId(long id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
