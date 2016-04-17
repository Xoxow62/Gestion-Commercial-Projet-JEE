
package bal;

import bal.commande.BalCommande;
import dao.commande.DaoCommande;
import entites.Commande;
import javax.inject.Inject;
import static utilitaire.UtilDate.*;

public class BalImpl implements Bal{
  
    @Inject DaoCommande daoCommande; 
    @Inject BalCommande balCommande;
    
    @Override
    public Float caAnnuel(int pAnnee) {
        
        Float ca=0f;
        for (Commande cmd : daoCommande.getToutesLesCommandes()){
           
            if( annee(cmd.getDateCom())== pAnnee && balCommande.estReglee(cmd)){
                  ca+=balCommande.montantCommandeHT(cmd);
            }
        }
        return ca;
    }

    @Override
    public Float caAnnuel(int pAnnee, int pMois) {
        
        Float ca=0f;
        
        for (Commande cmd : daoCommande.getToutesLesCommandes()){
           
            if( dansAnneeEtMois(cmd.getDateCom(),pAnnee,pMois) && balCommande.estReglee(cmd)){
                  ca+=balCommande.montantCommandeHT(cmd);
            }
        }
        return ca;
    }
}
