package org.example;

import javax.swing.*;
import java.util.ArrayList;

import static org.example.Math.invokeCalculationOfEquation;

public class Buttons {
    public static ArrayList<JButton> buttonsInit() {
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buttons.add(i, new JButton(String.valueOf(i)));
        }
        buttons.add(PanelRepresentation.PLUS ,new JButton("+"));
        buttons.add(PanelRepresentation.MINUS ,new JButton("-"));
        buttons.add(PanelRepresentation.MULTIPLICATION ,new JButton("*"));
        buttons.add(PanelRepresentation.DIVISION ,new JButton("/"));
        buttons.add(PanelRepresentation.EQUAL ,new JButton("="));

        return buttons;
    }

    public static void listenerButtonsInit(JTextField display, ArrayList<JButton> buttons){
        for(int i=0; i<buttons.size(); i++){
            listenerButtonInit(i, display, buttons);
        }
    }

    private static void listenerButtonInit(int number, JTextField display, ArrayList<JButton> buttons){
        JButton button = buttons.get(number);
        if(number >= 0 && number <= 9){
            button.addActionListener(e -> display.setText(display.getText() + number));
        }else{
            button.addActionListener(e-> {
                switch (number){
                    case PanelRepresentation.PLUS -> display.setText(display.getText() + " + ");
                    case PanelRepresentation.MINUS -> display.setText(display.getText() + " - ");
                    case PanelRepresentation.MULTIPLICATION -> display.setText(display.getText() + " * ");
                    case PanelRepresentation.DIVISION -> display.setText(display.getText() + " / ");
                    case PanelRepresentation.EQUAL -> invokeCalculationOfEquation(display);
                }
            });
        }
    }
}
