package com.sadiq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Search {
    public static  HashMap Astar(Node start, Node goal, HeuristicFunction hFunc){
        CustomQueue priorityQueue = new CustomQueue();
        HashMap<String , Node> visited = new HashMap<>();
        start.setHeureisticValue(start.calculateHeureisticValue(hFunc,goal.grid));
        start.setDepth(0);
        start.setTotalCost(start.getDepth() + start.getHeureisticValue());
        start.calculateId();
        visited.put(start.getId(),start);

        goal.calculateId();


        Node temp = start;
        int count = 0;

        while (!temp.getId().equals(goal.getId()) && count<10000){
            count ++;
            //System.out.println(count);

            Node []child = {temp.move(Move.UP), temp.move(Move.DOWN),
                    temp.move(Move.LEFT), temp.move(Move.RIGHT)};
            for (int i = 0; i < child.length; i++) {
                child[i].calculateId();
            }

            Node up = temp.move(Move.UP);
            up.calculateId();

            if(!up.getId().equals(temp.getId())){

                //if the child is in



                //if the child not in open list and close list...
                if(!visited.containsKey(up.getId())) {
                    //System.out.println("Up");
                    //up.printGrid();
                    up.setDepth(temp.depth + 1);
                    up.setHeureisticValue(up.calculateHeureisticValue(hFunc, goal.grid));
                    up.setTotalCost(up.getDepth() + up.getHeureisticValue());
                    up.setParent(temp);
                    priorityQueue.add(up);
                }


            }
            Node down = temp.move(Move.DOWN);
            down.calculateId();

            if(!down.getId().equals(temp.getId())){
                if(!visited.containsKey(down.getId())) {
                    //System.out.println("Down");
                    //down.printGrid();
                    down.setDepth(temp.depth + 1);
                    down.setHeureisticValue(down.calculateHeureisticValue(hFunc, goal.grid));
                    down.setTotalCost(down.getDepth() + down.getHeureisticValue());
                    down.setParent(temp);
                    priorityQueue.add(down);
                }
            }
            Node left = temp.move(Move.LEFT);
            left.calculateId();

            if(!left.getId().equals(temp.getId())){
                if (!visited.containsKey(left.getId())) {
                    //System.out.println("Left");
                    //left.printGrid();
                    left.setDepth(temp.depth + 1);
                    left.setHeureisticValue(left.calculateHeureisticValue(hFunc, goal.grid));
                    left.setTotalCost(left.getDepth() + left.getHeureisticValue());
                    left.setParent(temp);
                    priorityQueue.add(left);
                }
            }

            Node right = temp.move(Move.RIGHT);
            right.calculateId();

            if(!right.getId().equals(temp.getId())){
                if(!visited.containsKey(right.getId())) {
                    //System.out.println("Right");
                    //right.printGrid();
                    right.setDepth(temp.depth + 1);
                    right.setHeureisticValue(right.calculateHeureisticValue(hFunc, goal.grid));
                    right.setTotalCost(right.getDepth() + right.getHeureisticValue());
                    right.setParent(temp);
                    priorityQueue.add(right);
                }
            }


            priorityQueue.sort();
            if(priorityQueue.isEmpty()){
                return visited;
            }
            temp = priorityQueue.peek();
            visited.put(temp.getId(), temp);
            //temp.printGrid();

        }

        return visited;

    }


}
