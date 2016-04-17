package bal.client;
import bal.commande.BalCommande;
import dao.commande.DaoCommande;
import dto.commande.ResumeCommande;
import entites.Client;
import entites.Commande;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton 
@Alternative
public class BalClientMock  implements BalClient{
    
    @Inject BalCommande  balCommande;
    @Inject DaoCommande  daoCommande;
    
    @Override
    public Float                 caAnnuel(Client pClient, int pAnnee) {
        
        Float ca=0f;
        for (Commande cmd : daoCommande.getLesCommandesduClient(pClient, pAnnee)){
           
                ca+=balCommande.montantCommandeHT(cmd); 
        }
        return 1000F;
    }

    @Override
    public Float                 caAnnuel(Client pClient, int pAnnee, int pMois) {
       
        Float ca=0f;
        for (Commande cmd : daoCommande.getLesCommandesduClient(pClient, pAnnee, pMois)){
            
                  ca+=balCommande.montantCommandeHT(cmd);
        }
        return ca;
    } 
    
    @Override
    public List<ResumeCommande>  getResumesCommandeClient(Client client) {
       
        return getResumesCommande(daoCommande.getLesCommandesduClient(client));
    }  
    
    private List<ResumeCommande> getResumesCommande(List<Commande> desCommandes){
    
     List<ResumeCommande> lc=new LinkedList<ResumeCommande>();
     
     for (Commande c: desCommandes ){ lc.add(getResumeCommande(c));}
     
     return lc;
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
    public Float caAnneeEnCours(Client pClient) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Float caMoisEnCours(Client pClient) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Float resteARegler(Client pClient) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
               
}
