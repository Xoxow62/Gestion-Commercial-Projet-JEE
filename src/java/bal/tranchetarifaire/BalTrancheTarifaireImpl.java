package bal.tranchetarifaire;

import entites.LigneDeCommande;
import entites.Produit;
import entites.TrancheTarifaire;
import java.io.Serializable;
import javax.inject.Singleton;

@Singleton
public class BalTrancheTarifaireImpl implements BalTrancheTarifaire, Serializable{

    @Override
    public Float getPrixUnitaire ( LigneDeCommande ldc){

        Float prixU = 0F;
        Float qte = ldc.getQteCom();
        Produit prod = ldc.getLeProduit();

        for (TrancheTarifaire tt : prod.getTrancheTarifaire()) {

            if (qte >= tt.getQteDebutTranche() && qte <= tt.getQteFinTranche()) {

                prixU = tt.getPrixUnitaireTranche();
                break;

            }
        }
        return prixU;
    }

}


