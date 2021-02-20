package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaxeTNB {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long annee;
    private String terrain;
    private float redouvable;
    private float taux;
    private float montantDeBase;


    //GETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public float getRedouvable() {
        return redouvable;
    }


    //SETTERS
    public void setRedouvable(float redouvable) {
        this.redouvable = redouvable;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public float getMontantDeBase() {
        return montantDeBase;
    }

    public void setMontantDeBase(float montantDeBase) {
        this.montantDeBase = montantDeBase;
    }
}
