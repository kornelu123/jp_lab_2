package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.example.PanelRepresentation.*;
import static org.example.Buttons.*;

public class Calculator {

    public ArrayList<JButton> buttons;
    private final JFrame calcFrame;
    private final ArrayList<JPanel> panels;
    private final int calcWidth = 420, calcHeight = 696;

    private final JTextField output = new JTextField();

    public Calculator(){
        calcFrame = calcFrameInit();
        panels = panelsInit(new Dimension(calcWidth, calcHeight));
        buttons = buttonsInit();
        for(JPanel panel: panels){
            calcFrame.add(panel);
        }
        panelsConfig();
        listenerButtonsInit(output, buttons);
        calcFrame.setVisible(true);
    }

    private void panelsConfig(){
        for (int i=0; i < panels.size(); i++){
            panelConfig(i);
        }
    }

    private void panelConfig(int panelNum){
        JPanel curPan = panels.get(panelNum);
        switch (panelNum){
            case PanelRepresentation.DISPLAY_PANEL ->{
                calcFrame.add(curPan, BorderLayout.NORTH);
                curPan.add(output);
                output.setColumns(calcWidth/15);
                output.setCaretColor(Color.DARK_GRAY);
                output.setVisible(true);
            }
            case PanelRepresentation.MAIN_PANEL ->
            {
                calcFrame.add(curPan, BorderLayout.CENTER);
                curPan.add(panels.get(PanelRepresentation.PANEL_789));
                curPan.add(panels.get(PanelRepresentation.PANEL_456));
                curPan.add(panels.get(PanelRepresentation.PANEL_123));
                curPan.add(panels.get(PanelRepresentation.PANEL_0));
                curPan.setVisible(true);
            }
            case PanelRepresentation.PANEL_789 ->
            {
                curPan.add(buttons.get(7));
                curPan.add(buttons.get(8));
                curPan.add(buttons.get(9));
                curPan.setVisible(true);
            }
            case PanelRepresentation.PANEL_456 ->
            {
                curPan.add(buttons.get(4));
                curPan.add(buttons.get(5));
                curPan.add(buttons.get(6));
                curPan.setVisible(true);
            }
            case PanelRepresentation.PANEL_123 ->
            {
                curPan.add(buttons.get(1));
                curPan.add(buttons.get(2));
                curPan.add(buttons.get(3));
                curPan.setVisible(true);
            }
            case PanelRepresentation.PANEL_0 ->
            {
                curPan.add(buttons.get(0));
                curPan.setVisible(true);
            }
            case PanelRepresentation.PANEL_SING_OF_OPERATION -> {
                calcFrame.add(curPan, BorderLayout.EAST);
                curPan.add(buttons.get(PanelRepresentation.PLUS), Component.CENTER_ALIGNMENT);
                curPan.add(buttons.get(PanelRepresentation.MINUS), Component.CENTER_ALIGNMENT);
                curPan.add(buttons.get(PanelRepresentation.MULTIPLICATION), Component.CENTER_ALIGNMENT);
                curPan.add(buttons.get(PanelRepresentation.DIVISION), Component.CENTER_ALIGNMENT);
                curPan.add(buttons.get(PanelRepresentation.EQUAL), Component.CENTER_ALIGNMENT);
                curPan.setVisible(true);
            }
        }
    }

    private JFrame calcFrameInit(){
        JFrame frame = new JFrame("Calc");
        frame.setLayout(new BorderLayout());
        frame.setSize(calcWidth,calcHeight);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }
}