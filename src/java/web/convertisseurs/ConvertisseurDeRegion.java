package web.convertisseurs;
import entites.Region;
import javax.faces.convert.FacesConverter;
import web.beans.TableAssocRegions;
import web.helpers.JsfHelperBean;

@FacesConverter(forClass=Region.class)
public class ConvertisseurDeRegion extends Convertisseur {
     
 @Override
 public String getAsString(Object objet){
   
     Region    obj=(Region)objet;
     return   cle(obj);
 }
 
 @Override
 public  Object getAsObject( String string) {
    
    TableAssocRegions ta=JsfHelperBean.getBean("#{tableAssocRegions}", TableAssocRegions.class);  
    return ta.getObjet(string);
 }
 
 private String cle(Object obj) {
         return ((Region)obj).getCodeRegion();
       // return Integer.toHexString(obj.hashCode());
 }
 
}



