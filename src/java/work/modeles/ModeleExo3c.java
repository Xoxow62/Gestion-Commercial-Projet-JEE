
package work.modeles;

import entites.Client;
import entites.Commande;

public interface ModeleExo3c {

    Client getLeClient(Long pNumcli);

    Float caAnneeEnCours(Client pClient);
    
    Float montantCommandeHT(Commande pCommande);

    Float montantCommandeTTC(Commande pCommande);

   
    
}
