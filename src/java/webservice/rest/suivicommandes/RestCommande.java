package webservice.rest.suivicommandes;

import bal.commande.BalCommande;
import bal.tranchetarifaire.BalTrancheTarifaire;
import dao.commande.DaoCommande;
import dto.commande.ResumeCommande;
import dto.lignecommande.ResumeLigneCommande;
import entites.Commande;
import java.util.LinkedList;
import entites.LigneDeCommande;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("suivicommandes")
public class RestCommande {
    
   @Inject DaoCommande daoCommande;
   @Inject BalCommande balCommande;
   @Inject BalTrancheTarifaire baltarifaire;
   
   @GET
   @Path("/resumecommande/{pNumCom}")
   @Produces({"application/xml"})
   public ResumeCommande resumeCommande( @PathParam("pNumCom")Long pNumCom){  

   ResumeCommande rc = new ResumeCommande();
   Commande com = daoCommande.getCommande(pNumCom);
   
   rc.setNomCli(com.getLeClient().getNomCli());
   rc.setNumCli(com.getLeClient().getNumCli());
   rc.setAdrCli(com.getLeClient().getAdrCli());
   
   rc.setCodeReg(com.getLeClient().getLaRegion().getCodeRegion());   
   rc.setNomReg(com.getLeClient().getLaRegion().getNomRegion());
   
   
   rc.setNumcom(pNumCom);
   rc.setDatecom(com.getDateCom());
   rc.setEtatcom(com.getEtatCom());   
   
   Float montantHT = balCommande.montantCommandeHT(com);
   rc.setMontantHT(montantHT);
   
   Float montantTTC = balCommande.montantCommandeTTC(com);
   rc.setMontantTTC(montantTTC);
   
   return rc;
}

   @GET
   @Path("/resumeslignesdecommande/{pNumCom}")
   @Produces({"application/xml"})
   
   public List<ResumeLigneCommande> resumeLigneCommande( @PathParam("pNumCom")Long pNumCom){
       
      Commande com = daoCommande.getCommande(pNumCom); 
      List<LigneDeCommande> ldc = com.getLesLignesDeCommande();
      List<ResumeLigneCommande> rldc = new LinkedList();
      
      for(LigneDeCommande lgc : ldc){
          
         ResumeLigneCommande rlc = new ResumeLigneCommande();
         
         rlc.setRefProd(lgc.getLeProduit().getRefProd());
         rlc.setDesigProd(lgc.getLeProduit().getDesigProd());
         rlc.setMontantHT(this.baltarifaire.getPrixUnitaire(lgc));
         rlc.setQteCom(lgc.getQteCom());
         
         rldc.add(rlc);
                 
      }
                 
       return rldc;       
   }
   
   
   
}