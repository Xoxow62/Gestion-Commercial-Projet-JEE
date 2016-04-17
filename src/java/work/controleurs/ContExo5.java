
package work.controleurs;

import bal.region.BalRegion;
import dao.region.DaoRegion;
import entites.Region;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author rsmon
 */

@Named
@RequestScoped
public class ContExo5 {
   
  @Inject
  private DaoRegion daoRegion;
  
  @Inject 
  private BalRegion     balRegion;
    
  private PieChartModel camembert;
  
  @PostConstruct
  public void init(){
    
    camembert=new PieChartModel();
   
    for (Region reg: daoRegion.getToutesLesRegions()){
       
        camembert.set(reg.getNomRegion(), balRegion.caAnneeEnCours(reg));    
    }
  }

 
  
  //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
  
   public PieChartModel getCamembert() {
        return camembert;
    }
  //</editor-fold>
}
