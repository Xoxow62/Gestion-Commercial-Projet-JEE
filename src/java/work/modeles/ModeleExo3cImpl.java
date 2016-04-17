
package work.modeles;

import bal.client.BalClient;
import bal.commande.BalCommande;
import dao.client.DaoClient;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ModeleExo3cImpl implements ModeleExo3c, Serializable {
   
    @Inject private DaoClient    daoClient;
    @Inject private BalClient    balClient;
    @Inject private BalCommande  balCommande;
  
    @Override
    public Client getLeClient(Long pNumcli) {
        return daoClient.getLeClient(pNumcli);
    }

    @Override
    public Float caAnneeEnCours(Client pClient) {
        return balClient.caAnneeEnCours(pClient);
    }
    

    @Override
    public Float montantCommandeHT(Commande pCommande) {
        return balCommande.montantCommandeHT(pCommande);
    }

    @Override
    public Float montantCommandeTTC(Commande pCommande) {
        return balCommande.montantCommandeTTC(pCommande);
    }
 
}
