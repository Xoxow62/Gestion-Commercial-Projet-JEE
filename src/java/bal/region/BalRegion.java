package bal.region;


import entites.Region;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rsmon
 */
public interface BalRegion {
    
    Float caAnnuel(Region region, int pAnnee );
    Float caAnneeEnCours(Region region);
}
