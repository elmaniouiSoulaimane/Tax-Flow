package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Penalite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private TaxeTNB taxeTNB;

    private Double montant;
    private Double majoration;
    private Double fractionDeMoisSupplementaire = 0.0;
    private Double tauxRetardPaiementTaxeTNB;
    private double tauxRetardDeclaration;


    public Double getTauxRetardPaiementTaxeTNB() {
        return tauxRetardPaiementTaxeTNB;
    }

    public void setTauxRetardPaiementTaxeTNB(Double tauxRetardPaiementTaxeTNB) {
        this.tauxRetardPaiementTaxeTNB = tauxRetardPaiementTaxeTNB;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getMajoration() {
        return majoration;
    }

    public void setMajoration(Double majoration) {
        this.majoration = majoration;
    }

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


    public Double getFractionDeMoisSupplementaire() {
        return this.fractionDeMoisSupplementaire;
    }

    public void setFractionDeMoisSupplementaire(Double fractionDeMoisSupplementaire) {
        this.fractionDeMoisSupplementaire = fractionDeMoisSupplementaire;
    }

    public double getTauxRetardDeclaration() {
        return tauxRetardDeclaration;
    }

    public void setTauxRetardDeclaration(double tauxRetardDeclaration) {
        this.tauxRetardDeclaration = tauxRetardDeclaration;
    }

    public void reset(){
        this.setId(null);
        this.setFractionDeMoisSupplementaire(0.0);
        this.setTaxeTNB(null);
    }
}
