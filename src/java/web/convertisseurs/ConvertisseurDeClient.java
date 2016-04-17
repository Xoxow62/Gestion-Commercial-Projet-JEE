package web.convertisseurs;
import entites.Client;
import javax.faces.convert.FacesConverter;
import web.beans.TableAssocClients;
import web.helpers.JsfHelperBean;

@FacesConverter(forClass=Client.class)
public class ConvertisseurDeClient extends Convertisseur {
     
 @Override
 public String getAsString(Object objet){
   
     Client    obj=(Client)objet;
     return   cle(obj);
 }
 
 @Override
 public  Object getAsObject( String string) {
    
    TableAssocClients ta=JsfHelperBean.getBean("#{tableAssocClients}", TableAssocClients.class);  
    return ta.getObjet(string);
 }
 
 private String cle(Object obj) {
     
        return ((Client)obj).getNumCli().toString();
 }
 
}



