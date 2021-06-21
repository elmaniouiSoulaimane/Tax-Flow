package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Redevable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String adresse;
    private String nomCommercial;
    @ManyToOne
    private TypeRedevable typeRedevable;
    private boolean permisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures;
    private boolean promoteurImmobilier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public TypeRedevable getTypeRedevable() {
        return typeRedevable;
    }

    public void setTypeRedevable(TypeRedevable typeRedevable) {
        this.typeRedevable = typeRedevable;
    }

    public boolean isPermisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures() {
        return permisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures;
    }

    public void setPermisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures(boolean permisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures) {
        this.permisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures = permisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures;
    }

    public boolean isPromoteurImmobilier() {
        return promoteurImmobilier;
    }

    public void setPromoteurImmobilier(boolean promoteurImmobilier) {
        this.promoteurImmobilier = promoteurImmobilier;
    }
}
