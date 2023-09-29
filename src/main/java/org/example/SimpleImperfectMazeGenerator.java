package org.example;

import java.util.Random;

public class SimpleImperfectMazeGenerator implements MazeGenerator {

    private Maze maze;


    public void simpleImperfect(int row, int col) {
        this.maze = new Maze(row, col);

        generator(1,1);
        breakWalls();
        maze.printMaze();
    }

    public void generator(int row, int col) {


        int[] dr = {-3, 3, 0, 0};
        int[] dc = {0, 0, 3, -3};

        for (int dir : maze.getDirections()) {
            int newRow = row + dr[dir];
            int newCol = col + dc[dir];


            while(maze.isValid(newRow, newCol)) {


                if (dir == 0) {
                    for (int i = 0; i < 3; i++) {
                        maze.getVisited()[newRow + i][newCol] = true;
                        maze.getMaze()[newRow + i][newCol] = '.';
                    }
                    row -= 3;

                }
                if (dir == 1) {
                    for (int i = 0; i < 3; i++) {
                        maze.getVisited()[newRow - i][newCol] = true;
                        maze.getMaze()[newRow - i][newCol] = '.';
                    }
                    row += 3;
                }
                if (dir == 2) {
                    for (int i = 0; i < 3; i++) {
                        maze.getVisited()[newRow][newCol - i] = true;
                        maze.getMaze()[newRow][newCol - i] = '.';
                    }
                    col += 3;

                }
                if (dir == 3) {
                    for (int i = 0; i < 3; i++) {
                        maze.getVisited()[newRow][newCol + i] = true;
                        maze.getMaze()[newRow][newCol + i] = '.';
                    }
                    col -= 3;
                }

                generator(row,col);

            }

        }
    }

    public void breakWalls() {
        Random random = new Random();


        int count = 0;


        int[] enters = new int[maze.getRows() / 3];
        for (int i = 0; i < enters.length; i++) {
            enters[i] = 1 + i * 3;
        }


        while(count < 1) {
            int row = enters[random.nextInt(1, enters.length)];
            int col = enters[random.nextInt(1, enters.length)];
            for (int dir : maze.getDirections()) {


                if(maze.isValidWalls(row, col)) {


                    if (dir == 0) {
                        if(maze.getMaze()[row+1][col] < maze.getRows() && maze.getMaze()[row+1][col] == '#') {
                            for(int i = 1; i < 3; i++) {
                                maze.getVisited()[row + i][col] = true;
                                maze.getMaze()[row + i][col] = '.';
                            }
                            count+=1;
                            break;
                        }


                    }
                    if (dir == 1) {
                        if(maze.getMaze()[row-1][col] > 0 && maze.getMaze()[row-1][col] == '#') {
                            for(int i = 1; i < 3; i++) {
                                maze.getVisited()[row - i][col] = true;
                                maze.getMaze()[row - i][col] = '.';
                            }
                            count+=1;
                            break;
                        }
                    }
                    if (dir == 2) {
                        if(maze.getMaze()[row][col-1] > 0 && maze.getMaze()[row][col-1] == '#') {
                            for(int i = 1; i < 3; i++) {
                                maze.getVisited()[row][col-i] = true;
                                maze.getMaze()[row][col-i] = '.';
                            }
                            count+=1;
                            break;
                        }

                    }
                    if (dir == 3) {
                        if(maze.getMaze()[row][col+1] < maze.getRows() && maze.getMaze()[row][col+1] == '#') {
                            for(int i = 1; i < 3; i++) {
                                maze.getVisited()[row][col+i] = true;
                                maze.getMaze()[row][col+i] = '.';
                            }
                            count+=1;
                            break;
                        }
                    }

                }else {
                    break;
                }

            }
        }

    }

}
