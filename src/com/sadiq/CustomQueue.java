package com.sadiq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomQueue {
    ArrayList <Node> array;

    public CustomQueue(){
        array = new ArrayList<>();
    }

    public boolean add(Node n){
        return  array.add(n);
    }
    public Node get(int i){
        return array.get(i);
    }

    public Node peek(){
        return array.remove(0);
    }

    boolean isEmpty(){
        return array.isEmpty();
    }

    int getIndex(Node node){
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getId().equals(node.getId())){
                return i;
            }
        }

        return -1;
    }

    void replaceWithLessCost(Node node, int i){
        if(array.get(i).getId().equals(node.getId())){
            if(array.get(i).totalCost > node.totalCost){
                array.remove(i);
                array.add(node);
            }
        }

    }


    public void sort(){
        Collections.sort(array, new Comparator<Node>() {
            @Override
            public int compare(Node lhs, Node rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.totalCost < rhs.totalCost ? -1 : (lhs.totalCost > rhs.totalCost) ? 1 : 0;
            }
        });
    }
}
