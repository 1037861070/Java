package com.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sarra on 2017/5/24.
 */
public class XmlDom4JParser {
    private String xmlFilename = "route.xml";
    private String dtdFilename = "route.dtd";
    private Document document;
    private final static int OK = 0;
    private final static int NO_ROUTE = 1;
    private final static int NO_STATION = 2;
    private final static int EXISTED_ROUTE = 3;
    private final static int EXISTED_STATION = 4;
    private final static int OTHER = 5;


    public XmlDom4JParser() {
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(new File(xmlFilename));
        } catch (Exception e) {
            System.out.print("一般错误：");
            e.printStackTrace();
        }
    }

    public List getAllRoutes() {
        List list = document.selectNodes("//route");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            System.out.println(element.attribute("name").getValue());
        }
        return list;
    }

    public HashMap getRoutes(String s) {
        List list = document.selectNodes("//route");
        Iterator iterator = list.iterator();
        HashMap<String, Element> map = new HashMap<>();
        int count = 0;
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();

            if (element.attribute("name").getValue().contains(s)) {
                map.put("route" + String.valueOf(count), element);
                map.put("station" + String.valueOf(count), null);
                count++;
            }

            Iterator iterator1 = element.elementIterator();
            while (iterator1.hasNext()) {
                Element elem = (Element) iterator1.next();
                if (elem.getText().contains(s)) {
                    map.put("route" + String.valueOf(count), element);
                    map.put("station" + String.valueOf(count), elem);
                    count++;
                    break;
                }
            }
        }
        return map;
    }

    public Element getRouteElement(String s) {
        List list = document.selectNodes("//route");
        Iterator iterator = list.iterator();
        Element element = null;
        while (iterator.hasNext()) {
            element = (Element) iterator.next();
            if (element.attribute("name").getValue().equals(s))
                break;
        }
        return element;
    }

    public int addRoute(String s) {
        int flag = OTHER;
        if (s != null) {
            List list = document.selectNodes("//route");
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                Element e = (Element) iter.next();
                if (e.attribute("name").getValue().equals(s)) {
                    flag = EXISTED_ROUTE;
                    break;
                }
            }
            if (flag != EXISTED_ROUTE) {
                Element e = DocumentHelper.createElement("route");
                e.addAttribute("name", s);
                e.addAttribute("start_time", "");
                e.addAttribute("end_time", "");
                document.getRootElement().add(e);
                writeXml();
                flag = OK;
            }
        }
        return flag;
    }

    public int addStation(String s1, String s2, String s3) {
        int flag = -1;
        int count = 0;
        int index = count;
        List list = document.selectNodes("//route");
        Iterator iterator = list.iterator();
        Element er = null;
        while (iterator.hasNext()) {
            er = (Element) iterator.next();
            if (er.attribute("name").getValue().equals(s1))
                break;
            er = null;
            flag = NO_ROUTE;
        }
        if (er != null) {
            Element e = DocumentHelper.createElement("station");
            e.setText(s3);
            List l = er.elements("station");
            Iterator station = l.iterator();
            Element es = null;
            while (station.hasNext()) {
                ++count;
                es = (Element) station.next();
                if (es.getText().equals(s3)) {
                    flag = EXISTED_STATION;
                    break;
                }
                if (es.getText().equals(s2))
                    index = count;
            }
            if (flag != EXISTED_STATION) {
                if (s2 != null) {
                    l.add(index, e);
                    flag = OK;
                } else {
                    l.add(e);
                    flag = OK;
                }
            }
        }

        if (flag == OK) {
            writeXml();
        }
        return flag;
    }

    public boolean removeRoute(String s) {
        boolean flag = false;
        if (s != null) {
            Element root = document.getRootElement();
            List list = document.selectNodes("//route");
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Element e = (Element) iterator.next();
                if (e.attribute("name").getValue().equals(s)) {
                    root.remove(e);
                    writeXml();
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean removeStation(String s1, String s2) {
        boolean flag = false;
        List list = document.selectNodes("//route");
        Iterator iterator = list.iterator();
        Element er = null;
        while (iterator.hasNext()) {
            er = (Element) iterator.next();
            if (er.attribute("name").getValue().equals(s1)) break;
            er = null;
        }
        if (er != null) {
            Iterator station = er.elementIterator();
            Element es;
            while (station.hasNext()) {
                es = (Element) station.next();
                if (es.getText().equals(s2)) {
                    er.remove(es);
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            writeXml();
        }
        return flag;
    }

    public int modifyAttributes(HashMap map) {
        int flag = OTHER;
        List list = document.selectNodes("//route");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Element element = (Element)iterator.next();
            if (!element.attribute("name").getValue().equals(map.get("old_name"))
                    && element.attribute("name").getValue().equals(map.get("name"))) {
                flag = EXISTED_ROUTE;
                break;
            }
            if (flag != EXISTED_ROUTE) {
                if (element.attribute("name").getValue().equals(map.get("old_name"))) {
                    element.attribute("name").setValue((String) map.get("name"));
                    element.attribute("start_time").setValue((String) map.get("start_time"));
                    element.attribute("end_time").setValue((String) map.get("end_time"));
                    flag = OK;
                }
            }
        }
        if (flag == OK) {
            writeXml();
        }
        return flag;
    }

    public void writeXml() {
        Element root = document.getRootElement();
        List list = document.selectNodes("//route");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Element e = (Element)iterator.next();
            if (e.attribute("name") == null)
                root.remove(e);
        }
        try{
            XMLWriter output = new XMLWriter(
                    new FileWriter(new File(xmlFilename)));
            output.write(document);
            output.close();
        }
        catch(IOException e){System.out.println(e.getMessage());}
    }

    public void printNode(Document document) {
        List list = document.selectNodes("//route");
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Element element = (Element) iter.next();
            Iterator iterator = element.elementIterator("name");
            while (iterator.hasNext()) {
                Element employeeElement = (Element) iterator.next();
                System.out.println(employeeElement.getText());
            }
        }
    }

    public void printNode(Element e) {
        Iterator iterator = e.elementIterator();
        System.out.println(e.getText());
        while (iterator.hasNext()) {
            Element e2 = (Element)iterator.next();
            printNode(e2);
        }
    }

    public static void main(String[] args) {
        XmlDom4JParser parser = new XmlDom4JParser();
//        HashMap<Element, Element> map = parser.getRoutes("雅安");
//        for (int i = 0; i < map.size() / 2; ++i) {
//            System.out.println(map.get("route" + String.valueOf(i)).attribute("name").getValue() + ": "
//                    + map.get("station" + String.valueOf(i)).getText()
//            );
//        }

        parser.getRouteElement("59路");
    }

}
