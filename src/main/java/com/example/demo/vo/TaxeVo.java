package com.example.demo.vo;


public class TaxeVo {

    private Long id;
    private Integer anneeMin;
    private Integer anneeMax;
    private String terrain;
    private String redevable;
    private Double taux;
    private Double montantDeBase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnneeMin() {
        return anneeMin;
    }

    public void setAnneeMin(Integer anneeMin) {
        this.anneeMin = anneeMin;
    }

    public Integer getAnneeMax() {
        return anneeMax;
    }

    public void setAnneeMax(Integer anneeMax) {
        this.anneeMax = anneeMax;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getRedevable() {
        return redevable;
    }

    public void setRedevable(String redevable) {
        this.redevable = redevable;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public Double getMontantDeBase() {
        return montantDeBase;
    }

    public void setMontantDeBase(Double montantDeBase) {
        this.montantDeBase = montantDeBase;
    }
}

