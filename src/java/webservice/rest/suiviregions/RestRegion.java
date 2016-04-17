package webservice.rest.suiviregions;

import bal.region.BalRegion;
import dao.commande.DaoCommande;
import dao.produit.DaoProduit;
import dao.region.DaoRegion;
import dto.region.ResumeRegion;
import entites.Region;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.LinkedList;
import java.util.List;

@Stateless
@Path("suiviregions")
public class RestRegion {
    
   @Inject DaoCommande      daoCommande;
   @Inject DaoProduit       daoProduit;
   @Inject DaoRegion        daoRegion;
   @Inject BalRegion        balRegion;

   @GET
   @Path("/resumeregion/{codeReg}")
   @Produces({"application/xml"})
   public ResumeRegion resumeRegion( @PathParam("codeReg")  String codeReg){
    
       ResumeRegion rr = new ResumeRegion();
       Region reg = daoRegion.getLaRegion(codeReg);
        chargerResumeRegion(rr,reg);
       
     return rr;
   } 
  
   
   @GET
   @Path("/resumeregion/tous")
   @Produces({"application/xml"})
   public List<ResumeRegion> ResumeTousRegion(){
       
   List<ResumeRegion> ltlr = new LinkedList();
   
   for ( Region reg : daoRegion.getToutesLesRegions()){
   
       ResumeRegion rr = new ResumeRegion();
            chargerResumeRegion(rr, reg);
       
       ltlr.add(rr);
   
   }      
       return ltlr;
       
   }  

    private void chargerResumeRegion(ResumeRegion rr, Region reg) {
        rr.setCodeReg(reg.getCodeRegion());
        rr.setNomReg(reg.getNomRegion());
        rr.setCaAnnuel(balRegion.caAnneeEnCours(reg));
        rr.setNbClient(reg.getLesClients().size());
    }
    
   }
   

