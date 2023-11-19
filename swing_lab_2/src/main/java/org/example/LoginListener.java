package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoginListener implements ActionListener {
    //Główna ramka programu
    private final JFrame frame;
    //Panel logowania, potrzebny do pobrania loginu i hasła
    private LoginPanel loginPanel;

    public void setPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public LoginListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = loginPanel.getName();
        String password = loginPanel.getPassword();
        if (UserValidator.authenticate(name, password)) {
            loginPanel.setText("Logged in");
            return;
        }
        loginPanel.setText("Not logged in !");
    }
}
