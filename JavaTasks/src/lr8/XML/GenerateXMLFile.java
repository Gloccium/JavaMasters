package lr8.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class GenerateXMLFile {
    private static final String FILE_PATH = "src/ftl10/example.xml";

    public static void main(String[] args) {
        try {
            // Создаем XML файл, если он не существует
            createXMLFileIfNotExists();

            // Добавляем новую книгу
            addBook("New Book Title", "New Author", "2023");

            System.out.println("Книга успешно добавлена!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createXMLFileIfNotExists() throws Exception {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            saveXMLToFile(doc);
        }
    }

    public static void addBook(String title, String author, String year) throws Exception {
        // Загружаем существующий XML файл
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File(FILE_PATH));

        // Создаем новый элемент book
        Element book = doc.createElement("book");

        Element titleElement = doc.createElement("title");
        titleElement.appendChild(doc.createTextNode(title));
        book.appendChild(titleElement);

        Element authorElement = doc.createElement("author");
        authorElement.appendChild(doc.createTextNode(author));
        book.appendChild(authorElement);

        Element yearElement = doc.createElement("year");
        yearElement.appendChild(doc.createTextNode(year));
        book.appendChild(yearElement);

        // Добавляем элемент book в корневой элемент library
        doc.getDocumentElement().appendChild(book);

        // Сохраняем изменения в файл
        saveXMLToFile(doc);
    }

    private static void saveXMLToFile(Document doc) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }
}