/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.catprod;

import entites.CategorieProduit;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface DaoCatProduit {
    
    CategorieProduit getCatProduit(String pCodeCateg);
    List<CategorieProduit>       getTousLesCatProd();
}
