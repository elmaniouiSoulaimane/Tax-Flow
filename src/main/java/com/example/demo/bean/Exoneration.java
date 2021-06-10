package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Exoneration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private TaxeTNB taxeTNB;
    private Double montantDeReduction;

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

    public Double getMontantDeReduction() {
        return montantDeReduction;
    }

    public void setMontantDeReduction(Double montantDeReduction) {
        this.montantDeReduction = montantDeReduction;
    }
}
