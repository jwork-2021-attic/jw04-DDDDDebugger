package com.maze;

import java.util.Stack;

public class MazeGenerator {
    private final int width = 10;
    private final int height = 10; 
    private int[][] cells;
    private Stack<Cell> stack= new Stack<>();

    MazeGenerator(){
        cells = new int[width][height];
    }
}

class Cell{
    final int x;
    final int y;
    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}