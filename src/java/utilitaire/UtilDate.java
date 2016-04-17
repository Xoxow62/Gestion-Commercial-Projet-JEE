
package utilitaire;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilDate {
    
    public static int       ageEnAnnees(Date datenaiss){
            
         
         int anAuj       = anneeCourante();
         int anNaiss     = annee(datenaiss);
        
         int moisAuj    =  moisCourant();
         int moisNaiss   = mois(datenaiss);
        
         int jourAuj     = jourDuMoisCourant();
         int jourNaiss   = jourDuMois(datenaiss);
        
         int age= anAuj-anNaiss ; 
         
         if(moisAuj<moisNaiss || ( moisAuj == moisNaiss &&jourAuj<jourNaiss ) ){ age--;}
         
         return age;
        } 
    public static String    aujourdhuiChaine()  {
        return format(aujourdhuiDate());}
     
    
    
    //<editor-fold defaultstate="collapsed" desc="RESTE DU CODE ET AUTRES FONCTIONS">
    static Locale           frLoc= new Locale("fr","FR");
    
    static DateFormat       df = DateFormat.getDateInstance(DateFormat.SHORT,frLoc);
    
    static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    private  static int     elementDeDate( Date d, int typeElement){
      
      Calendar c= Calendar.getInstance();
      c.setTime(d);
     
      return c.get(typeElement);     
    }
 
    
    
    public static String    format(Date date)   {return formater.format(date);}
    public static Date      parse(String chaine){
        
        try { return df.parse(chaine); }
        catch (ParseException ex) {
            
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    public static int       annee(Date d )      { return elementDeDate( d, Calendar.YEAR); }   
    public static int       mois(Date d )       { return elementDeDate( d, Calendar.MONTH)+1;} 
    public static int       jourDuMois(Date d ) { return elementDeDate( d, Calendar.DAY_OF_MONTH);} 
    
    public static int       anneeCourante()     { return annee(new Date());}
    public static int       moisCourant()       { return mois(new Date());}
    public static int       jourDuMoisCourant() { return jourDuMois(new Date());}
   
    public static Date      aujourdhuiDate()    { return new Date();}
    
    public static boolean   avant(Date date1,Date date2){
    
        return date1.before(date2);
    }
    public static boolean   avant(String sdate1,String sdate2){
    
        return avant( parse(sdate1),parse(sdate2));
    }
    public static boolean   avant(Date date1,String sdate2){
    
        return avant( date1,parse(sdate2));
    }
    public static boolean   avant(String sdate1, Date date2){
    
        return avant( parse(sdate1),date2);
    }
    
    public static boolean   apres(Date date1,Date date2){
    
        return date1.after(date2);
    }
    public static boolean   apres(String sdate1,String sdate2){
    
        return apres( parse(sdate1),UtilDate.parse(sdate2));
    }
    public static boolean   apres(Date date1,String sdate2){
    
        return apres( date1,parse(sdate2));
    }
    public static boolean   apres(String sdate1, Date date2){
    
        return apres( parse(sdate1),date2);
    }
    
   

    public static int       ageEnAnnees(String sDatenaiss){
    
       return ageEnAnnees(parse (sDatenaiss));
    }
    
    public static boolean dansAnneeEtMois(Date pDate, int pAnnee, int pMois){
    
         return annee(pDate)==pAnnee&&mois(pDate)==pMois;
    
    }
    
    
    public static boolean dansAnnee(Date pDate, int pAnnee){
    
         return annee(pDate)==pAnnee;
    
    }
    
    public static String nomMois(int m){
        
      String[] lesMois={"Janvier", "Février", "Mars","Avril","Mai","Juin",
                        "Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
     
      return lesMois[m-1];
    }
    
       //</editor-fold>
    
}



