package com.example.demo.service;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import com.example.demo.vo.TerrainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;


@Service
public class TerrainService {
    @Autowired
    private TerrainDao terrainDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private TaxeTNBService taxeTNBService;
    @Autowired
    private TauxService tauxService;

    TaxeTNB taxe = new TaxeTNB();

    public Terrain findByReference(String reference) {
        return terrainDao.findByReference(reference);
    }

    @Transactional
    public Integer deleteByReference(String reference) {
        return terrainDao.deleteByReference(reference);
    }

    public List<Terrain> findAll() {
        return terrainDao.findAll();
    }

    @Transactional
    public Terrain update(Terrain nouveauTerrain,Long id){
        return terrainDao.findById(id).map(result ->{
            result.setReference(nouveauTerrain.getReference());
            result.setAdresse(nouveauTerrain.getAdresse());
            result.setSurface(nouveauTerrain.getSurface());
            result.setCategory(nouveauTerrain.getCategory());
            result.setRedevable(nouveauTerrain.getRedevable());
            result.setDateDeclaration(nouveauTerrain.getDateDeclaration());
            result.setDateAchat(nouveauTerrain.getDateAchat());
            result.setDeclaree(nouveauTerrain.isDeclaree());
            return terrainDao.save(result);
        }).orElseGet(() ->{
            nouveauTerrain.setId(id);
            return terrainDao.save(nouveauTerrain);
        });
    }

    public List<Terrain> findByCriterea(TerrainVo terrainVo){
        String query="Select t from Terrain t where 1=1";
        if(terrainVo.getReference()!=null){
            query+=" And t.reference='"+terrainVo.getReference()+"'";
        }
        if(terrainVo.getAdresse()!=null){
            query+=" And t.adresse='"+terrainVo.getAdresse()+"'";
        }
        if(terrainVo.getSurface()!=null){
            query+=" And t.surface='"+terrainVo.getSurface()+"'";
        }
        if(terrainVo.getCategory()!=null){
            query+=" And t.category.libelle='"+terrainVo.getCategory()+"'";
        }
        if(terrainVo.getRedevable()!=null){
            query+=" And t.redevable.ref='"+terrainVo.getRedevable()+"'";
        }
        if(terrainVo.getDateDeclaration()!=null){
            query+=" And t.dateDeclaration='"+terrainVo.getDateDeclaration()+"'";
        }
        if(terrainVo.getDateAchat()!=null){
            query+=" And t.dateAchat='"+terrainVo.getDateAchat()+"'";
        }
        query+=" And t.declaree='"+terrainVo.isDeclaree()+"'";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

    public Map<Integer,Integer> calcStatisticsParAnnee(Date dateMin, Date dateMax){
        Map<Integer,Integer> res= new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateMin);
        Integer anneeMin = cal.get(Calendar.YEAR);
        cal.clear();
        cal.setTime(dateMax);
        Integer anneeMax= cal.get(Calendar.YEAR);
        Integer periodAnne= anneeMax - anneeMin;
        Integer[] annees=new Integer[periodAnne];
        cal.clear();
        Integer k=0;
        for(int i=anneeMin;i<=anneeMax;i++){
            annees[k]=i;
            k++;
        }
        k=0;
        for (int i = anneeMin; i <=anneeMax ; i++) {
            res.put(i, terrainDao.calcStatistics(new Integer(annees[k])));
            k++;
        }
        return res;
    }

    @Transactional
    public Integer save(Terrain terrain) {
        if (findByReference(terrain.getReference()) != null) {
            return -1;
        } else {
            terrainDao.save(terrain);
            return 1;
        }
    }

