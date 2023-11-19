package org.example;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class LoginPanel extends JPanel {
    private JTextField nameField;
    private JPasswordField passField;
    private JButton loginButton;
    private JButton colorButton;
    private JButton sizeButton;
    private LoginListener listener;
    private JTextField    textField;
    private JPanel        outputPanel;

    public String getName() {
        return nameField.getText();
    }

    public String getPassword() {
        String password = "";
        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    public LoginPanel(LoginListener listener) {
        super();
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        this.listener = listener;
        this.listener.setPanel(this);
        createComponents();
    }

    private void initButtons(){
        colorButton = new JButton("Change color");
        colorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer ans = JOptionPane.showOptionDialog(null, "Select color", "Color selector", 0, JOptionPane.QUESTION_MESSAGE, null, new String[]{"red", "green", "white"}, "red");
                switch(ans){
                    case 0:{
                        setBackground(Color.red);
                        break;
                    }
                    case 1:{
                        setBackground(Color.green);
                        break;
                    }
                    case 2:{
                        setBackground(Color.white);
                        break;
                    }
                }
            }
        });

        sizeButton = new JButton("Change size");
        sizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer ans = JOptionPane.showOptionDialog(null, "Select color", "Color selector", 0, JOptionPane.QUESTION_MESSAGE, null, new String[]{"small", "medium", "big"}, "red");
                switch(ans){
                    case 0:{
                        outputPanel.setSize(new Dimension(400, 100));
                        sizeButton.setSize(new Dimension(100/3,20));
                        colorButton.setSize(new Dimension(100/3, 20));
                        textField.setSize(new Dimension(100/3, 20));
                        repaint();
                        break;
                    }
                    case 1:{
                        outputPanel.setSize(new Dimension(400,200));
                        sizeButton.setSize(new Dimension(200/3,20));
                        colorButton.setSize(new Dimension(200/3, 20));
                        textField.setSize(new Dimension(200/3, 20));
                        repaint();
                        break;
                    }
                    case 2:{
                        outputPanel.setSize(new Dimension(400 , 200));
                        sizeButton.setSize(new Dimension(300/3,20));
                        colorButton.setSize(new Dimension(300/3, 20));
                        textField.setSize(new Dimension(300/3, 20));
                        repaint();
                        break;
                    }
                }
            }
        });
    }

    private void createComponents() {

        JPanel parentPanel = new JPanel();
        JLabel name = new JLabel("Name: ");
        JLabel password = new JLabel("Password: ");
        nameField = new JTextField();
        passField = new JPasswordField();

        JLabel u_name = new JLabel("Welcome " + JOptionPane.showInputDialog("Type in your name"));
        JPanel inputPanel = new JPanel();
        inputPanel.add(u_name);
        inputPanel.setLayout(new GridLayout(2,1));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passField);
        loginButton = new JButton("Zaloguj");
        loginButton.addActionListener(listener);



        textField = new JTextField();
        outputPanel = new JPanel();
        outputPanel.setLayout(new GridLayout(1,3));
        outputPanel.add(textField);
        outputPanel.setOpaque(true);

        initButtons();

        outputPanel.add(sizeButton);
        outputPanel.add(colorButton);
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.NORTH);
        parentPanel.add(loginButton, BorderLayout.CENTER);
        parentPanel.add(outputPanel, BorderLayout.SOUTH);

        this.add(parentPanel);
    }

    public void setText(String text){
        textField.setText(text);
    }
}