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
import web.beans.TableAssocRegions;

/**
 *
 * @author rsmon
 */

@Named
@RequestScoped
public class ContExo8 implements Serializable{
     
    @Inject  private TableAssocRegions tRegions;
    @Inject  private Dao               dao; 
 
    private Client                     client=new Client();
  
    private List<Region>               lesRegions;
    
    @PostConstruct
    public void init(){
     
        lesRegions=tRegions.getListe();
                 
    }
    
    public void ajoutAlaBase(){
        
        client.getLaRegion().getLesClients().add(client);
        dao.enregistrerEntite(client); 
    }
  
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
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
