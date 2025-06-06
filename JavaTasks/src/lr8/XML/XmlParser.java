package lr8.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParser {
    private static final String FILE_PATH = "src/ftl10/example.xml";

    public static void main(String[] args) {
        try {
            // Поиск по автору
            searchBooksByAuthor("Tom Ford");

            // Поиск по году издания
            searchBooksByYear("1967");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchBooksByAuthor(String author) throws Exception {
        File inputFile = new File(FILE_PATH);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        NodeList nodeList = doc.getElementsByTagName("book");

        System.out.println("Книги автора " + author + ":");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String currentAuthor = element.getElementsByTagName("author").item(0).getTextContent();

                if (currentAuthor.equalsIgnoreCase(author)) {
                    System.out.println("Название: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Год: " + element.getElementsByTagName("year").item(0).getTextContent());
                }
            }
        }
    }

    public static void searchBooksByYear(String year) throws Exception {
        File inputFile = new File(FILE_PATH);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        NodeList nodeList = doc.getElementsByTagName("book");

        System.out.println("Книги года " + year + ":");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String currentYear = element.getElementsByTagName("year").item(0).getTextContent();

                if (currentYear.equals(year)) {
                    System.out.println("Название: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
                }
            }
        }
    }
}