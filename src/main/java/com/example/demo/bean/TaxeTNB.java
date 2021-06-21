package com.example.demo.bean;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

@Entity
public class TaxeTNB {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long annee;
    @ManyToOne
    private Terrain terrain;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Taux taux;
    @OneToOne
    private Penalite penalite;
    @OneToOne
    private Exoneration exoneration;
    private double montantDeBase;
    private double montantDeTaxeTotale;
    private boolean statusPaiement;

    public TaxeTNB() {
    }

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

    public Penalite getPenalite() {
        return penalite;
    }

    public void calculFractionDeMoisSupplementaireParAnnee(LocalDateTime now){
        int month = now.getMonthValue();

        for (int currentMonth = month; currentMonth <= 12; currentMonth++) {
            if(!this.statusPaiement){
                Double fractionDeMoisSupplementaire = (this.montantDeBase * (0.50/100)) + this.penalite.getFractionDeMoisSupplementaire();
                this.penalite.setFractionDeMoisSupplementaire(fractionDeMoisSupplementaire);
            }
        }

    }
    public Penalite setPenalite() {
        if(!this.isStatusPaiement()){
            LocalDateTime now = LocalDateTime.now();
            int anneeCourant = now.getYear();
            int anneeTaxe = Math.toIntExact(this.annee);
            if(anneeCourant==anneeTaxe){
                Month moisCourant = now.getMonth();
                if(moisCourant==Month.MARCH){
                    this.penalite.setMajoration();
                    this.penalite.setMontant();
                    this.penalite.setFractionDeMoisSupplementaire(0.0);
                }
                if(moisCourant!=Month.JANUARY || moisCourant!=Month.FEBRUARY || moisCourant!=Month.MARCH){
                    Double fractionDeMoisSupplementaire = (this.montantDeBase * (0.50/100)) + this.penalite.getFractionDeMoisSupplementaire();
                    this.penalite.setFractionDeMoisSupplementaire(fractionDeMoisSupplementaire);
                }
            }else{
                calculFractionDeMoisSupplementaireParAnnee(now);
            }
        }
        Double fractionDeMoisSupplementaire = (this.montantDeBase * (0.50/100)) + this.penalite.getFractionDeMoisSupplementaire();
        this.penalite.setFractionDeMoisSupplementaire(fractionDeMoisSupplementaire);
        return this.getPenalite();
    }

    public Exoneration getExoneration() {
        return exoneration;
    }
    public double getMontantDeBase() {
        return montantDeBase;
    }

    public void setMontantDeBase(double montantDeBase) {
        this.montantDeBase = montantDeBase;
    }

    public double getMontantDeTaxeTotale() {
        return montantDeTaxeTotale;
    }

    public void setMontantDeTaxeTotale(double montantDeTaxeTotale) {
        this.montantDeTaxeTotale = montantDeTaxeTotale;
    }

    public boolean isStatusPaiement() {
        return statusPaiement;
    }

    public void setStatusPaiement(boolean statusPaiement) {
        this.statusPaiement = statusPaiement;
    }

    public void setExoneration() {
        this.exoneration = exoneration;
    }
}
