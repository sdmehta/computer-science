package com.demo.COSC2P03.assignment4.src;

import java.util.List;
import java.util.Scanner;

class ShortestPathClient {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int choice = 3;

        do {
            char[][][] matrix =  getMatrix(scanner);
            Graph graph = new Graph(matrix);

            choice = getUserChoice(scanner);

            while (choice == 1 || choice == 2) {
                System.out.println("Finding Solution...\n");

                int cost = graph.getShortestPathCost();

                if (cost == Integer.MAX_VALUE) {
                    System.out.println("Exit not reachable.\n");
                } else {
                    System.out.println("Optimal Path Cost:\t" + cost + "\n");

                    if (choice == 2) {
                        List<Character>  path = graph.getShortestPath();

                        System.out.println("Optimal Path:");
                        for(int i = 0; i < path.size() - 1; i++) {
                            System.out.print(path.get(i) + " -> ");
                        }
                        System.out.println(path.get(path.size()-1) + "\n");
                    }
                }

                choice = getUserChoice(scanner);
            }
        } while (choice == 3);

        System.out.println("Good Bye!");
        scanner.close();
    }

    private static char[][][] getMatrix(Scanner scanner) {
        System.out.print("Enter width: ");
        int w = scanner.nextInt();

        System.out.print("Enter height: ");
        int h = scanner.nextInt();

        System.out.print("Enter depth: ");
        int d = scanner.nextInt();

        char[][][] matrix =  new char[d][h][w];

        System.out.println("Enter maze below. Only rows of width " + w + " will be accepted.");

        for(int l = 0; l < d; l++){
            for(int i = 0; i < h; i++) {
                String line = null;

                do {
                    line = scanner.next();
                    for (int j = 0; j < w; j++) {
                        matrix[l][i][j] = line.charAt(j);
                    }
                } while (line == null || "".equals(line));
            }
        }

        return  matrix;
    }
    private static int getUserChoice(Scanner scanner) {
        System.out.println("1. Estimate optimal solution cost");
        System.out.println("2. Solve optimally");
        System.out.println("3. Enter new puzzle");
        System.out.println("4. Quit");
        System.out.print(":> ");
        return scanner.nextInt();
    }
}
