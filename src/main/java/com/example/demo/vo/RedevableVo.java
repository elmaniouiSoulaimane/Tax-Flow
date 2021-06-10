package com.example.demo.vo;

public class RedevableVo {
    private Long id;
    private String ref;
    private String adresse;
    private String nomCommercial;
    private String typeRedevable;

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

    public String getTypeRedevable() {
        return typeRedevable;
    }

    public void setTypeRedevable(String typeRedevable) {
        this.typeRedevable = typeRedevable;
    }
}
