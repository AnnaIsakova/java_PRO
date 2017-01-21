import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Ootka on 21-Jan-17.
 */
//Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые
//отправляются сегодня с 15:00 до 19:00.
//Написать код для добавления новых поездов в существующий XML.
public class XMLParser {
    public static void main(String[] args) {
        addElement("C:\\Users\\Ootka\\Desktop\\from\\result222.txt", "Lviv", "Warsaw", "21.01.2017", "15:05");
        addElement("C:\\Users\\Ootka\\Desktop\\from\\result222.txt", "London", "Tokyo", "21.01.2017", "16:55");
        parseXML("C:\\Users\\Ootka\\Desktop\\from\\result222.txt");
    }

    public static void parseXML(String fileName){
        File xmlFile = new File(fileName);

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String date = element.getElementsByTagName("date").item(0).getChildNodes().item(0).getNodeValue();
                    String time = element.getElementsByTagName("departure").item(0).getChildNodes().item(0).getNodeValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

                    Calendar departure = Calendar.getInstance();
                    departure.setTime(sdf.parse(date + " " + time));

                    Calendar todayStart = Calendar.getInstance();
                    todayStart.set(Calendar.HOUR_OF_DAY, 15);
                    todayStart.set(Calendar.MINUTE, 0);
                    todayStart.set(Calendar.SECOND, 0);
                    Calendar todayEnd = Calendar.getInstance();
                    todayEnd.set(Calendar.HOUR_OF_DAY, 19);
                    todayEnd.set(Calendar.MINUTE, 0);
                    todayEnd.set(Calendar.SECOND, 0);

                    if (departure.after(todayStart) && departure.before(todayEnd)){
                        System.out.println("Train from " + element.getElementsByTagName("from").item(0)
                                .getChildNodes().item(0).getNodeValue() + " to " + element.getElementsByTagName("to").
                                item(0).getChildNodes().item(0).getNodeValue() + " departs at " +
                                element.getElementsByTagName("departure").item(0).getChildNodes().item(0).getNodeValue() + ".");
                    }
                }
            }

        } catch (IOException | ParserConfigurationException | SAXException | ParseException e) {
            e.printStackTrace();
        }
    }

    //String from, String to, String date, String time
    public static void addElement(String fileName, String cityFrom, String cityTo, String depDate, String depTime){
        File xmlFile = new File(fileName);
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Element root = document.getDocumentElement();
            Node node = root.getLastChild();
            int id;
            String lastId = "";
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                lastId = element.getAttribute("id");
            }
            id = Integer.parseInt(lastId) + 1;

            Element train = document.createElement("train");
            train.setAttribute("id", (id + ""));
            root.appendChild(train);

            Element from = document.createElement("from");
            Element to = document.createElement("to");
            Element date = document.createElement("date");
            Element departure = document.createElement("departure");

            from.appendChild(document.createTextNode(cityFrom));
            to.appendChild(document.createTextNode(cityTo));
            date.appendChild(document.createTextNode(depDate));
            departure.appendChild(document.createTextNode(depTime));

            train.appendChild(from);
            train.appendChild(to);
            train.appendChild(date);
            train.appendChild(departure);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(fileName));
            transformer.transform(domSource, streamResult);

        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
