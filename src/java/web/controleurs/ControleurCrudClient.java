
package web.controleurs;

import dao.Dao;
import entites.Client;
import entites.Region;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import web.beans.TableAssocClients;
import web.beans.TableAssocRegions;

/**
 *
 * @author rsmon
 */

@Named
@SessionScoped
public class ControleurCrudClient implements Serializable{
     
    
    @Inject 
    private Dao dao;
    
    @Inject
    private TableAssocClients tClients;
     
    @Inject
    private TableAssocRegions tRegions;
    
    private List<Client> lesClients;
    
    private Client client;
      
    private List<Region> lesRegions;
    private Region       regionSel;
   
    @PostConstruct
    public void init(){
     
        tClients.rafraichir();
        lesClients=tClients.getListe();
        if (! lesClients.isEmpty()) {
           client=lesClients.get(0);   
        }
        lesRegions=tRegions.getListe();
    }
    
    public void traiterSelectionClient(){
    
        regionSel=client.getLaRegion();
    }
    
    public String rafraichir(){
        this.tClients.rafraichir();return null;
    }
   
    public void enregisterModifications(){
        
        dao.repercuterMAJ(client);
    
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
 
    
    
    public List<Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }

     public List<Region> getLesRegions() {
        return lesRegions;
    }

    public void setLesRegions(List<Region> lesRegions) {
        this.lesRegions = lesRegions;
    }

    public Region getRegionSel() {
        return regionSel;
    }

    public void setRegionSel(Region regionSel) {
        this.regionSel = regionSel;
    }

    
    
    //</editor-fold>
  
}
