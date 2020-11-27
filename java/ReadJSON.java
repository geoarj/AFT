import com.sun.xml.internal.xsom.XSUnionSimpleType;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class ReadJSON {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(new FileReader("companies.json"));
            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println("Название организации: " + name);

            String address = (String) jsonObject.get("address");
            System.out.println("Адрес организации: " + address);

            String phoneNumber = (String) jsonObject.get("phoneNumber");
            System.out.println("Телефон организации: " + phoneNumber);

            String INN = (String) jsonObject.get("INN");
            System.out.println("ИНН организации: " + INN);

            String OGRN = (String) jsonObject.get("OGRN");
            System.out.println("ОГРН организации: " + OGRN);

            JSONArray companiesArray = (JSONArray) jsonObject.get("companies");
            Itetator<String> itetator = companiesArray.iterator();

            while(itetator.hasNext()) {
                System.out.println("name " + itetator.next());
            }



        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
