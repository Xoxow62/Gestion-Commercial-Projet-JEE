/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bal.region;

import bal.commande.BalCommande;
import entites.Client;
import entites.Commande;
import entites.Region;
import java.io.Serializable;
import javax.inject.Inject;
import static utilitaire.UtilDate.*;
 
/**
 *
 * @author rsmon
 */
public class BalRegionImpl  implements BalRegion, Serializable{

    @Inject
    private BalCommande balCommande;
    
    
    @Override
    public Float caAnnuel(Region region, int pAnnee) {
        
        Float ca=0f;
        
        for (Client cli : region.getLesClients()) {
        
            for (Commande cmd : cli.getLesCommandes()){
            
              if( dansAnnee(cmd.getDateCom(), pAnnee)&& balCommande.estReglee(cmd)){
                  
                  ca+=balCommande.montantCommandeHT(cmd);
              }
            }
        }
        return ca;
    }

    @Override
    public Float caAnneeEnCours(Region region) {
        return this.caAnnuel(region, anneeCourante());
    }
    
}
