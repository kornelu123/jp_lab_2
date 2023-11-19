package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.example.AppGui.initRes;
import static org.example.AppGui.showResults;
import static org.example.Password.evaluatePasswdStrength;

public class Panels {
    public final static int PASSWD_DISP = 0;
    public final static int HINT = 1;
    public final static int SCALE_INFO = 2;
    public final static int PASSWD_SCALE = 3;
    public final static int BUTTONS  = 4;
    public static void panelConfig(int num, JButton genBut, JPasswordField passwordField, ArrayList<JPanel> panels){
        JPanel curPan = panels.get(num);
        switch(num){
            case HINT -> {
                curPan.add(new JTextArea("""
                      To make strong password your password should:
                      - Be unique
                      - length should be more than 8 signs
                      - contain big and small letters, digits and specials signs
                      """),BorderLayout.WEST);
                curPan.getComponent(0).setBackground(Color.LIGHT_GRAY);
            }
            case PASSWD_DISP -> {
                curPan.add(new JLabel("Type in password: "));
                passwordField.setPreferredSize(new Dimension(240, 20));
                curPan.add(passwordField);
            }
            case  BUTTONS -> {
                curPan.add(genBut);
                genBut.setBackground(Color.CYAN);
                genBut.addActionListener(e -> {
                    int res = evaluatePasswdStrength(passwordField.getPassword());
                    showResults(res);
                });
            }
            case PASSWD_SCALE -> {
                curPan.add(initRes("Very bad", Color.RED));
                curPan.add(initRes("Bad", Color.orange));
                curPan.add(initRes("Not good", Color.yellow));
                curPan.add(initRes("Not bad", Color.blue));
                curPan.add(initRes("Good", Color.cyan));
                curPan.add(initRes("Very good", Color.green));
            }
            case SCALE_INFO -> {
                curPan.add(new JLabel("Scale of password strength: "), Component.BOTTOM_ALIGNMENT);
            }
        }
    }
}
