package com.example.demo.bean;



import javax.persistence.*;

@Entity
public class TaxeTNB {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long annee;
    @ManyToOne
    private Terrain terrain;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Taux taux;
    private double montantDeBase;
    private double montantDeTaxeTotale;
    private boolean statusPaiement;

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

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }


    public double getMontantDeBase() {
        return montantDeBase;
    }


    public double getMontantDeTaxeTotale() {
        return montantDeTaxeTotale;
    }

    public void setMontantDeTaxeTotale(double montantTaxeTotale) {
        this.montantDeTaxeTotale = montantTaxeTotale;
    }

    public boolean isStatusPaiement() {
        return statusPaiement;
    }

    public void setStatusPaiement(boolean statusPaiement) {
        this.statusPaiement = statusPaiement;
    }

    public void setMontantDeBase(double montantDeBase) {
        this.montantDeBase = montantDeBase;
    }

    public void reset(){
        this.setStatusPaiement(false);
        this.setTaux(null);
        this.setMontantDeTaxeTotale(0);
        this.setRedevable(null);
        this.setTerrain(null);
        this.setAnnee(null);
        this.setId(null);
        this.setMontantDeBase(0);
    }


}
