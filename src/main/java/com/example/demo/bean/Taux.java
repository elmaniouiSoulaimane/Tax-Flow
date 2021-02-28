package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Taux {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double prix;
    @ManyToOne
    private Category category;

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
}
