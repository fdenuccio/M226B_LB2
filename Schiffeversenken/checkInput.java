import greenfoot.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class checkInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class checkInput  
{
    
    
    public static boolean ActasServer(){

        String response = null;

        do{

            response = Greenfoot.ask("Are you a Host [yes/no]");

        } while(!(response.contains("yes") || response.contains("no")));

        if(response.contains("yes")){
            return true;
        }else{return false;}
    } 
    
    
    
    public static boolean checkIP(String ip){
        
        String regex = "\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(ip);
        
        if(matcher.matches()) {
            return true;
         } else {
            return false;
         }
  
    }
    
    
    
}
