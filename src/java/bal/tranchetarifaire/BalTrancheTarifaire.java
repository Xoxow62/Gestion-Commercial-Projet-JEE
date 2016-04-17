
package bal.tranchetarifaire;

import entites.LigneDeCommande;


public interface BalTrancheTarifaire {

    Float getPrixUnitaire(LigneDeCommande ldc);
    
}
