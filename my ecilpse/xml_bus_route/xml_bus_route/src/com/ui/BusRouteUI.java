package com.ui;

import com.transform.Connector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by sarra on 2017/5/24.
 */
public class BusRouteUI {
    private String title = "Bus Routes";
    private JFrame frame;
    private BorderLayout layout;
    private JPanel searchPanel;
    private JPanel resultPanel;
    private JPanel routePanel;
    private JList routeList;
    private JList resultList;
    private JTextField searchTextField;
    private JButton searchButton;
    private Font font;
    private JPopupMenu pop;
    private JMenuItem addRouteItem;
    private JMenuItem removeRoute;

    private RouteDetailsFrame routeFrame;
    private Object[] listObjects;
    private Connector connector;
    private boolean flag = true;

    private final static int _ROUTE_LIST = 0;
    private final static int _RESULT_LIST = 1;
    private int choose = _ROUTE_LIST;


    public BusRouteUI() {
        connector = new Connector();
        InitializeFrame();
    }

    private void InitializeFrame() {
        layout = new BorderLayout(5,5);
        font = new Font("宋体", Font.PLAIN, 20);

        // 初始化窗口
        frame = new JFrame(title);
        frame.setLayout(layout);
        frame.setSize(800, 500);

        searchPanel = new JPanel();


        searchTextField = new JTextField(30);
        searchTextField.setFont(font);

        searchButton = new JButton("查找");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = setResultList();
                if (!b) {
                    JOptionPane.showMessageDialog(null, "找不到结果!","错误",JOptionPane.ERROR_MESSAGE);
                }
                frame.validate();
                frame.setVisible(true);
            }
        });

        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        resultPanel = new JPanel();

        resultList = new JList();

        routePanel = new JPanel(new GridLayout(0,1));

        routeList = new JList();
        setRouteList();

        initialPopupMenu();


        frame.add(routePanel, BorderLayout.WEST);
        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initialPopupMenu() {
        pop = new JPopupMenu();

        addRouteItem = new JMenuItem("添加线路");
        addRouteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routeFrame = new RouteDetailsFrame();
            }
        });

        pop.add(addRouteItem);

        removeRoute = new JMenuItem("删除线路");
        removeRoute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = null;
                if (choose == _ROUTE_LIST)
                    s = (String) routeList.getSelectedValue();
                if (choose == _RESULT_LIST) {
                    s = ((String) resultList.getSelectedValue());
                    if(s.contains(":")) {
                        s = s.substring(0, s.indexOf(":"));
                    }

                }
                if (connector.removeRoute(s)) {
                    JOptionPane.showMessageDialog(null, "删除成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    InitializeFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败！", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pop.add(removeRoute);

        routeList.add(pop);

        resultList.addMouseListener(onRouteList);
        routeList.addMouseListener(onRouteList);

    }


    public void setRouteList() {
        ArrayList items = connector.getRouteItems();
        listObjects = items.toArray(new Object[items.size()]);

        routeList.setListData(listObjects);
        routeList.setFont(font);
        routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        routeList.addListSelectionListener(onItemSelection);

       routeList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.isPopupTrigger()) {
                    pop.show(routeList, e.getX(), e.getY());
                    int index = routeList.locationToIndex(e.getPoint());
                    flag = !flag;
                    choose = _ROUTE_LIST;
                    routeList.setSelectedIndex(index);
                }
            }
        });

        routePanel.add(routeList);

    }


    public boolean setResultList() {
        ArrayList items = connector.getResultItems(searchTextField.getText());
        if (items.size() == 0)
            return false;
        listObjects = items.toArray(new Object[items.size()]);
        resultList.setListData(listObjects);
        resultList.setFont(font);
        resultList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.addListSelectionListener(onItemSelection);

        resultList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.isPopupTrigger()) {
                    pop.show(resultList, e.getX(), e.getY());
                    int index = resultList.locationToIndex(e.getPoint());
                    flag = !flag;
                    choose = _RESULT_LIST;
                    resultList.setSelectedIndex(index);
                }
            }
        });

        resultPanel.add(resultList);

        return true;
    }

    ListSelectionListener onItemSelection = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            String s = (String)((JList)e.getSource()).getSelectedValue();
                if (flag = !flag)
                    return;
                if (s.contains(":"))
                    routeFrame = new RouteDetailsFrame(s.substring(0, s.indexOf(':')));
                else
                    routeFrame = new RouteDetailsFrame(s);
        }
    };

    MouseAdapter onRouteList = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            if (e.isPopupTrigger())
                pop.show((JList)e.getSource(), e.getX(), e.getY());
        }
    };


    public static void main(String[] args) {
        BusRouteUI ui = new BusRouteUI();
    }
}
