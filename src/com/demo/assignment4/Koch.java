package com.demo.assignment4;

import BasicIO.BasicForm;
import Media.Turtle;
import Media.TurtleDisplayer;

import static java.lang.Math.PI;

public class Koch {
    Turtle yertle;

    private void koch(int order, double len) {

        double lenDiv =  Math.pow(3, order);
        System.out.println(lenDiv);
int j = 1;

                yertle.forward(len / lenDiv);
                yertle.left(PI / 3);
                yertle.forward(len / lenDiv);
                yertle.right(2 * PI / 3);
                yertle.forward(len / lenDiv);
                yertle.left(PI / 3);
                yertle.forward(len / lenDiv);

                System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going right");
        yertle.right(2 * PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going right");
        yertle.right(2 * PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going right");
        yertle.right(2 * PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going right");
        yertle.right(2 * PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going right");
        yertle.right(2 * PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

        System.out.println("j: " + j++ + " - going left");
        yertle.left(PI / 3);

        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);
        yertle.right(2 * PI / 3);
        yertle.forward(len / lenDiv);
        yertle.left(PI / 3);
        yertle.forward(len / lenDiv);

    }


    private void kochL(int order, double len) {

        double lenDiv =  Math.pow(3, order);
        System.out.println(lenDiv);

        // 1, 4, 16, 64..
        int N = 1;
        while(order-- > 1) N = N * 4;
        System.out.println(N);

        for (int j=1; j <= N; j++) {
                yertle.forward(len / lenDiv);
                yertle.left(PI / 3);
                yertle.forward(len / lenDiv);
                yertle.right(2 * PI / 3);
                yertle.forward(len / lenDiv);
                yertle.left(PI / 3);
                yertle.forward(len / lenDiv);

                for (int p = 0, q = N / 2; q >= 2; p++, q = q / 2) {
                    if (j % q == 0 && p % 2 == 0 ) {
                        System.out.println("j: " + j + " - going right");
                        yertle.right(2 * PI / 3);
                        break;
                    } else if (j % q == 0 && p % 2 != 0 ) {
                        System.out.println("j: " + j + " - going left");
                        yertle.left(PI / 3);
                        break;
                    } else if (j % 2 != 0 ) {
                        System.out.println("j: " + j + " - going left");
                        yertle.left(PI / 3);
                        break;
                    }
                }
/*
            if (j % 32 == 0) {
                System.out.println("j: " + j + " - going right");
                yertle.right(2 * PI / 3);
            }
            else if (j % 16 == 0) {
                System.out.println("j: " + j + " - going left");
                yertle.left(PI / 3);
            }
            else if (j % 8 == 0) {
                System.out.println("j: " + j + " - going right");
                yertle.right(2 * PI / 3);
            }
            else if (j % 4 == 0) {
                    System.out.println("j: " + j + " - going left");
                    yertle.left(PI / 3);
                }
                else if (j % 2 == 0) {
                    System.out.println("j: " + j + " - going right");
                    yertle.right(2 * PI / 3);
                }
                else {
                    System.out.println("j: " + j + " - going left");
                    yertle.left(PI / 3);
                }*/
            }
        }


    private void kochR(int order, double len) {
        if (order == 0) {
            yertle.forward(len);
        } else {
            kochR(order - 1, len / 3);
            yertle.left(PI / 3);

            kochR(order - 1, len / 3);
            yertle.right(2 * PI / 3);

            kochR(order - 1, len / 3);
            yertle.left(PI / 3);

            kochR(order - 1, len / 3);
        }
    }


    public static void main(String[] args) {
        Koch koch = new Koch();
        koch.yertle = new Turtle(0);

        TurtleDisplayer turtleDisplayer =  new TurtleDisplayer(koch.yertle, 800, 800);
        turtleDisplayer.show();

        koch.yertle.penDown();
        koch.kochL(10, 800);


        while(true) {
            turtleDisplayer.waitForUser();
        }
    }
}
