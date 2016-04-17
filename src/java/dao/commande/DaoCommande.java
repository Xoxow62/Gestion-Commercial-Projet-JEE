package dao.commande;

import entites.Client;
import entites.Commande;
import java.util.List;

public interface DaoCommande {

    Commande       getCommande(Long pNumCom);
    List<Commande> getToutesLesCommandes();
    
    List<Commande> getLesCommandesduClient(Client client);
    List<Commande> getLesCommandesduClient(Client client, int pAnnee);
    List<Commande> getLesCommandesduClient(Client client, int pAnnee, int pMois);
        
}
