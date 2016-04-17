package web.helpers;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

/**
 *
 * @author rsmon
 */
public  class JsfHelperBean {
    
 public static <T>   T getBean(String el, Class<T> cl){
        
    FacesContext     ctx= FacesContext.getCurrentInstance();
    
    ValueExpression  vex= ctx.getApplication()
                             .getExpressionFactory()
                             .createValueExpression(ctx.getELContext(), el, cl);        
    
    return (T)vex.getValue(ctx.getELContext());  
 }       

}





