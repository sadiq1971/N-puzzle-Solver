package com.sadiq;

import java.util.HashMap;

public class BranchingFactor {

    static final float EPSILON = (float)0.01;

    public static float calculateBranchingFactor(HashMap<String, Node> visited, String goalKey){
        if(!visited.containsKey(goalKey)){
            return -1;
        }
        Node temp = visited.get(goalKey);
        int depth = temp.getDepth();
        //System.out.println(depth + ":"+ visited.size());
        return solve(visited.size() + 1,depth + 1);
    }


    static float func(float x,float n,float d)
    {
        return (float) Math.pow(x,d) - x*n + n - 1;
    }

    static float solve(float n, float d){
        float a = 1;
        while (func(a,n,d) < EPSILON){
            a+=EPSILON;
            //System.out.println(a);
        }

        return a;
    }


    static float bisection(float a, float b, float n, float d) {
        if (func(a, n, d) * func(b, n, d) >= 0) {
            System.out.println("You have not assumed" + " right a and b");
            return 1;
        }

        float c = a;
        while ((b - a) >= EPSILON) {
            // Find middle point
            c = (a + b) / 2;

            // Check if middle point is root
            if (func(c, n, d) == 0.0)
                break;

                // Decide the side to repeat the steps
            else if (func(c, n, d) * func(a, n, d) < 0)
                b = c;
            else
                a = c;
        }
        //prints value of c upto 4 decimal places
        //System.out.printf("The value of root is : %.4f");

        return (float) c;
    }

}
