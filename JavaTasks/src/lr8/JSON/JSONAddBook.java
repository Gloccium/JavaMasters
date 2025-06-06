package lr8.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class JSONAddBook {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/ir10/example2-example.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            JSONObject newBook = new JSONObject();
            newBook.put("title", "Преступление и наказание");
            newBook.put("author", "Федор Достоевский");
            newBook.put("year", 1866);

            jsonArray.add(newBook);
            jsonObject.put("books", jsonArray);

            try (FileWriter file = new FileWriter("src/ir10/example2-example.json")) {
                file.write(jsonObject.toJSONString());
                System.out.println("Книга успешно добавлена!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}