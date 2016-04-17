package work.controleurs;

import dao.Dao;
import entites.Client;
import entites.Region;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.beans.TableAssocClients;
import web.beans.TableAssocRegions;

/**
 *
 * @author rsmon
 */
@Named
@RequestScoped
public class ContExo7 implements Serializable{
  
    @Inject  private TableAssocClients tClients;
    @Inject  private TableAssocRegions tRegions;
    @Inject  private Dao               dao; 
  
    private List<Client>   lesClients;
    private Client         client;
  
    private List<Region>   lesRegions;
    
    @PostConstruct
    public void init(){
     
        lesRegions=tRegions.getListe();
        
        lesClients=tClients.getListe();
        
        
        if (! lesClients.isEmpty()) {
           client=lesClients.get(0);   
        }     
    }
    
    public void supprimerClient(){
        
        dao.supprimerEntite(client);
         
        tClients.rafraichir();
        lesClients=tClients.getListe();
        if (! lesClients.isEmpty()) {
    
            client=lesClients.get(0);   
        }      
    }
  
    
    public void traiterSelectionCombo(){
    
        if (client!=null){
            client.setLaRegion(tRegions.getObjet(client.getLaRegion().getCodeRegion()));
        }    
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public List<Client> getLesClients() {
        return lesClients;
    }
    
    public void setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    
    public List<Region> getLesRegions() {
        return lesRegions;
    }

    public void setLesRegions(List<Region> lesRegions) {
        this.lesRegions = lesRegions;
    }
    
    
    //</editor-fold>
  
}
