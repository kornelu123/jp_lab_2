package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.example.ContactSet.*;

public class AppGui {
    private JFrame frame;
    private JPanel inputPan = new JPanel(), outputPan = new JPanel(), buttonPan = new JPanel();

    private JScrollPane scroll;
    private int width = 1000, height = 700;
    private Dimension scrollDim = new Dimension(600,300);
    private final ArrayList<JTextField> fields = new ArrayList<>();

    public AppGui(){
        frame = initFrame("Contact list", new Dimension(width,height), new BorderLayout());
        panelsConfig();
        frame.setVisible(true);
    }

    private JFrame initFrame(String text, Dimension dim, LayoutManager manager){
        frame = new JFrame(text);
        frame.setSize(dim);
        frame.setLayout(manager);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.MAGENTA);
        return frame;
    }

    private void panelsConfig(){
        inputPan.setLayout(new GridLayout(1,5));
        inputPan.setBackground(Color.GRAY);
        inputPan.add(new JLabel("Name :"));
        inputPan.getComponent(0).setPreferredSize(new Dimension(scrollDim.width/10, 25));
        inputPan.add(new JLabel("Number :"));
        inputPan.getComponent(1).setPreferredSize(new Dimension(scrollDim.width/5+5, 25));
        inputPan.add(new JLabel("Mail :"));
        inputPan.getComponent(2).setPreferredSize(new Dimension(scrollDim.width/5+5, 25));
        inputPan.add(new JLabel(""));
        inputPan.getComponent(3).setPreferredSize(new Dimension(scrollDim.width/5*2, 25));

        outputPan.setLayout(new BoxLayout(outputPan,BoxLayout.PAGE_AXIS));
        outputPan.setBackground(Color.white);
        outputPan.setSize(scrollDim);

        scroll = new JScrollPane(outputPan, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBackground(Color.WHITE);

        buttonPan.setSize(new Dimension(width,height/8));
        buttonPan.setLayout(new BorderLayout());
        buttonPan.add(addButtonSetUp());


        frame.add(inputPan, BorderLayout.NORTH);
        frame.add(buttonPan, BorderLayout.SOUTH);
        frame.add(scroll, BorderLayout.CENTER);

        inputPan.setVisible(true);
        outputPan.setVisible(true);
        buttonPan.setVisible(true);
        scroll.setVisible(true);
        }
    private JButton addButtonSetUp() {
        JButton addButton = new JButton("Add new contact to the list");
        addButton.setBackground(Color.GRAY);
        addButton.addActionListener(e -> {
            dataSheetInit("","","");
        });
        return addButton;
    }
        public void dataSheetInit(String nameVal, String numVal, String mailVal){
            JFrame frame = initFrame("Contact list",new Dimension(scrollDim.width, scrollDim.height/2-30), new FlowLayout());
            JButton saveBut = new JButton("Save data");
            fields.add(0,appendLine(frame, "Name :" + nameVal));
            fields.add(1,appendLine(frame, "Number :" + numVal));
            fields.add(2,appendLine(frame, "Mail :" + mailVal));
            frame.add(saveBut);
            saveBut.addActionListener(e -> {
                addDataToContact();
                frame.dispose();
            });
            frame.setVisible(true);
        }
        private void addDataToContact(){
            JPanel panel = createPanelWithData();
            panel.setBackground(Color.GRAY);
            outputPan.add(panel);
            outputPan.repaint();
            outputPan.revalidate();
        }
          private JPanel createPanelWithData() {
                JButton edit = new JButton("Edit"), remove = new JButton("Remove");
                JPanel panel = new JPanel(new GridLayout(1,5));
                for (int i = 0; i < 3; i++) {
                    if (!fields.get(i).getText().equals(""))
                        panel.add(new JLabel(fields.get(i).getText(), SwingConstants.CENTER));
                    else
                        panel.add(new JLabel("Not specified"));
                }
                edit.setBackground(Color.green);
                edit.addActionListener(e -> {
                    removalOfPanel(panel);
                    dataSheetInit(fields.get(0).getText(), fields.get(1).getText(), fields.get(2).getText());
                });

                remove.setBackground(Color.red);
                remove.addActionListener(e -> {
                    removalOfPanel(panel);
                });

                panel.add(edit);
                panel.add(remove);
                return panel;
          }

        private JTextField appendLine(JFrame baseFrame, String text){
            JTextField field = new JTextField();
            field.setPreferredSize(new Dimension(scrollDim.width/2+100, scrollDim.height/11-15));
            baseFrame.add(new JLabel(text));
            baseFrame.add(field);
            return field;
        }



    private void removalOfPanel(JPanel panelToRemove) {
        if (panelToRemove != null)
            outputPan.remove(panelToRemove);
        scroll.repaint();
        scroll.revalidate();
    }


}
