package org.example;

public class Main {
    public static void main(String[] args) {

        int row = 5;
        int col = 5;

        /*public static String checkArgs(String[] args) {

            String format = "Utilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]";
            if(args.length != 4) {
                return "Error : Please use 4 arguments like \n" + format;
            }

            if(args[0] < 5 && args[1] < 5) {

            }
        }*/


        SimplePerfectMazeGenerator simplePerfect = new SimplePerfectMazeGenerator();
        simplePerfect.simplePerfect(row, col);

    }
}