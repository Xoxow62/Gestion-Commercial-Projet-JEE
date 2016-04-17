/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controleurs;

import aut.Connexion;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author rsmon
 */

@Singleton
@Named
public class ControleurConnexion  implements Serializable{
    
    @Inject
    private Connexion cx;
    
    public boolean connexionOK(String nom,String mdp ){
        
        return cx.login(nom,mdp);
    }
    
}
