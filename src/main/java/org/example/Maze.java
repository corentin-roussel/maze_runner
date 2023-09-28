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



    public void generateMaze() {


        dfs(1, this.enter);
    }



    public void dfs(int row, int col) {


        int[] dr = {-3, 3, 0, 0};
        int[] dc = {0, 0, 3, -3};

        List<Integer> directions = Arrays.asList(UP,DOWN,LEFT,RIGHT);


        Collections.shuffle(directions);


        for(int dir: directions) {
            int newRow = row + dr[dir];
            int newCol = col + dc[dir];




            while(isValid(newRow, newCol)) {



                if(dir == 0) {
                    for(int i = 0; i < 3;i++) {
                        this.visited[newRow+i][newCol] = true;
                        this.maze[newRow+i][newCol] = '•';
                    }
                    row-=3;

                }
                if(dir == 1) {
                    for(int i = 0; i < 3;i++) {
                        this.visited[newRow-i][newCol] = true;
                        this.maze[newRow-i][newCol] = '•';
                    }
                    row+=3;
                }
                if(dir == 2) {
                    for(int i = 0; i < 3;i++) {
                        this.visited[newRow][newCol-i] = true;
                        this.maze[newRow][newCol-i] = '•';
                    }
                    col+=3;

                }
                if(dir == 3) {
                    for(int i = 0; i < 3;i++) {
                        this.visited[newRow][newCol+i] = true;
                        this.maze[newRow][newCol+i] = '•';
                    }
                    col-=3;
                }

                dfs(row,col);
            }

        }

    }

    public Boolean isValid(int row, int col) {
        return row > 0 && row < this.rows && col > 0 && col < this.cols && !this.visited[row][col];
    }



}
