package com.sadiq;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;


public class Main {



    public static void main(String[] args) {
       // System.out.println("hellow world");

        /*System.out.println("Given Grid:");

        Node sNode = new Node(3,3);
        sNode.inputElement();
        sNode.printGrid();*/
        Scanner sc = new Scanner(System.in);


        System.out.print("Puzzle's Number of Row : ");
        int row = sc.nextInt();

        System.out.print("Puzzle's Number of Coloumn: ");
        int column = sc.nextInt();

        System.out.println("Would you like to input the goal Puzzle(y) or" +
                " like use the defult one(n)   ?");
        System.out.println("Please press 'y' or 'n':");

        String in = sc.next();

        Node fNode = new Node(row, column);

        if (in.equals("y")) {


            System.out.println("Input the element of the Goal Puzzle");
            System.out.println("---------------------------------");


            fNode.inputElement();
            fNode.printGrid();
        }
        else {
            int c = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                   fNode.grid[i][j] =  c;
                   c++;
                }
            }
            fNode.printGrid();
        }

        Node sNode = new Node(row, column);


        System.out.println("Would you like to input the initial Puzzle(y) or" +
                " like to generate Random Puzzle(n)   ?");
        System.out.println("Please press 'y' or 'n':");

        String press = sc.next();
        System.out.println(press);

        if(press.equals("y")){
            System.out.println("Input the element of the initial Puzzle");
            System.out.println("---------------------------------");
            sNode.inputElement();
            sNode.printGrid();
        }
        else
        {
            System.out.println("Generating Random Grid");
            System.out.println("---------------------------------");
            sNode = Node.generateValidRandomGrid(fNode);
            System.out.println("Grid generated successfully");
            sNode.printGrid();


        }

        System.out.println("Finding Solution");

        HashMap<String, Node> visited = Search.Astar(sNode, fNode, HeuristicFunction.THREE);


        int tNode = 0;
        for (String key: visited.keySet()
             ) {
            tNode++;
        }

        System.out.println("Total visited node: "+tNode);


        if (visited.containsKey(fNode.calculateId())) {
            Node temp = visited.get(fNode.calculateId());
            ArrayList<Node> v = new ArrayList<>();
            v.add(fNode);
            System.out.println("Depth: "+temp.depth);


            while (true) {
                Node parent = temp.getParent();
                if (parent == null) {
                    break;
                }
               // parent.printGrid();
                v.add(parent);
                String pid = parent.getId();
                temp = visited.get(pid);
            }

            for (int i = v.size()-1; i >= 0; i--) {
                v.get(i).printGrid();
            }


            if (row == 4 && column ==4) {


              /**  try {
                    for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }*/

                App app = new App(v);
                JFrame frame = new JFrame("15 PUZZLE");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(app.panel1);
                frame.pack();
                frame.setVisible(true);


            }


        }
        else {
            System.out.println("No solution found");
        }

    }
}
