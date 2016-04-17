
package web.controleurs;


import bal.client.BalClient;
import bal.tranchetarifaire.BalTrancheTarifaire;
import dao.commande.DaoCommande;
import entites.Commande;
import entites.LigneDeCommande;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@SessionScoped
public class ControleurNumCommande implements Serializable {
    @Inject
    private DaoCommande daoCommande;
    @Inject
    private BalClient balClient;
    @Inject
    private BalTrancheTarifaire balTrancheTarifaire;
private Long numCommande;
private Commande commande;
private Float caClientAnneeEnCours= 0f;


public void recherche(){
    if(numCommande!=null){
        commande=daoCommande.getCommande(numCommande);
        
        if(commande!=null){
        this.caClientAnneeEnCours = this.balClient.caAnneeEnCours(commande.getLeClient());
        }        
    }
}

public Float prixU (LigneDeCommande ldc) {
    
return this.balTrancheTarifaire.getPrixUnitaire(ldc);
}

public Float montantHT (LigneDeCommande ldc){

   return ldc.getQteCom()*prixU(ldc);   
}

public Float montantTTC (LigneDeCommande ldc){

    return montantHT(ldc)*(1+ldc.getLeProduit().getLaCategorie().getTauxTVA()) ;    
}

//<editor-fold defaultstate="collapsed" desc="Getter&setters">
public Long getNumCommande() {
    return numCommande;
}

public void setNumCommande(Long numCommande) {
    this.numCommande = numCommande;
}

public Commande getCommande() {
    return commande;
}

public void setCommande(Commande commande) {
    this.commande = commande;
}
    
        public DaoCommande getDaoCommande() {
        return daoCommande;
    }

    public void setDaoCommande(DaoCommande daoCommande) {
        this.daoCommande = daoCommande;
    }

    public BalClient getBalClient() {
        return balClient;
    }

    public void setBalClient(BalClient balClient) {
        this.balClient = balClient;
    }

    public Float getCaClientAnneeEnCours() {
        return caClientAnneeEnCours;
    }

    public void setCaClientAnneeEnCours(Float caClientAnneeEnCours) {
        this.caClientAnneeEnCours = caClientAnneeEnCours;
    }
    
    
    
}
//</editor-fold>


   
  
    
    

