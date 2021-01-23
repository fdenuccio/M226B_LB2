import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Write a description of class JsonHandler here.
 * 
 * @author  Jenia Isler 
 * @version 16.01.2021
 */
public class JsonHandler  
{
    private static final String SERVER_IP = "turret_Options.json";

    /**
     * Constructor for objects of class JsonHandler
     */
    public JsonHandler()
    {
        
    }

    public static JSONObject getJsonFile() {
      //Creating a JSONParser object
      JSONParser jsonParser = new JSONParser();
      try {
         //Parsing the contents of the JSON file
         JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("turret_Options.json"));
         return jsonObject;
      } catch (FileNotFoundException e) {
           e.printStackTrace();
           return null;
      } catch (IOException e) {
         e.printStackTrace();
         return null;
      } catch (ParseException e) {
         e.printStackTrace();
         return null;
      } 
      
      
    }
    
    
    public static String JSONtoString(JSONObject json){
        
        return json.toString();
        
    }
    
    
    public static int parseInt(Object value){
       return Integer.parseInt(String.valueOf(value.toString()));
    }
    public static String parseString(Object value){
       return String.valueOf(value.toString());
    }
}
