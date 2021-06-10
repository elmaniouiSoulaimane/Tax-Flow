package com.example.demo.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Penalite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private TaxeTNB taxeTNB;
    private Double tauxRetardDeclarationTerrain;
    private Double tauxRetardPaiementTaxeTNB;
    private Double montant;
    private Double majoration;
    private Double fractionDeMoisSupplementaire;
    private Double tauxPenaliteTotale;

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

    public Double getTauxRetardDeclarationTerrain() {
        return tauxRetardDeclarationTerrain;
    }

    public void setTauxRetardDeclarationTerrain(Double tauxRetardDeclarationTerrain) {
        this.tauxRetardDeclarationTerrain = tauxRetardDeclarationTerrain;
    }

    public Double getTauxRetardPaiementTaxeTNB() {
        return tauxRetardPaiementTaxeTNB;
    }

    public void setTauxRetardPaiementTaxeTNB(Double tauxRetardPaiementTaxeTNB) {
        this.tauxRetardPaiementTaxeTNB = tauxRetardPaiementTaxeTNB;
    }

    public Double getTauxPenaliteTotale() {
        return tauxPenaliteTotale;
    }

    public void setTauxPenaliteTotale(Double tauxPenaliteTotale) {
        this.tauxPenaliteTotale = tauxPenaliteTotale;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant() {
        this.montant = this.taxeTNB.getMontantDeBase()* (10/100);
    }

    public Double getMajoration() {
        return majoration;
    }

    public void setMajoration() {
        this.majoration = this.taxeTNB.getMontantDeBase() * (5/100);;
    }

    public Double getFractionDeMoisSupplementaire() {
        return fractionDeMoisSupplementaire;
    }

    public void setFractionDeMoisSupplementaire(Double fractionDeMoisSupplementaire) {
        this.fractionDeMoisSupplementaire = fractionDeMoisSupplementaire;
    }
}
