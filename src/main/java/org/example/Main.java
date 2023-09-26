package org.example;

public class Main {
    public static void main(String[] args) {

        int row = 5;
        int col = 5;

        Maze mazeGenerator = new Maze(row, col);
        mazeGenerator.generateMaze();
        char[][] maze = mazeGenerator.getMaze();


        for(int i = 0; i < row * 3;i++) {
            for (int j = 0; j < col * 3;j++) {

                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

    }
}