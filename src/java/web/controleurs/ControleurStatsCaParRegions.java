
package web.controleurs;

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
public class ControleurStatsCaParRegions {
   
  @Inject
  private DaoRegion daoRegion;
  
  @Inject 
  private BalRegion balRegion;
    
  private PieChartModel camembert;
  
  @PostConstruct
  public void init(){
    
    camembert=new PieChartModel();
   
    for (Region reg: daoRegion.getToutesLesRegions()){
       
        camembert.set(reg.getNomRegion(), balRegion.caAnneeEnCours(reg));    
    }
  }

  public PieChartModel getCamembert() {
        return camembert;
    }


    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public DaoRegion getDaoRegion() {
        return daoRegion;
    }

    public void setDaoRegion(DaoRegion daoRegion) {
        this.daoRegion = daoRegion;
    }

    public BalRegion getBalRegion() {
        return balRegion;
    }

    public void setBalRegion(BalRegion balRegion) {
        this.balRegion = balRegion;
    }
    
      
  //</editor-fold>
}
