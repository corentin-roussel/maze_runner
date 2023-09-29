package org.example;

public class SimplePerfectMazeGenerator implements MazeGenerator {

    private Maze maze;


    public void simplePerfect(int row, int col) {
        this.maze = new Maze(row, col);

        generator(1,1);
        maze.printMaze();
    }

    public void generator(int row, int col) {


        int[] dr = {-3, 3, 0, 0};
        int[] dc = {0, 0, 3, -3};

        for (int dir : maze.getDirections()) {
            int newRow = row + dr[dir];
            int newCol = col + dc[dir];


            if (maze.isValid(newRow, newCol)) {


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
}
