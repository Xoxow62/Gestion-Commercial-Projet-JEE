/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bal.catprod;

import entites.CategorieProduit;

/**
 *
 * @author Administrateur
 */
public interface BalCatProduit {
    
    Float caAnnuelCatProduit(CategorieProduit pCatProd, int pAnnee);
}
