import greenfoot.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class checkInput here.
 * 
 * @author Jenia Isler 
 * @version 1.0
 */
public class checkInput  
{

    /**
     * creates a Popup asking the User if he wants to be the Server
     * 
     * @return          returns a Boolean value if he should be Server 
     * 
     * 
     */
    public static boolean ActasServer(){
        String response = null;
        do{
            response = Greenfoot.ask("Are you a Host [yes/no]");
        } while(!(response.contains("yes") || response.contains("no")));
        if(response.contains("yes")){
            return true;
        }else{return false;}
    } 

    
    /**
     * Checks String against Regex if its a IPv4 format
     * 
     * @param   ip      Enter a String that might be a IP
     * @return          returns true boolean value if IP has correct value 
     * 
     */ 
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
