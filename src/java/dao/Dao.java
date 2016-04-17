/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author rsmon
 */
public interface Dao {
    
   void enregistrerEntite (Object entite);
   void supprimerEntite  (Object entite);
   void repercuterMAJ     (Object entite);
   
   void detache(Object entite);
   
    void rafraichir(Object entite);
    
}
