package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Taux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prix;
    @ManyToOne
    private Category category;
    private Long surfaceMin;
    private Long srfaceMax;
    //surface min et surface max
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getSurfaceMin() {
        return surfaceMin;
    }

    public void setSurfaceMin(Long surfaceMin) {
        this.surfaceMin = surfaceMin;
    }

    public Long getSrfaceMax() {
        return srfaceMax;
    }

    public void setSrfaceMax(Long srfaceMax) {
        this.srfaceMax = srfaceMax;
    }
}
