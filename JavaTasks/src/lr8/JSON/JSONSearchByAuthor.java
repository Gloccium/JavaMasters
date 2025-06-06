package lr8.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONSearchByAuthor {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/ir10/example2-example.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            String searchAuthor = "Лев Толстой";
            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                if (book.get("author").equals(searchAuthor)) {
                    System.out.println("\nИмя книги: " + book.get("title"));
                    System.out.println("Автор: " + book.get("author"));
                    System.out.println("Год выпуска: " + book.get("year"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}