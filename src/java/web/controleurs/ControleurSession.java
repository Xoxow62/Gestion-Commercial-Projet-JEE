
package web.controleurs;

import aut.Connexion;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rsmon
 */

@Named
@SessionScoped
public class ControleurSession  implements Serializable{
   
    @Inject
    private Connexion cx;
    
    private String nomUser;
    private String mdp;
    
    private boolean connexionOK=false;
    
    public String sIdentifier(){
      
        String page="index";
        
        connexionOK=connexionOK(nomUser, mdp);
      
       if(connexionOK){
           
           page="commandesparclients";
       }
       else{
       
           nomUser=null;mdp=null;           
       }
       return page;
    }
    
    public boolean connexionOK(String nom,String mdp ){
        
        return cx.login(nom,mdp);
      // return true; 
    }
   
    public String seDeconnecter(){        
       
        nomUser=null;mdp=null;
        connexionOK=false;
        return "/WEB-PAGES/pages/index";
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public String getNomUser() {
        return nomUser;
    }
    
    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }
    
    public String getMdp() {
        return mdp;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public boolean isConnexionOK() {
        return connexionOK;
    }
    
    public void setConnexionOK(boolean connexionOK) {
        this.connexionOK = connexionOK;
    }
    //</editor-fold>
    
    
   
}
