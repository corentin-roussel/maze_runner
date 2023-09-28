package org.example;

import java.util.*;

public class Maze {

    private final Integer rows;
    private final Integer cols;
    final int UP = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int RIGHT = 3;

    private final int enter;
    private final int exit;

    private final Random random = new Random();


    final boolean[][] visited;


    private final char[][] maze;

    public Maze(int rows, int cols) {
        this.rows = rows * 3;
        this.cols = cols * 3;
        this.maze = new char[this.rows][this.cols];
        this.visited = new boolean[this.rows][this.cols];
        this.enter = 1;
        this.exit = this.maze[this.rows-1][this.cols-2];
        System.out.println(this.enter);


        for(int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.maze[i][j] = '#';
                this.visited[i][j] = false;
            }
        }


        this.maze[0][1] = '.';
        this.maze[this.rows-1][this.cols-2] = '.';
        this.maze[1][1] = '.';
        this.visited[1][1] = true;

    }

    public void printMaze() {
        for(int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.maze[i][j]);
            }
            System.out.println();
        }
    }





    public List<Integer> directions() {


        List<Integer> directions = Arrays.asList(UP,DOWN,LEFT,RIGHT);
        Collections.shuffle(directions);
        return directions;
    }




    public Boolean isValid(int row, int col) {
        return row > 0 && row < this.rows && col > 0 && col < this.cols && !this.visited[row][col];
    }

    public char[][] getMaze() {
        return this.maze;
    }

    public boolean[][] getVisited() {
        return visited;
    }

    public List<Integer> getDirections() {
        return directions();
    }
}
