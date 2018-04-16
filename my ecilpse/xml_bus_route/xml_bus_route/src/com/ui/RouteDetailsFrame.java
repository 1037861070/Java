package com.ui;

import com.transform.Connector;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sarra on 2017/5/25.
 */
public class RouteDetailsFrame {
    private final static int EDIT_ROUTE = 0;
    private final static int ADD_ROUTE = 1;
    private final static int OK = 0;
    private final static int NO_ROUTE = 1;
    private final static int NO_STATION = 2;
    private final static int EXISTED_ROUTE = 3;
    private final static int EXISTED_STATION = 4;
    private final static int OTHER = 3;
    private final JLabel routeLabel = new JLabel("公交线路: ");
    private final JLabel timeLabel = new JLabel("起止时间: ");
    private final JLabel connectLabel = new JLabel("-");
    Connector connector = new Connector();
    private JFrame frame;
    private Box verticalBox;
    private JTextField routeName;
    private JTextField startTime;
    private JTextField endTime;
    private JList stationList;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private Font font;
    //    private JButton okButton;
    private JButton editButton;
    private JButton saveButton;
    private JPopupMenu popupMenu;
    private JMenu addStationItem;
    private JMenuItem addCurrentItem;
    private JMenuItem addLastItem;
    private JMenuItem removeItem;
    private String _title;
    private String _name = "";
    private String _start_time = "";
    private String _end_time = "";
    private ArrayList _stations;
    private int flag;
    private boolean isModified = false;


    public RouteDetailsFrame() {
        _title = "添加线路";
        String s1 = JOptionPane.showInputDialog("输入线路名: ");
        int mode = connector.addRoute(s1);
        while (mode == EXISTED_ROUTE) {
            s1 = JOptionPane.showInputDialog("线路已存在，重新输入: ");
        }
        if (s1 == null)
            return;

        String s2 = JOptionPane.showInputDialog("添加一个始发站: ");
        if (s2 == null) {
            return;
    }
        connector.addStation(s1, null, s2);

        flag = EDIT_ROUTE;
        Init();
    }

    public RouteDetailsFrame(String s) {
        _title = s;
        flag = EDIT_ROUTE;
        Init();
    }

    public static void main(String[] args) {
        new RouteDetailsFrame("320路");

    }

    private void Init() {
        font = new Font("宋体", Font.PLAIN, 20);
        frame = new JFrame();
        verticalBox = Box.createVerticalBox();

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        frame.setTitle(_title);
        frame.setSize(800, 500);
        frame.setLayout(layout);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5, 5, 0, 0);

        setDetails();
        setRouteName();
        setTime();
        setStationList();
        setButtons();
        initialPopupMenu();

        frame.setLocationRelativeTo(null);
//        frame.pack();
        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setRouteName() {
        routeLabel.setFont(font);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        layout.setConstraints(routeLabel, constraints);
        frame.add(routeLabel);

        routeName = new JTextField(_name);
        routeName.setFont(font);
        routeName.setEditable(isModified);
        routeName.addCaretListener(onTextChangedListener);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2;
        constraints.ipadx = 40;
        layout.setConstraints(routeName, constraints);
        frame.add(routeName);

        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        JPanel p = new JPanel();
        layout.setConstraints(p, constraints);
        frame.add(p);
    }

    public void setTime() {
        timeLabel.setFont(font);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        layout.setConstraints(timeLabel, constraints);
        frame.add(timeLabel);

        startTime = new JTextField(_start_time);
        startTime.setFont(font);
        startTime.setEditable(isModified);
        startTime.addCaretListener(onTextChangedListener);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2;
        constraints.ipadx = 40;
        layout.setConstraints(startTime, constraints);
        frame.add(startTime);

        connectLabel.setFont(font);
        connectLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        layout.setConstraints(connectLabel, constraints);
        frame.add(connectLabel);

        endTime = new JTextField(_end_time);
        endTime.setFont(font);
        endTime.setEditable(isModified);
        endTime.addCaretListener(onTextChangedListener);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2;
        constraints.ipadx = 40;
        layout.setConstraints(endTime, constraints);
        frame.add(endTime);

        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        JPanel p = new JPanel();
        layout.setConstraints(p, constraints);
        frame.add(p);
    }

    public void setStationList() {
        if (flag == EDIT_ROUTE) {
            stationList = new JList(_stations.toArray(new Object[_stations.size()]));
            stationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            stationList.setFont(font);
            stationList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            constraints.weightx = 0;
            constraints.gridwidth = 5;
            layout.setConstraints(stationList, constraints);
            frame.add(stationList);
        } else if (flag == ADD_ROUTE) {
        }

        JPanel p = new JPanel();
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(p, constraints);
        frame.add(p);
    }

