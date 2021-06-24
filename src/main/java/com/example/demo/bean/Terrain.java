package com.example.demo.bean;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Terrain {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String adresse;
    private double surface;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Redevable redevable;
    private Date dateDeclaration;
    private Date dateAchat;
    private boolean declaree;
    @ManyToOne
    private TaxeTNB taxeTNB;
    @OneToOne
    private Taux taux;

    public void setDeclaree(boolean declaree) {
        this.declaree = declaree;
    }

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

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
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

    public TaxeTNB getTaxeTNB() {
        return taxeTNB;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }

    public void setTaxeTNB(){
        if(!this.redevable.getTypeRedevable().getNomType().equals("Etat") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Collectivité locale") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Habous public") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Terres Guich") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Terre collective") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Agence de logement et d’équipement militaires") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Ligue nationale de lutte contre les maladies cardio-vasculaires") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Fondation Hassan II pour la lutte contre le cancer ") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Fondation Mohammed V pour la solidarité") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Fondation Cheikh Zaid Ibn Soltan") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Fondation Mohammed VI de promotion des oeuvres sociales de l’éducation formation") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Office national des oeuvres universitaires sociales et culturelles") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Université Al Akhawayne d’Ifrane") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Banque islamique de développement") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Banque africaine de développement") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Société financière internationale") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Agence Bayt Mal Al Quods Acharif") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Société nationale d’aménagement collectif") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Société Sala Al-Jadida ") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Agence pour la promotion et le développement économique et social des préfectures et provinces du Nord du Royaume") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Agence pour la promotion et le développement économique et social des Provinces du Sud du Royaume") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Agence pour la promotion et le développement économique et social de la préfecture et des provinces de la région Orientale du Royaume") ||
                !this.redevable.getTypeRedevable().getNomType().equals("Agence pour l’aménagement de la Vallée de Bou Regreg") ||
                this.getRedevable().isPermisDeRechercheOuDuneConcessionDexploitationDesGisementsDhydrocarbures() ||
                this.getRedevable().isPromoteurImmobilier()){
            if(this.getSurface() <= 30){
                LocalDateTime present = LocalDateTime.now();
                int condition = (int) present.getYear()+3;
                int anneeDachat = this.getDateAchat().getYear();
                if(anneeDachat == condition) {
                    this.setTaxeTNB();
                }
            }else if(this.getSurface() > 30 && this.getSurface() >=100){
                LocalDateTime present = LocalDateTime.now();
                int condition = (int) present.getYear()+5;
                int anneeDachat = this.getDateAchat().getYear();
                if(anneeDachat == condition) {
                    this.setTaxeTNB();
                }
            }else if(this.getSurface()>100) {
                LocalDateTime present = LocalDateTime.now();
                int condition = (int) present.getYear()+7;
                int anneeDachat = this.getDateAchat().getYear();
                if(anneeDachat == condition) {
                    this.setTaxeTNB();
                }
            }else{
                this.setTaxeTNB();
            }
        }
    }

    public void setDeclaree(boolean declaree) {
        this.declaree = declaree;
    }
}
