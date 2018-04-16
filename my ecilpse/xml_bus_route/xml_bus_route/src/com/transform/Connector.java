package com.transform;

import com.ui.BusRouteUI;
import com.xml.XmlDom4JParser;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sarra on 2017/5/25.
 */
public class Connector {
    private BusRouteUI ui;
    private XmlDom4JParser parser;

    public Connector() {
        parser = new XmlDom4JParser();
    }


    public ArrayList getRouteItems() {
        List list = parser.getAllRoutes();
        Iterator iterator = list.iterator();
        ArrayList routeList = new ArrayList();
        while (iterator.hasNext()) {
            Element element = (Element)iterator.next();
            routeList.add(element.attribute("name").getValue());
        }
        return routeList;
    }


    public ArrayList getResultItems(String s) {
        ArrayList list = new ArrayList();
        HashMap<String, Element> map = parser.getRoutes(s);
        int size = map.size();
        for (int i = 0; i < size / 2; ++i) {
            String str;
            if (map.get("station" + String.valueOf(i)) == null)
                str = map.get("route" + String.valueOf(i)).attribute("name").getValue();
            else
                str = map.get("route" + i).attribute("name").getValue() + ": " +map.get("station" + i).getText();
            System.out.println(str);
            list.add(str);
        }
        return list;
    }

    public HashMap getRouteDetails(String s) {
        Element element = parser.getRouteElement(s);
        HashMap<String, String> map = new HashMap<>();
        int count = 0;
        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()) {
            Element stationElement = (Element)iterator.next();
            map.put("station" + String.valueOf(count++), stationElement.getTextTrim());
        }
        map.put("route_name", element.attributeValue("name"));
        map.put("start_time", element.attributeValue("start_time"));
        map.put("end_time", element.attributeValue("end_time"));

        return map;
    }

    public int addRoute(String s) {
        int flag = parser.addRoute(s);
        return flag;
    }

    public boolean removeRoute(String s) {
        boolean flag = parser.removeRoute(s);
        return flag;
    }
    public int addStation(String s1, String s2, String s3) {
        int flag = parser.addStation(s1, s2, s3);
        return flag;
    }

    public boolean removeStation(String s1, String s2) {
        boolean flag = parser.removeStation(s1, s2);
        return flag;
    }

    public int modifyAttributes(HashMap map) {
        int flag = parser.modifyAttributes(map);
        return flag;
    }

    public static void main(String[] args) {
        Connector connector = new Connector();

    }
}
