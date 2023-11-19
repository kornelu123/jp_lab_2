package org.example;

import javax.swing.*;

public class Math {
    public static int equationResult;
    public static boolean equationStarted = true;
    public static void invokeCalculationOfEquation(JTextField display) {
        String equation = display.getText();
        int operationBufor = 0;
        String[] equationElements = equation.split(" ");
        for (String element : equationElements) {
            switch (element) {
                case "+" -> operationBufor = PanelRepresentation.PLUS;
                case "-" -> operationBufor = PanelRepresentation.MINUS;
                case "*" -> operationBufor = PanelRepresentation.MULTIPLICATION;
                case "/" -> operationBufor = PanelRepresentation.DIVISION;
                default -> equationResult = performCalculations(operationBufor, element);
            }
        }
        display.setText(String.valueOf(equationResult));
        equationStarted = true;

    }

    private static int performCalculations(int op, String possNumber){
        int number = stringToNum(possNumber);

        if(equationStarted){
            equationStarted = false;
            return number;
        }else{
            switch (op){
                case PanelRepresentation.PLUS -> {
                    return equationResult + number;
                }
                case  PanelRepresentation.MINUS -> {
                    return  equationResult - number;
                }
                case PanelRepresentation.MULTIPLICATION -> {
                    return equationResult*number;
                }
                case PanelRepresentation.DIVISION -> {
                    if(number == 0){
                        JOptionPane.showMessageDialog(null, "Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
                        return equationResult;
                    }
                    return equationResult/number;
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Undefined option", "Error", JOptionPane.ERROR_MESSAGE);
                    return  equationResult;
                }
            }
        }
    }

    private static int stringToNum(String num){
        int number;
        try{
            number = Integer.parseInt(num);
            return number;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Not a number", "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }
}
