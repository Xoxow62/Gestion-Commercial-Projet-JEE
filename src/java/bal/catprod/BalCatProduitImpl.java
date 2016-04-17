package bal.catprod;

import bal.produit.BalProduit;
import entites.CategorieProduit;
import entites.Produit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BalCatProduitImpl implements BalCatProduit {
  
    @Inject BalProduit balproduit;
    
    @Override
    public Float caAnnuelCatProduit(CategorieProduit pCatProd, int pAnnee) {

        Float ca=0F;
        
        for(Produit prod : pCatProd.getLesProduits()){
            ca += balproduit.caAnnuelProduit(prod, pAnnee);
        }
        
        return ca;
    }
    
    public Float caCatProdAnneeEnCours(CategorieProduit pCatProd){
        
        return caAnnuelCatProduit(pCatProd, utilitaire.UtilDate.anneeCourante());
    }
    

}