    public void ajouterTaxesAnnees(){
        LocalDate date = LocalDate.now();
        List<Terrain> allTerrain = this.findAll();
        for (Terrain terrain : allTerrain) {
            if(!terrain.getRedevable().getTypeRedevable().getNomType().equals("Etat") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Collectivité locale") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Habous public") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Terres Guich") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Terre collective") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Agence de logement et d’équipement militaires") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Ligue nationale de lutte contre les maladies cardio-vasculaires") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Fondation Hassan II pour la lutte contre le cancer ") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Fondation Mohammed V pour la solidarité") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Fondation Cheikh Zaid Ibn Soltan") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Fondation Mohammed VI de promotion des oeuvres sociales de l’éducation formation") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Office national des oeuvres universitaires sociales et culturelles") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Université Al Akhawayne d’Ifrane") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Banque islamique de développement") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Banque africaine de développement") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Société financière internationale") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Agence Bayt Mal Al Quods Acharif") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Société nationale d’aménagement collectif") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Société Sala Al-Jadida ") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Agence pour la promotion et le développement économique et social des préfectures et provinces du Nord du Royaume") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Agence pour la promotion et le développement économique et social des Provinces du Sud du Royaume") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Agence pour la promotion et le développement économique et social de la préfecture et des provinces de la région Orientale du Royaume") ||
                            !terrain.getRedevable().getTypeRedevable().getNomType().equals("Agence pour l’aménagement de la Vallée de Bou Regreg") ||
                            !terrain.getRedevable().isPermisRCDGD() ||
                            !terrain.getRedevable().isPromoteurImmobilier()){
                        if(terrain.getSurface() <= 30){
                            LocalDateTime present = LocalDateTime.now();
                            int anneeDatechat = terrain.getDateAchat().getYear()+1900;
                            int condition = anneeDatechat+3;
                            System.out.println("this is condition year :" + condition);
                            if(present.getYear() == condition) {
                                taxeTNBService.save(nouveauTaxeTNB(terrain));
                            }else{
                                int nbrAnneesTaxes = (present.getYear() - anneeDatechat+3);
                                if(nbrAnneesTaxes > 0){
                                    for(int i = anneeDatechat+3;i<=present.getYear();i++){
                                        TaxeTNB taxe = nouveauTaxeTNB(terrain);
                                        taxe.setAnnee((long) i);
                                        taxeTNBService.save(taxe);
                                    }
                                }
                            }
                        }else if(terrain.getSurface() > 30 && terrain.getSurface() <=100){
                            LocalDateTime present = LocalDateTime.now();
                            int anneeDatechat = terrain.getDateAchat().getYear()+1900;
                            int condition = anneeDatechat+5;
                            if(present.getYear() == condition) {
                                taxeTNBService.save(nouveauTaxeTNB(terrain));
                            }else{
                                int nbrAnneesTaxes = (present.getYear() - anneeDatechat+5);
                                if(nbrAnneesTaxes > 0){
                                    for(int i = anneeDatechat+5;i<=present.getYear();i++){
                                        TaxeTNB taxe = nouveauTaxeTNB(terrain);
                                        taxe.setAnnee((long) i);
                                        taxeTNBService.save(taxe);
                                    }
                                }
                            }
                        }else if(terrain.getSurface()>100) {
                            LocalDateTime present = LocalDateTime.now();
                            int anneeDatechat = terrain.getDateAchat().getYear()+1900;
                            int condition = anneeDatechat+7;
                            if(present.getYear() == condition) {
                                taxeTNBService.save(nouveauTaxeTNB(terrain));
                            }else{
                                int nbrAnneesTaxes = (present.getYear() - anneeDatechat+5);
                                if(nbrAnneesTaxes > 0){
                                    for(int i = anneeDatechat+5;i<=present.getYear();i++){
                                        TaxeTNB taxe = nouveauTaxeTNB(terrain);
                                        taxe.setAnnee((long) i);
                                        taxeTNBService.save(taxe);
                                    }
                                }
                            }
                        }
                    }
            }
    }


    public TaxeTNB nouveauTaxeTNB(Terrain terrain){
        LocalDate date = LocalDate.now();

        taxe.reset();

        Long annee = (long) date.getYear();

        taxe.setAnnee(annee);
        taxe.setTerrain(terrain);
        taxe.setRedevable(terrain.getRedevable());
        taxe.setTaux(tauxService.findByCategoryId(terrain.getCategory().getId()));
        taxe.setMontantDeBase(taxe.getTaux().getPrix() * terrain.getSurface());
        taxe.setMontantDeTaxeTotale(taxe.getMontantDeBase());
        taxe.setStatusPaiement(false);
        System.out.println("Nouveau TaxeTNB ID est : "+taxe.getTerrain().getReference());
        return taxe;
    }

}
