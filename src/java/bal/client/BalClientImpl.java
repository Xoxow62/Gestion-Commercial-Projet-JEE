package bal.client;
import bal.commande.BalCommande;
import dao.commande.DaoCommande;
import dto.commande.ResumeCommande;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import static utilitaire.UtilDate.*;

@Singleton 

public class BalClientImpl  implements BalClient, Serializable{
    
    @Inject BalCommande  balCommande;
    @Inject DaoCommande  daoCommande;
    
    @Override
    public Float                 caAnnuel(Client pClient, int pAnnee) {
        
        Float ca=0f;
        for (Commande cmd : daoCommande.getLesCommandesduClient(pClient, pAnnee)){
               
               if(cmd.getEtatCom().equalsIgnoreCase("R") && 
                   dansAnnee(cmd.getDateCom(), pAnnee)
                 )
               {
                   ca+=balCommande.montantCommandeHT(cmd);
               } 
        }
        return ca;
    }

    @Override
    public Float                 caAnnuel(Client pClient, int pAnnee, int pMois) {
       
        Float ca=0f;
        for (Commande cmd : daoCommande.getLesCommandesduClient(pClient, pAnnee, pMois)){
               
               if( cmd.getEtatCom().equalsIgnoreCase("R")&&
                   dansAnneeEtMois(cmd.getDateCom(), pAnnee, pMois)
                 )
               {
                       
                  ca+=balCommande.montantCommandeHT(cmd);
               }
        }
        return ca;
    } 
    
    @Override
    public Float caAnneeEnCours(Client pClient) {
        return this.caAnnuel(pClient, anneeCourante());
    }

    @Override
    public Float caMoisEnCours(Client pClient) {
        return this.caAnnuel(pClient, anneeCourante(), moisCourant());
    } 
    
    private List<ResumeCommande> getResumesCommande(List<Commande> desCommandes){
    
     List<ResumeCommande> lc=new LinkedList<ResumeCommande>();
     
     for (Commande c: desCommandes ){ lc.add(getResumeCommande(c));}
     
     return lc;
    }
    
    @Override
    public List<ResumeCommande>  getResumesCommandeClient(Client client) {
       
        return getResumesCommande(daoCommande.getLesCommandesduClient(client));
    } 
    
    @Override
    public List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee) {
       
        return getResumesCommande(daoCommande.getLesCommandesduClient(client, pAnnee));
    }

    @Override
    public List<ResumeCommande>  getResumesCommandeClient(Client client, int pAnnee, int pMois) {
        
        return getResumesCommande(daoCommande.getLesCommandesduClient(client, pAnnee,pMois));
        
    }
     
    @Override
    public ResumeCommande        getResumeCommande(Commande c){
    
       return new ResumeCommande(
                   
                 c.getNumCom(),
                 c.getDateCom(),
                 c.getEtatCom(),
                 balCommande.montantCommandeHT(c),
                 balCommande.montantCommandeTTC(c)  
                   
             ) ;
    }

    @Override
    public Float resteARegler(Client pClient) {
       
       Float valeur=0F;
       
       for ( Commande cmd : pClient.getLesCommandes()) {
       
         if (! balCommande.estReglee(cmd) ){
             valeur+= balCommande.montantCommandeTTC(cmd);
         }
       }
       return valeur;
       
    }

    
               
}