        public void setDetails() {
        if (flag == EDIT_ROUTE) {
            HashMap<String, String> map = connector.getRouteDetails(_title);
            _stations = new ArrayList();
            for (int i = 0; i < map.size() - 3; ++i) {
                _stations.add(map.get("station" + String.valueOf(i)));
            }
            _name = map.get("route_name");
            _start_time = map.get("start_time");
            _end_time = map.get("end_time");
        } else if (flag == ADD_ROUTE) {

        }
    }

    public void setButtons() {
        JPanel p = new JPanel();
        constraints.weightx = 1;
        constraints.gridwidth = 1;
        layout.setConstraints(p, constraints);
        frame.add(p);

        editButton = new JButton("修改");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routeName.setEditable(true);
                startTime.setEditable(true);
                endTime.setEditable(true);
            }
        });
        constraints.weightx = 0;
        constraints.gridwidth = 2;
        layout.setConstraints(editButton, constraints);
        frame.add(editButton);

        saveButton = new JButton("保存");
        saveButton.setEnabled(isModified);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (_name.equals(routeName.getText().trim()) && _start_time.equals(startTime.getText().trim()) && _end_time.equals(endTime.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "修改失败：内容未修改！", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("old_name", _name);
                    map.put("name", routeName.getText());
                    map.put("start_time", startTime.getText());
                    map.put("end_time", endTime.getText());
                    int mode = connector.modifyAttributes(map);
                    if (mode == OK) {
                        JOptionPane.showMessageDialog(null, "修改成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    } else if (mode == EXISTED_ROUTE){
                        JOptionPane.showMessageDialog(null, "修改失败: 线路已存在！", "失败", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "修改失败！", "失败", JOptionPane.ERROR_MESSAGE);
                    }
                    isModified = false;
                    routeName.setEditable(isModified);
                    startTime.setEditable(isModified);
                    endTime.setEditable(isModified);
                    saveButton.setEnabled(false);
                    routeName.setText(_name);
                    startTime.setText(_start_time);
                    endTime.setText(_end_time);
                    frame.validate();
                    frame.setVisible(true);
                }
            }
        });
        constraints.weightx = 0;
        constraints.gridwidth = 2;
        layout.setConstraints(saveButton, constraints);
        frame.add(saveButton);
    }

    private void initialPopupMenu() {
        popupMenu = new JPopupMenu();

        addStationItem = new JMenu("添加站点");

        addLastItem = new JMenuItem("添加到末尾");
        addLastItem.addActionListener(onAddItems);

        addCurrentItem = new JMenuItem("添加到当前节点后");
        addCurrentItem.addActionListener(onAddItems);


        addStationItem.add(addCurrentItem);
        addStationItem.add(addLastItem);


        popupMenu.add(addStationItem);

        removeItem = new JMenuItem("删除站点");
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = routeName.getText();
                String s2 = (String) stationList.getSelectedValue();
                if (connector.removeStation(s1, s2)) {
                    JOptionPane.showMessageDialog(null, "删除成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new RouteDetailsFrame(s1);
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败！", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        popupMenu.add(removeItem);

        stationList.add(popupMenu);

        stationList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.isPopupTrigger()) {
                    popupMenu.show(stationList, e.getX(), e.getY());
                    int index = stationList.locationToIndex(e.getPoint());
                    stationList.setSelectedIndex(index);
                }
            }
        });
    }

    CaretListener onTextChangedListener = new CaretListener() {
        @Override
        public void caretUpdate(CaretEvent e) {
            isModified = true;
            saveButton.setEnabled(isModified);
        }
    };

    ActionListener onAddItems = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = routeName.getText();
            String s2 = null;
            String s3 = null;
            if (e.getActionCommand().equals("添加到末尾"))
                s2 = null;
            else if (e.getActionCommand().equals("添加到当前节点后"))
                s2 = (String) stationList.getSelectedValue();
            s3 = JOptionPane.showInputDialog(frame, "输入添加的站点名: ");

            switch (connector.addStation(s1, s2, s3)) {
                case OK:
                    JOptionPane.showMessageDialog(null, "添加成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new RouteDetailsFrame(s1);
                    break;
                case EXISTED_STATION:
                    JOptionPane.showMessageDialog(null, "添加失败: 站点已存在！", "失败", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "添加失败！", "失败", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
