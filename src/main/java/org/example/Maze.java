package org.example;

import java.util.*;

public class Maze {

    private final Integer rows;
    private final Integer cols;
    final int UP = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int RIGHT = 3;


    final boolean[][] visited;
    Set<Integer> visitedRow = new HashSet<>();
    Set<Integer> visitedCol = new HashSet<>();


    private final char[][] maze;

    public Maze(int rows, int cols) {
        this.rows = rows * 3;
        this.cols = cols * 3;
        this.maze = new char[this.rows][this.cols];
        this.visited = new boolean[this.rows][this.cols];


        for(int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.maze[i][j] = '#';

            }
            System.out.println();
        }

        /*this.maze[0][1] = '.';*/
        this.maze[this.rows-1][this.cols-2] = '.';

    }



    public void generateMaze() {

        int startCol = 1;
        int startRow = 1;
        int targetRow = -1;
        int targetCol = -2;
        dfs(startCol, startRow, targetRow, targetCol);
    }



    public void dfs(int row, int col, int targetRow, int targetCol) {
        int[] dr = {-3, 3, 0, 0};
        int[] dc = {0, 0, 3, -3};

        List<Integer> directions = Arrays.asList(UP,DOWN,LEFT,RIGHT);

        Collections.shuffle(directions);
        boolean hasValidMove = false;

        for(int dir: directions) {
            int newRow = row + dr[dir];
            int newCol = col + dc[dir];



            if(isValid(newRow, newCol) && !visitedRow.contains(newRow) && !visitedCol.contains(newCol)) {

                visitedCol.add(newCol);
                visitedRow.add(newRow);
                visited[newRow][newCol] = true;
                maze[newRow][newCol] = '.';

                if(newCol == targetCol && newRow == targetRow) {
                    return;
                }

                dfs(newRow, newCol, targetCol,targetRow);

                hasValidMove = true;

            }
        }
        if(!hasValidMove) {

        }
    }

    public Boolean isValid(int row, int col) {
        return row > 0 && row < this.rows && col > 0 && col < this.cols;
    }

    public char[][] getMaze() {
        return maze;
    }


}
