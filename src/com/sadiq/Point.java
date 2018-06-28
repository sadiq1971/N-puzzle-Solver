package com.sadiq;

public class Point {
    public int x;
    public int y;
    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }

    public  static Point getPoint(int grid[][], int value){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == value){
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

}
