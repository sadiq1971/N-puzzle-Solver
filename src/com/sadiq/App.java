package com.sadiq;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class App {
    public JPanel panel1;
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    public JButton b8;
    public JButton b7;
    public JButton b6;
    public JButton b5;
    public JButton b12;
    public JButton b16;
    public JButton b11;
    public JButton b15;
    public JButton b14;
    public JButton b10;
    public JButton b9;
    public JButton b13;
    public JButton prevButton;
    public JButton nextButton;

    public JButton [] buttons = {b1, b2, b3, b4
    ,b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16};

    public int  state = 0;

    public App(ArrayList<Node> list) {

        state = list.size() -1;

        int c = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4; j++) {


                if(list.get(state).grid[i][j] == 0){
                    buttons[c].setBackground(Color.CYAN);
                    buttons[c].setText("");
                }
                else {
                    buttons[c].setBackground(Color.WHITE);
                    buttons[c].setText(String.valueOf(list.get(state).grid[i][j]));

                }
                c++;
            }
        }





        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(state < 0){state = 0;}
                if(state > list.size()-1){state = list.size()-1;}

                if(state >= 0) {
                    int c = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {

                            if(list.get(state).grid[i][j] == 0){
                                buttons[c].setBackground(Color.CYAN);
                                buttons[c].setText("");

                            }
                            else {
                                buttons[c].setBackground(Color.WHITE);
                                buttons[c].setText(String.valueOf(list.get(state).grid[i][j]));
                            }
                            c++;
                        }
                    }
                }
                state--;

            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(state < 0){state = 0;}
                if(state > list.size()-1){state = list.size()-1;}

                if(state < list.size()) {
                    int c = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {

                            if(list.get(state).grid[i][j] == 0){
                                buttons[c].setBackground(Color.CYAN);
                                buttons[c].setText("");

                            }
                            else {
                                buttons[c].setBackground(Color.WHITE);
                                buttons[c].setText(String.valueOf(list.get(state).grid[i][j]));
                            }
                            c++;
                        }
                    }
                }
                state++;

            }
        });



    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void action(ArrayList<Node> list) {



    }

}
