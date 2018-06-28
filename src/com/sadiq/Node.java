package com.sadiq;


import java.util.Random;
import java.util.Scanner;

public class Node extends CalculateHFunction{
    int[][] grid;
    int row;
    int column;
    float heureisticValue;
    int depth;
    float totalCost;
    String id;
    Node parent;

    public float calculateHeureisticValue(HeuristicFunction htype, int finalGrid[][]) {
        float heureisticValue = 0;

        switch (htype){
            case ONE:{
                heureisticValue = heuristicfunc1(this.grid, finalGrid);
                break;
            }
            case TWO:{
                heureisticValue = heuristicfunc2(this.grid, finalGrid);
                break;
            }
            case THREE:{
                heureisticValue = heuristicfunc3(this.grid, finalGrid);
                break;
            }
            case FOUR:{
                heureisticValue = heuristicfunc4(this.grid, finalGrid);
                break;
            }
            case FIVE:{

            }
        }

        return heureisticValue;
    }


    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setHeureisticValue(float heureisticValue) {
        this.heureisticValue = heureisticValue;
    }

    public float getHeureisticValue() {
        return heureisticValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String calculateId(){
        id="";
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                id = id.concat(String.valueOf(this.grid[i][j]));
            }
        }
        this.id = id;
        return id;
    }

    public Node(int row, int column){
        this.row = row;
        this.column =column;
        grid = new int[row][column];
    }

    public void inputElement(){
        Scanner sc = new Scanner(System.in);
        //System.out.println("Please input the elements of the grid");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nInput taken successfully");

    }

    public void printGrid(){

        String mark = "____";
        for (int i = 0; i < row; i++) {
            System.out.print(" " + mark);
        }

        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print("|");
            for (int j = 0; j < column; j++) {
                if(grid[i][j] == 0){
                    System.out.print("____");
                }

                else if(grid[i][j]<10){
                    System.out.print("_0" + grid[i][j]+ "_");
                }
                else {
                    System.out.print("_"+grid[i][j]+"_");

                }
                System.out.print("|");
            }
            System.out.println();
        }



        System.out.println();
        System.out.println();
    }



    Node move(Move move){
        Node child = new Node(this.row, this.column);

        for (int i = 0; i < child.grid.length; i++) {
            for (int j = 0; j < child.grid[i].length; j++) {
                child.grid[i][j] = this.grid[i][j];
            }
        }



        switch (move){
            case UP:{
                Point p = Point.getPoint(this.grid,0);
                if(p.x == 0){
                    return child;
                }
                else {
                    child.grid[p.x][p.y] = this.grid[p.x-1][p.y];
                    child.grid[p.x-1][p.y] = 0;
                    return child;
                }
            }
            case DOWN:{
                Point p = Point.getPoint(this.grid,0);
                if(p.x == this.row -1){

                    return child;
                }
                else {
                    child.grid[p.x][p.y] = this.grid[p.x + 1][p.y];
                    child.grid[p.x + 1][p.y] = 0;
                    return child;

                }
            }
            case LEFT:{
                Point p = Point.getPoint(this.grid,0);
                if(p.y == 0){
                    return child;
                }
                else {
                    child.grid[p.x][p.y] = this.grid[p.x][p.y - 1];
                    child.grid[p.x][p.y - 1] = 0;
                    return child;


                }
            }
            case RIGHT:{
                //child.printGrid();
                Point p = Point.getPoint(this.grid,0);
                if(p.y == this.column - 1){
                    return child;
                }
                else {
                    child.grid[p.x][p.y] = this.grid[p.x][p.y + 1];
                    child.grid[p.x][p.y + 1] = 0;
                    return child;

                }
            }
        }

        return child;
    }

    boolean isSame(Node node){
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                //System.out.println("this: " + this.grid[i][j] +"    new: "+ node.grid[i][j]);
                if(this.grid[i][j] != node.grid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    public static Node generateValidRandomGrid(Node goal){
        Node temp = goal;
        Move array[] = {Move.RIGHT, Move.LEFT, Move.UP, Move.DOWN};

        for(int i = 0; i < 50; i++){
            Random r = new Random();
            int a = r.nextInt(4);
            temp = temp.move(array[a]);
        }

        return temp;
    }
}
