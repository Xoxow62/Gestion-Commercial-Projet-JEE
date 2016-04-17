
package web.controleurs;

import bal.catprod.BalCatProduit;
import dao.catprod.DaoCatProduit;
import entites.CategorieProduit;
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
public class ControleurStatsCaCategProd {
   
  @Inject
  private DaoCatProduit daoCatProd;
  
  @Inject 
  private BalCatProduit balCatProd;
    
  private PieChartModel camembert;
  
  @PostConstruct
  public void init(){
    
    camembert=new PieChartModel();
   
    for (CategorieProduit cp: daoCatProd.getTousLesCatProd()){
      
        camembert.set(cp.getNomCateg(),balCatProd.caAnnuelCatProduit(cp, utilitaire.UtilDate.anneeCourante()));
    }
  }

  public PieChartModel getCamembert() {
        return camembert;
    }


    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public DaoCatProduit getDaoCatProd() {
        return daoCatProd;
    }

    public void setDaoCatProd(DaoCatProduit daoCatProd) {
        this.daoCatProd = daoCatProd;
    }

    public BalCatProduit getBalCatProd() {
        return balCatProd;
    }

    public void setBalCatProd(BalCatProduit balCatProd) {
        this.balCatProd = balCatProd;
    }

    
    
  
  


  
  
  
        //</editor-fold>

}
