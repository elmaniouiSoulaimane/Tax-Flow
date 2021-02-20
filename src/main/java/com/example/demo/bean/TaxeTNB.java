package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class TaxeTNB {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long annee;
    @ManyToOne
    private Terrain terrain;
    //private Redouvable redouvable;
    //private TauxTNB taux;
    private double montantDeBase;

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

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public double getMontantDeBase() {
        return montantDeBase;
    }

    public void setMontantDeBase(double montantDeBase) {
        this.montantDeBase = montantDeBase;
    }
}
