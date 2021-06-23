package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Penalite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private TaxeTNB taxeTNB;
    private Double tauxRetardPaiementTaxeTNB;
    private Double montant;
    private Double majoration;
    private Double fractionDeMoisSupplementaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaxeTNB getTaxeTNB() {
        return taxeTNB;
    }

    public void setTaxeTNB(TaxeTNB taxeTNB) {
        this.taxeTNB = taxeTNB;
    }
    public Double getTauxRetardPaiementTaxeTNB() {
        return tauxRetardPaiementTaxeTNB;
    }

    public Double getMontant() {
        return montant;
    }

    public Double getMajoration() {
        return majoration;
    }

    public Double getFractionDeMoisSupplementaire() {
        return fractionDeMoisSupplementaire;
    }

    public void setFractionDeMoisSupplementaire(Double fractionDeMoisSupplementaire) {
        this.fractionDeMoisSupplementaire = fractionDeMoisSupplementaire;
    }

    public void setTauxRetardPaiementTaxeTNB() {
        this.tauxRetardPaiementTaxeTNB = this.getMontant() + this.getMajoration() + this.getFractionDeMoisSupplementaire();
    }

    public void setMontant() {
        this.montant = this.taxeTNB.getMontantDeBase()* (10/100);
    }

    public void setMajoration() {
        this.majoration = this.taxeTNB.getMontantDeBase() * (5/100);
    }

}
