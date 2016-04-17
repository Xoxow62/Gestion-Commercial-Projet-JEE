
package bal.commande;

import dao.tva.DaoTva;
import entites.Commande;
import entites.LigneDeCommande;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class BalCommandeImpl implements BalCommande,Serializable{
       
    @Inject DaoTva      daoTva;
    
    @Override
    public Float montantCommandeHT(Commande pCommande) {
        
        Float montant=0F;
        for(LigneDeCommande lgdc: pCommande.getLesLignesDeCommande()){
        
           montant+=lgdc.getQteCom()*lgdc.getLeProduit().getPrixProd();
        }
        
        return montant;
    } 
    
    @Override
    public Float montantCommandeTTC(Commande pCommande) {
         
        return montantCommandeHT(pCommande)*(1+daoTva.getTauxTVA());
    }

    @Override
    public boolean estReglee(Commande pCommande) {
        return pCommande.getEtatCom().equalsIgnoreCase("R");
    }
}
