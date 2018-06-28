package com.sadiq;

public class CalculateHFunction extends Distance{

    float heuristicfunc1(int startGrid[][], int finalGrid[][]){
        float hValue = 0;

        for (int i = 0; i < startGrid.length; i++) {
            for (int j = 0; j < startGrid[i].length; j++) {
                if(startGrid[i][j] != 0){
                    if(startGrid[i][j] != finalGrid[i][j]){
                        hValue++;
                    }
                }
            }
        }


        return hValue;
    }

    float heuristicfunc2(int startGrid[][], int finalGrid[][]){
        float hValue = 0;

        for (int i = 0; i < startGrid.length; i++) {
            for (int j = 0; j < startGrid[i].length; j++) {
                if(startGrid[i][j] != 0){

                    hValue += getSqrtDistance(new Point(i, j), Point.getPoint(finalGrid, startGrid[i][j]));
                }
            }
        }


        return hValue;
    }

    float heuristicfunc3(int startGrid[][], int finalGrid[][]){
        float hValue = 0;

        for (int i = 0; i < startGrid.length; i++) {
            for (int j = 0; j < startGrid[i].length; j++) {
                if(startGrid[i][j] != 0){

                    hValue += getManhattanDistance(new Point(i, j), Point.getPoint(finalGrid, startGrid[i][j]));
                }
            }
        }


        return hValue;
    }


    float heuristicfunc4(int startGrid[][], int finalGrid[][]){
        float hValue = 0;

        for (int i = 0; i < startGrid.length; i++) {
            for (int j = 0; j < startGrid[i].length; j++) {
                if(startGrid[i][j] != 0){
                    Point p2 = Point.getPoint(finalGrid, startGrid[i][j]);
                    if(p2.x != i){
                        hValue++;
                    }
                    if(p2.y != j){
                        hValue++;
                    }

                }
            }
        }


        return hValue;
    }
}

