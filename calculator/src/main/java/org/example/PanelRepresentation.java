package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PanelRepresentation {
    public final static int DISPLAY_PANEL = 0;
    public final static int MAIN_PANEL = 1;
    public final static int PANEL_789 = 2;
    public final static int PANEL_456 = 3;
    public final static int PANEL_123 = 4;
    public final static int PANEL_SING_OF_OPERATION = 5;
    public final static int PANEL_0 = 6;
    public static Dimension numDimension;

    public final static int    PLUS = 10;
    public final static int    MINUS = 11;
    public final static int    MULTIPLICATION = 12;
    public final static int    DIVISION = 13;
    public final static int    EQUAL = 14;



    public static JPanel panelInit(Dimension size, LayoutManager layout){
        JPanel panel = new JPanel();
        panel.setLayout(Objects.requireNonNullElseGet(layout,() -> new BoxLayout(panel, BoxLayout.PAGE_AXIS)));
        panel.setSize(size);
        panel.setMaximumSize(size);
        panel.setVisible(true);
        return panel;
    }

    public static ArrayList<JPanel> panelsInit(Dimension size){
        numDimension = new Dimension(size.width/2, size.height/5);
        ArrayList<JPanel> panels = new ArrayList<>();
        panels.add(DISPLAY_PANEL, panelInit(new Dimension(size.width, size.height/5),new FlowLayout()));
        panels.add(MAIN_PANEL, panelInit(new Dimension(size.width*4/3, size.height*4/5),null));
        panels.add(PANEL_789, panelInit(numDimension,new FlowLayout()));
        panels.add(PANEL_456, panelInit(numDimension,new FlowLayout()));
        panels.add(PANEL_123, panelInit(numDimension,new FlowLayout()));
        panels.add(PANEL_SING_OF_OPERATION, panelInit(new Dimension(size.width/4, size.height*4/5), new GridLayout(5,11)));
        panels.add(PANEL_0, panelInit(numDimension, new FlowLayout()));
        return panels;
    }

}

