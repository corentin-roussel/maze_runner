package org.example;

import java.util.Objects;

public class Main {

    public static String checkArgs(String[] args) {
        String format = "Utilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]";

        if(args.length != 4) {
            return "Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.\n" + format;
        }
        if(!checkNumber(args[0]) || !checkNumber(args[1])) {
            return "Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5.\n" + format;
        }
        if(!checkType(args[2]) || !checkType(args[3])) {
            return "Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.\n" + format;
        }
        return "true";
    }

    public static Boolean checkNumber(String nb) {
        try {
            int number = Integer.parseInt(nb);

            if(number < 5) {
                return false;
            }
            return true;

        }catch(NumberFormatException e) {
            return false;
        }

    }

    public static Boolean checkType(String type) {
        if(!type.equals("simple") && !type.equals("perfect") && !type.equals("optimized") && !type.equals("graph") && !type.equals("imperfect")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {


       if(checkArgs(args).equals("true")) {

           try  {
               if(Objects.equals(args[2], "perfect")) {

                   if(Objects.equals(args[3], "simple")) {
                       SimplePerfectMazeGenerator simplePerfect = new SimplePerfectMazeGenerator();
                       simplePerfect.simplePerfect(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                   }
                   if(Objects.equals(args[3], "graph")) {
                       System.out.println("Erreur: Cette fonctionnalité n'est pas disponible pour le moment");
                   }
               }
               if(Objects.equals(args[2], "imperfect")) {
                   if(Objects.equals(args[3], "simple")) {
                        SimpleImperfectMazeGenerator simpleImperfect = new SimpleImperfectMazeGenerator();
                        simpleImperfect.simpleImperfect(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                   }
                   if(Objects.equals(args[3], "graph")) {
                       System.out.println("Erreur: Cette fonctionnalité n'est pas disponible pour le moment");
                   }
               }
           }catch(StackOverflowError | OutOfMemoryError | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
               System.out.println("Erreur inattendue lors de la génération du labyrinthe. Veuillez réessayer.");
           }

       }else {
           System.out.println(checkArgs(args));
       }








    }
}