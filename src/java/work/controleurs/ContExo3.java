
package work.controleurs;

import bal.client.BalClient;
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
import javax.inject.Inject;

/**
 *
 * @author rsmon
 */

@ManagedBean
@ViewScoped
public class ContExo3 implements Serializable{
    
    @Inject private DaoClient daoClient;
    
    @Inject private BalClient balClient;
     
    private Long numcliRecherche;
    
    private Client client;
    private boolean clientExiste;
    
    private Float  caAnnuelClient;
    
    private List<Commande> listeCommandes;
    
    private String messageTableau;
    
    public String ecouteurRecherche(){
           
         if(numcliRecherche!=null){
         
            client=daoClient.getLeClient(numcliRecherche);
            
            if (client!=null){
                clientExiste=true;
                listeCommandes=client.getLesCommandes();
                caAnnuelClient=balClient.caAnneeEnCours(client);
                messageTableau="Pas de commande pour ce client";
                
            } 
            else {
                clientExiste=false;
                client=new Client();
                caAnnuelClient=null;
                FacesContext contexte=FacesContext.getCurrentInstance();
                contexte.addMessage(null,
                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                    null, "PAS CLIENT CONNU AVEC CE NUMERO."));          
            }
        }
        return null; 
    }
    
    public void prevalide(){
         
         this.client=new Client();
         this.setListeCommandes(new LinkedList<Commande>());
         this.caAnnuelClient=null;
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
    
     public Float getCaAnnuelClient() {
        return caAnnuelClient;
    }

    public void setCaAnnuelClient(Float caAnnuelClient) {
        this.caAnnuelClient = caAnnuelClient;
    }
    
    
     public boolean isClientExiste() {
        return clientExiste;
    }

    
    //</editor-fold>

   
}
