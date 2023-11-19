package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.example.Panels.panelConfig;

public class AppGui {
    private final JFrame appFrame;
    private final ArrayList<JPanel> panels;
    private final int width = 420, height = 320;
    private final JPasswordField passField = new JPasswordField();
    private final JButton checkButt = new JButton("Generate result");

    public AppGui(){
        appFrame = frameInit();
        panels = panelsInit();
        panelsConfig();
        appFrame.setVisible(true);
    }

    private JFrame frameInit(){
        JFrame frame = new JFrame("Pass check");
        frame.setSize(new Dimension(width, height));
        frame.setLayout(new GridLayout(0,1));
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

    private ArrayList<JPanel> panelsInit(){
        ArrayList<JPanel> panels = new ArrayList<>();
        for(int i=0; i<5; i++){
            if(i == 3)
                panels.add(panelInit(new GridLayout(1,6)));
            if(i == 4)
                panels.add(panelInit(new GridLayout(1,2)));
            else
                panels.add(panelInit(new FlowLayout()));
        }
        return panels;
    }

    private JPanel panelInit(LayoutManager layout){
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBackground(Color.DARK_GRAY);
        appFrame.add(panel);
        panel.setVisible(true);
        return panel;
    }

    private void panelsConfig(){
        for(int i=0; i<panels.size(); i++){
            panelConfig(i, checkButt, passField, panels);
        }
    }

    public static void showResults(int res){
        switch (res){
            case 0 ->{
                JOptionPane.showMessageDialog(null,initRes("Very bad password", Color.red));
            }
            case 1 ->{
                JOptionPane.showMessageDialog(null,initRes("Bad password", Color.orange));
            }
            case 2 ->{
                JOptionPane.showMessageDialog(null,initRes("Not good password", Color.yellow));
            }
            case 3 ->{
                JOptionPane.showMessageDialog(null,initRes("Not bad password", Color.blue));
            }
            case 4 ->{
                JOptionPane.showMessageDialog(null,initRes("Good password", Color.cyan));
            }
            case 5 ->{
                JOptionPane.showMessageDialog(null,initRes("Very good password", Color.green));
            }
        }
    }

    public static JTextArea initRes(String text, Color col){
        JTextArea area = new JTextArea(text);
        area.setBackground(col);
        return area;
    }


}
