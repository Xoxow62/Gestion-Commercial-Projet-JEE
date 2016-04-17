
package bal.commande;

import entites.Commande;

/**
 *
 * @author rsmon
 */

public interface BalCommande {
    
    Float   montantCommandeHT(Commande pCommande);
    Float   montantCommandeTTC(Commande pCommande);
    boolean estReglee(Commande pCommande);
}
