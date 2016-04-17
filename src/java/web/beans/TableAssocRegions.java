package web.beans;

import dao.region.DaoRegion;
import entites.Region;
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
public class TableAssocRegions  implements Serializable {
    
      
  //<editor-fold defaultstate="collapsed" desc="INJECTION DES DEPENDANCES">
    
    @Inject
    private DaoRegion daoRegion;  
    
  //</editor-fold>

  //<editor-fold  desc="DECLARATION DE LA LISTE ET CREATION DE LA TABLE ASSOCIATIVE">
   
    private List<Region>                liste;
    private Map<String, Region>         table= new LinkedHashMap<String, Region>();
    
    //</editor-fold>
    
  //<editor-fold  desc="INITIALISATION DE LA LISTE ET DE LE TABLE ASSOCIATIVE">
    
    @PostConstruct
    public void init (){
        
        liste= daoRegion.getToutesLesRegions();
        
        for(Region obj: liste ){
            
            table.put(cle(obj), obj);        
        }
        
        System.out.println("Initialisation Table Associative OK");
    }
    
    //</editor-fold>
   
    public Region getObjet(String cle){
 
        return table.get(cle);
    } 
    
    public List<Region> getListe() {
        return liste;
    }
    
    public void rafraichir(){
       
       table.clear();
       init();
    }
    
    //<editor-fold defaultstate="collapsed" desc="METHODES PRIVEES">
   
    private String cle(Object obj) {
        
        return ((Region)obj).getCodeRegion();
        
    }
    
    //</editor-fold>
  
}


