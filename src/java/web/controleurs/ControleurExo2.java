
package web.controleurs;

import dao.client.DaoClient;
import entites.Client;
import entites.Commande;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;

/**
 *
 * @author rsmon
 */

@ManagedBean
@ViewScoped
public class ControleurExo2 implements Serializable{
    
    @Inject
    private DaoClient daoClient;
   
    private Long numcliRecherche;
    
    private Client client=new  Client();;
    
    private List<Commande> listeCommandes;
    
    private String messageTableau;
    
    public String ecouteurRecherche(){
           
         if(numcliRecherche!=null){
         
            client=daoClient.getLeClient(numcliRecherche);
            
            if (client!=null){
                listeCommandes=client.getLesCommandes();
                messageTableau="Pas de commande pour ce client";
            } 
            else {
               
                FacesContext contexte=FacesContext.getCurrentInstance();
                contexte.addMessage(null,
                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                    null, "PAS CLIENT CONNU AVEC CE NUMERO."));          
            }
        }
        return null; 
    }
    
    public void prevalide(ComponentSystemEvent e){
         
         this.client=new Client();
         this.setListeCommandes(new LinkedList<Commande>()); 
         this.messageTableau=null;
    }
     

    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Long getNumcliRecherche() {
        return numcliRecherche;
    }
    
    public void setNumcliRecherche(Long numcliRecherche) {
        this.numcliRecherche = numcliRecherche;
    }
    
    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }
    
    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }
    
    public String getMessageTableau() {
        return messageTableau;
    }

    public void setMessageTableau(String messageTableau) {
        this.messageTableau = messageTableau;
    }
    //</editor-fold>

}
