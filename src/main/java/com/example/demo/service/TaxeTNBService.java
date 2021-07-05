package com.example.demo.service;

import com.example.demo.bean.Penalite;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.dao.TaxeTNBDao;
import com.example.demo.vo.TaxeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaxeTNBService {
    @Autowired
    public TaxeTNBDao taxeTNBDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PenaliteService penaliteService;
    LocalDateTime now = LocalDateTime.now();
    Month moisCourant = now.getMonth();
    Penalite penalite = new Penalite();


    /*public Result save(TaxeTNB taxeTNB) {
        return save(taxeTNB,false);
    }*/

    /*public Result simuler(TaxeTNB taxeTNB) {
        return save(taxeTNB,true);
    }*/

    /*private Result save(TaxeTNB taxeTNB,boolean simuler) {
        Result result= new Result("taxeTNBInput",taxeTNB);
        Terrain terrain = terrainService.findByReference(taxeTNB.getTerrain().getReference());
        Redevable redevable= redevableService.findByNomCommmercial(terrain.getRedevable().getNomCommercial());
        if (findByTerrainReferenceAndAnnee(taxeTNB.getTerrain().getReference(), taxeTNB.getAnnee())!=null) {
            result.addError(-1,"Taxe deja paye");
        } if (terrain==null){
            result.addError(-2,"Terrain non existant");
        } if (redevable==null){
            result.addError(-3,"Redevable non existant");
        } if(terrain.getCategory()==null || terrain.getCategory().getId()==null){
            result.addError(-4,"Categorie non existant");
        }
        Taux taux = tauxService.findByCategoryId(terrain.getCategory().getId());

        if (taux == null){
            result.addError(-5,"Taux non existant");
        }
        if(result.hasNoError()) {
            taxeTNB.setRedevable(redevable);
            taxeTNB.setTerrain(terrain);
            taxeTNB.setTaux(taux);
            taxeTNB.setMontantDeBase(taxeTNB.getTaux().getPrix() * terrain.getSurface());
            if (simuler == false)
                taxeTNBDao.save(taxeTNB);
            result.addInfo(1,"Taxe Saved");
        }
        return result;
    }*/

    @Transactional
    public Integer save(TaxeTNB taxeTNB){
        if(findByTerrainReferenceAndAnnee(taxeTNB.getTerrain().getReference(),taxeTNB.getAnnee()) != null){
            return -1;
        }else{
            taxeTNBDao.save(taxeTNB);
            return 1;
        }
    }

    public List<TaxeTNB> findByTerrainId(Long id) {
        return taxeTNBDao.findByTerrainId(id);
    }
    public TaxeTNB findByAnnee(Long annee){ return taxeTNBDao.findByAnnee(annee);}

    public List<TaxeTNB> findAll() {
        return taxeTNBDao.findAll();
    }


    public TaxeTNB findByTerrainReferenceAndAnnee(String ref, Long annee) {
        return taxeTNBDao.findByTerrainReferenceAndAnnee(ref, annee);
    }


    public List findByCriterea(TaxeVo taxeVo){
        String query="Select t from TaxeTNB t where 1=1";
        if(taxeVo.getRedevable()!=null){
            query+=" And t.redevable.ref='"+taxeVo.getRedevable()+"'";
        }
        if(taxeVo.getTerrain()!=null){
            query+=" And t.terrain.reference='"+taxeVo.getTerrain()+"'";
        }
        if(taxeVo.getAnneeMin()!=null){
            query+=" And t.annee>'"+taxeVo.getAnneeMin()+"'";
        }
        if(taxeVo.getAnneeMax()!=null){
            query+=" And t.annee<='"+taxeVo.getAnneeMax()+"'";
        }
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

    public Map<Integer, Double> calcStatistics(Integer anneeMin, Integer anneeMax) {
        Map<Integer, Double> res= new HashMap<>();
        for (int i = anneeMin; i <=anneeMax ; i++) {
            res.put(i, taxeTNBDao.calcStatistics(new Long(i+"")));
        }
        return res;
    }

    public void calculFractionDeMoisSupplementaireParAnnee(TaxeTNB taxeTNB, Penalite penalite){
        int month = now.getMonthValue();
        for (int currentMonth = month; currentMonth <= 12; currentMonth++) {
            if(!taxeTNB.isStatusPaiement()){
                Double fractionDeMoisSupplementaire = (taxeTNB.getMontantDeBase() * (0.50/100)) + penalite.getFractionDeMoisSupplementaire();
                penalite.setFractionDeMoisSupplementaire(fractionDeMoisSupplementaire);
            }
        }
    }



    public void ajouterPenalites(){
        List<TaxeTNB> allTaxes = this.findAll();
        for(TaxeTNB taxeTNB : allTaxes){
            if(!taxeTNB.isStatusPaiement()){
                int anneeCourant = now.getYear();
                int anneeTaxe = Math.toIntExact(taxeTNB.getAnnee());
                if(anneeCourant==anneeTaxe){
                    Penalite nouveauPenalite = nouveauPenalite(taxeTNB);
                   int result = penaliteService.save(nouveauPenalite);
                   System.out.println(result);
                   if(result == 1){
                       double montantDeTaxeTotal = taxeTNB.getMontantDeBase() + nouveauPenalite.getMontant() + nouveauPenalite.getTauxRetardDeclaration();
                       taxeTNB.setMontantDeTaxeTotale(montantDeTaxeTotal);
                       this.update(taxeTNB, taxeTNB.getId());
                   }
                }else if(anneeTaxe<=anneeCourant){
                    calculFractionDeMoisSupplementaireParAnnee(taxeTNB,nouveauPenalite(taxeTNB));
                }
            }
        }
    }

    public Penalite nouveauPenalite(TaxeTNB taxeTNB){
        penalite.reset();
        penalite.setTaxeTNB(taxeTNB);
        double majoration = (( taxeTNB.getMontantDeBase() * 5)/100);
        penalite.setMajoration(majoration);
        double montantDeBase = (( taxeTNB.getMontantDeBase() * 10)/100);
        penalite.setMontant(montantDeBase);
        if(moisCourant!=Month.JANUARY && moisCourant!=Month.FEBRUARY && moisCourant!=Month.MARCH){
            Penalite p = penaliteService.findByTaxeTNBTerrainReference(taxeTNB.getTerrain().getReference());
            if(p != null){ //Confirmation du creation d'une ancien penalite pour calculer la fraction
                penalite.setFractionDeMoisSupplementaire((taxeTNB.getMontantDeBase() * (0.50/100) + p.getFractionDeMoisSupplementaire()));
            }else{
                penalite.setFractionDeMoisSupplementaire((taxeTNB.getMontantDeBase() * (0.50/100)));
            }
        }
        penalite.setTauxRetardPaiementTaxeTNB((penalite.getMontant() + penalite.getMajoration() + penalite.getFractionDeMoisSupplementaire()));

        if(taxeTNB.getTerrain().getDateAchat().getYear()!= taxeTNB.getTerrain().getDateDeclaration().getYear()){
            int differenceAnnees =  taxeTNB.getTerrain().getDateDeclaration().getYear() - taxeTNB.getTerrain().getDateAchat().getYear();
            penalite.setTauxRetardDeclaration(differenceAnnees * penalite.getMontant());
        }else{
            penalite.setTauxRetardDeclaration(0.0);
        }
        return penalite;
    }

    public TaxeTNB update(TaxeTNB nouveautaxeTNB, Long id){
        return taxeTNBDao.findById(id).map(result ->{
            result.setAnnee(nouveautaxeTNB.getAnnee());
            result.setTerrain(nouveautaxeTNB.getTerrain());
            result.setRedevable(nouveautaxeTNB.getRedevable());
            result.setTaux(nouveautaxeTNB.getTaux());
            result.setMontantDeBase(nouveautaxeTNB.getMontantDeBase());
            result.setMontantDeTaxeTotale(nouveautaxeTNB.getMontantDeTaxeTotale());
            result.setStatusPaiement(nouveautaxeTNB.isStatusPaiement());
            return taxeTNBDao.save(result);
        }).orElseGet(()->{
            nouveautaxeTNB.setId(id);
           return taxeTNBDao.save(nouveautaxeTNB);
        });
    }
}
