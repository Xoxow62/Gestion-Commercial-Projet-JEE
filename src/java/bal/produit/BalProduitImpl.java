
package bal.produit;
import entites.Commande;
import entites.LigneDeCommande;
import entites.Produit;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Singleton;
import static utilitaire.UtilDate.*;

@Singleton
public class BalProduitImpl  implements BalProduit, Serializable{
    
    @Override
    public Float caAnnuelProduit(Produit pProduit, int pAnnee) {
        
        Float ca=0F;
        
        for (LigneDeCommande lgdc: pProduit.getLesLignesDeCommande()){
        
          Commande cmd     = lgdc.getLaCommande();
          Date     dateCmd = cmd.getDateCom();
          String   etatCmd = cmd.getEtatCom();
          
          if( annee(dateCmd)==pAnnee && etatCmd.equalsIgnoreCase("R") ){
           
              ca+=lgdc.getQteCom()*lgdc.getLeProduit().getPrixProd();             
          }            
        }
        return ca;
    }
    
    @Override
    public Float caAnnuelProduit(Produit pProduit, int pAnnee, int pMois) {
        
        Float ca=0F;
        
        for (LigneDeCommande lgdc: pProduit.getLesLignesDeCommande()){
        
          Commande cmd     = lgdc.getLaCommande();
          Date     dateCmd = cmd.getDateCom();
          String   etatCmd = cmd.getEtatCom();
          
          if( dansAnneeEtMois(dateCmd, pAnnee, pMois) 
              &&  
              etatCmd.equalsIgnoreCase("R")
            )
          {              
            ca+=lgdc.getQteCom()*lgdc.getLeProduit().getPrixProd();
          }
               
        }
        return ca;
    }
    
}
