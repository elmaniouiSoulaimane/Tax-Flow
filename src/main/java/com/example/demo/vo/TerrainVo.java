package com.example.demo.vo;

import java.util.Date;

public class TerrainVo {
    private Long id;
    private String reference;
    private String adresse;
    private Double surface;
    private String category;
    private String redevable;
    private Date dateDeclaration;
    private Date dateAchat;
    private boolean declaree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRedevable() {
        return redevable;
    }

    public void setRedevable(String redevable) {
        this.redevable = redevable;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(Date dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public boolean isDeclaree() {
        return declaree;
    }

    public void setDeclaree(boolean declaree) {
        this.declaree = declaree;
    }
}
