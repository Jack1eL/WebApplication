package com.ljackie.root.util.fileresolve.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: com.ljackie.root.util.fileresolve
 * @Description: //xml 资源解析
 * @Author: ljackie
 * @Date: 2020/3/27 11:03 上午
 */
public class XmlResources{

    private static class Inner
    {
        private static XmlResources xmlResources = new XmlResources();
    }

    public static List<String> FILENAMEURLS = new ArrayList<>();

    private static String XMLURL = "classpath:ResourcesFile.xml";

    static {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(XMLURL);
            NodeList nodeList = document.getElementsByTagName("urls");
            node(nodeList);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void node(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    FILENAMEURLS.add(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }

    public XmlResources()
    {}

    public static XmlResources init()
    {
        return Inner.xmlResources;
    }

}
