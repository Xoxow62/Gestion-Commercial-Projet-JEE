package web.beans;

import dao.client.DaoClient;
import entites.Client;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;


/**
 *
 * @author rsmon
 */


@Singleton
@Named
public class TableAssocClients  implements Serializable {
    
      
  //<editor-fold defaultstate="collapsed" desc="INJECTION DES DEPENDANCES">
    
    @Inject
    private DaoClient daoClient;  
    
  //</editor-fold>

  //<editor-fold  desc="DECLARATION DE LA LISTE ET CREATION DE LA TABLE ASSOCIATIVE">
   
    private List<Client>                liste;
    private Map<String, Client>         table= new LinkedHashMap<String, Client>();
    
    //</editor-fold>
    
  //<editor-fold  desc="INITIALISATION DE LA LISTE ET DE LE TABLE ASSOCIATIVE">
    
    @PostConstruct
    public void init (){
        
        liste= daoClient.getTousLesClients();
        
        for(Client obj: liste ){
            
            table.put(cle(obj), obj);        
        }
        
        System.out.println("Initialisation Table Associative OK");
    }
    
    //</editor-fold>
   
    public Client getObjet(String cle){
 
        return table.get(cle);
    } 
    
    public List<Client> getListe() {
        return liste;
    }
    
    public void rafraichir(){
       
       table.clear();
       init();
    }
    
    //<editor-fold defaultstate="collapsed" desc="METHODES PRIVEES">
   
    private String cle(Object obj) {
        
        return ((Client)obj).getNumCli().toString();        
    }
    
    //</editor-fold>
  
}


