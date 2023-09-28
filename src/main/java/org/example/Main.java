package org.example;

public class Main {
    public static void main(String[] args) {

        int row = 5;
        int col = 5;

        Maze mazeGenerator = new Maze(row, col);
        mazeGenerator.generateMaze();
        mazeGenerator.printMaze();

    }
}