package lr8.JSON;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONParser {
    public static void main(String[] args) {
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("src/ir10/example2/example-json.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Количество элементов: " + jsonObject.keySet().iterator().next());

            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                System.out.println("\nИмя книги: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год выпуска: " + book.get("year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
