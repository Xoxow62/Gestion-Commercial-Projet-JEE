package web.convertisseurs;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public abstract class  Convertisseur implements Converter, Serializable{
   
 @Override
 public String getAsString(FacesContext facesContext, UIComponent component, Object objet) {   
         
         return getAsString(objet);
 }         
    
 @Override
 public Object getAsObject(FacesContext facesContext, UIComponent component, String chaine) {
 
     return getAsObject( chaine);
 }
 
 protected abstract String getAsString( Object objet);
 protected abstract Object getAsObject( String chaine); 

}



