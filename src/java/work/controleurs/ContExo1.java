package work.controleurs;

import dao.client.DaoClient;
import entites.Client;
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
public class ContExo1 implements Serializable{
  
    @Inject
    private DaoClient daoClient;
  
    private Long      numcliRecherche;
    private Client    client;
    
    public void ecouteurRecherche(){
    
        if(numcliRecherche!=null){ 
            client=daoClient.getLeClient(numcliRecherche); 
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
    //</editor-fold>   
}



