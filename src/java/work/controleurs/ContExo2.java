package work.controleurs;

import bal.client.BalClient;
import dao.client.DaoClient;
import entites.Client;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rsmon
 */

@Named
@SessionScoped
public class ContExo2 implements Serializable{
  
    @Inject
    private DaoClient daoClient;
    
    @Inject BalClient balClient;
  
    private Long   numcliRecherche;
    private Client client;
    
    private Float  caAnnuelClient;
    
    public void ecouteurRecherche(){
    
        if(numcliRecherche!=null){ 
            
            client=daoClient.getLeClient(numcliRecherche);
            
            if (client!=null){
                caAnnuelClient=balClient.caAnneeEnCours(client);
            }
            else {
             
             client=new Client(); caAnnuelClient=null;

             FacesContext contexte=FacesContext.getCurrentInstance();
             contexte.addMessage(null,
                                 new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                 null, "PAS CLIENT CONNU AVEC CE NUMERO."));  
           }
        }
        
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
    
     public Float getCaAnnuelClient() {
        return caAnnuelClient;
    }

    public void setCaAnnuelClient(Float caAnnuelClient) {
        this.caAnnuelClient = caAnnuelClient;
    }
    //</editor-fold>
  
}
