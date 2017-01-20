package JSON_parser;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Ootka on 20-Jan-17.
 */
public class Main {
    public static void main(String[] args) {
        String stringToParse = perfomRequest("C:\\Users\\Ootka\\Downloads\\JavaPRO\\JSON1\\json.txt");

        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(stringToParse, JSON.class);
        System.out.println(gson.toJson(json));
    }

    private static String perfomRequest(String fileName){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String curLine;
            while ((curLine = br.readLine()) != null){
                sb.append(curLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
