/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 000
 */
public class XmlDescriptorReader {

    public XmlDescriptor getDescriptor(String nameDescriptor) throws ParserConfigurationException, SAXException, IOException {
        Document xmlDocument; // переменная в которой будет храниться результат parse Xml
        String nameOS, vendor, version; // Создаем переменные типа String которые будет передавать в XmlDescriptor
        int cpuCore, ram, capacityHdd; // Создаем переменные типа int которые будет передавать в XmlDescriptor
        File xmlFile = new File("server/xml/" + nameDescriptor + ".xml"); // парсим xmlFile
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        xmlDocument = dBuilder.parse(xmlFile);
        NodeList os = xmlDocument.getElementsByTagName("OS"); // Создаем список тега OS
        NamedNodeMap osAttributes = os.item(0).getAttributes(); // Создаем переменную в которой хранятся атрибуты тега OS
        nameOS = osAttributes.getNamedItem("name").getTextContent(); // Присваиваем значения
        vendor = osAttributes.getNamedItem("vendor").getTextContent(); // Присваиваем значения
        version = osAttributes.getNamedItem("version").getTextContent(); // Присваиваем значения
        cpuCore = Integer.valueOf(xmlDocument.getElementsByTagName("cpucore").item(0).getTextContent()); // Присваиваем значения
        ram = Integer.valueOf(xmlDocument.getElementsByTagName("ram").item(0).getTextContent()); // Присваиваем значения
        capacityHdd = Integer.valueOf(xmlDocument.getElementsByTagName("capacityhdd").item(0).getTextContent()); // Присваиваем значения
        XmlDescriptor descriptor = new XmlDescriptor(nameOS, vendor, version, cpuCore, ram, capacityHdd); // Создаем XmlDescriptor
        return descriptor;
    }
}
