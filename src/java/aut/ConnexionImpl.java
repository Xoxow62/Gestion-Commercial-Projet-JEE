/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aut;

import java.io.Serializable;

/**
 *
 * @author rsmon
 */
public class ConnexionImpl implements Connexion, Serializable{

    @Override
    public boolean login(String nom, String mdp) {
   
        return nom.equalsIgnoreCase("LambdaSlam")&&mdp.equals("sio2014-15");
    }
    
}
