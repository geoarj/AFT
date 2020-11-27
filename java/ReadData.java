import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.text.ParseException;
import java.util.Iterator;

public class ReadData {

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

//        FileReader reader = new FileReader("/Users/dhakon/Desktop/Java/Task3/src/main/java/companies.json");

        try {
//            Object obj = jsonParser.parse(reader);
            Object obj = parser.parse(new FileReader("/Users/dhakon/Desktop/Java/Task3/src/main/java/companies.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray companyList = (JSONArray) jsonObject.get("Company List");

            Iterator<Object> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//            String name = (String) compjsonobj.get("name");
//            String address = (String) compjsonobj.get("address");
//            System.out.println("Название организации: " + name);
//            System.out.println("Адрес организации: " + address);
//
//            JSONArray array = (JSONArray) compjsonobj.parse(new FileReader("companies.json"));
//
//            for (Object o : array) {
//                JSONObject securities = (JSONObject) array.get(i);
//
//                String id = (String) securities.get("id");
//
//                System.out.println("ID " +);
            }
        }
