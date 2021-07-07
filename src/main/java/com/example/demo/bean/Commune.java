package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String nomComunne;
    @ManyToOne
    private  Ville ville;
    private  String numTel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomComunne() {
        return nomComunne;
    }

    public void setNomComunne(String nomComunne) {
        this.nomComunne = nomComunne;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}
