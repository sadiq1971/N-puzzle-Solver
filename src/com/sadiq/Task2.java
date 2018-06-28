package com.sadiq;

import java.util.HashMap;

public class Task2 {

    public static void main(String[] args) {


        //System.out.println(BranchingFactor.solve(18,4));
        //System.out.println(BranchingFactor.bisection(1,4,6,6));


        Node goal = new Node(4,4);
        System.out.println("Input the Final 15-puzzle ");
        goal.inputElement();
        goal.calculateId();

        HeuristicFunction array[] = {HeuristicFunction.ONE,HeuristicFunction.TWO,HeuristicFunction.THREE,
                HeuristicFunction.FOUR};
        float []bf = new float[array.length];
        float []count = new float[array.length];

        for (int i = 0; i < 15; i++) {
            Node initial = Node.generateValidRandomGrid(goal);
            for (int j = 0; j < array.length; j++) {
                //initial.printGrid();
                HashMap<String, Node> visited = Search.Astar(initial,goal,array[j]);
                //System.out.println("Solution found");
                float b = BranchingFactor.calculateBranchingFactor(visited, goal.getId());
                if((int)b != -1){
                    bf[j] += b;
                    count[j]++;
                }

                //System.out.println(bf);

            }
        }
        for (int j = 0; j < array.length; j++) {
            //System.out.println("["+ (int)count[j]+"/15 solution taken]");
            System.out.println("Using h" + (j + 1) + " effective branching factor:" + bf[j] / count[j]+
                    "    ["+ (int)count[j]+"/15 solution taken]");
        }
    }
}
