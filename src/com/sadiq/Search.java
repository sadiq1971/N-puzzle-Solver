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
        start.printGrid();


        Node temp = start;
        int count = 0;

        while (!temp.getId().equals(goal.getId()) && count < 10000){
            count ++;
            //System.out.println(count);

            Node []child = {temp.move(Move.UP), temp.move(Move.DOWN),
                    temp.move(Move.LEFT), temp.move(Move.RIGHT)};



            for (int i = 0; i < child.length; i++) {

                child[i].calculateId();

                //check wheather the child node is same as parent node temp...
                if(!child[i].getId().equals(temp.getId())){

                    System.out.println("Child : "+ i);
                    child[i].setDepth(temp.depth + 1);
                    child[i].setHeureisticValue(child[i].calculateHeureisticValue(hFunc, goal.grid));
                    child[i].setTotalCost(child[i].getDepth() + child[i].getHeureisticValue());
                    child[i].setParent(temp);
                    child[i].printGrid();
                    System.out.println("Cost: "+ child[i].getTotalCost());

                    //if child is already in openlist (priority queue ) and this child has lower
                    //cost then replace previous child...
                    int index = priorityQueue.getIndex(child[i]);
                    if(index != -1){
                        System.out.println("Already in pq");
                        priorityQueue.replaceWithLessCost(child[i], index);
                    }


                    //if child is in closelist(visited list) and this child has lower cost...
                    else if (visited.containsKey(child[i].getId())){
                        Node duplicate = visited.get(child[i].getId());
                        System.out.println("Already in visited");
                        if(duplicate.getTotalCost() > child[i].getTotalCost()){
                            visited.remove(duplicate.getId());
                            priorityQueue.add(child[i]);
                            System.out.println("Added");
                        }
                    }


                    //child not in visited and not in priority queue...
                    else {
                        priorityQueue.add(child[i]);
                        System.out.println("Not in queue");
                        System.out.println("Added");
                    }

                }
            }



            if(priorityQueue.isEmpty()){
                return visited;
            }

            priorityQueue.sort();
            temp = priorityQueue.peek();
            System.out.println("Removed: ");
            temp.printGrid();
            visited.put(temp.getId(), temp);

        }

        return visited;

    }


}
