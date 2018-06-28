package com.sadiq;

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


        System.out.println("Input the element of the Goal Puzzle");
        System.out.println("---------------------------------");

        Node fNode = new Node(row,column);
        fNode.inputElement();

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



        if (visited.containsKey(fNode.calculateId())) {
            Node temp = visited.get(fNode.calculateId());
            ArrayList<Node> v = new ArrayList<>();
            v.add(fNode);


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

        }
        else {
            System.out.println("No solution found");
        }

    }
}
