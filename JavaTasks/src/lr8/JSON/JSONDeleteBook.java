package lr8.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class JSONDeleteBook {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/ir10/example2-example.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            String titleToDelete = "Мастер и Маргарита";
            jsonArray.removeIf(book -> ((JSONObject) book).get("title").equals(titleToDelete));

            jsonObject.put("books", jsonArray);

            try (FileWriter file = new FileWriter("src/ir10/example2-example.json")) {
                file.write(jsonObject.toJSONString());
                System.out.println("Книга успешно удалена!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}