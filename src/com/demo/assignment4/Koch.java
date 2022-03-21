package com.demo.assignment4;

import BasicIO.BasicForm;
import Media.Turtle;
import Media.TurtleDisplayer;

import static java.lang.Math.PI;

public class Koch {
    Turtle yertle;


    private void koch(int order, double len) {
        if (order == 0) {
            yertle.forward(len);
        } else {
            koch(order - 1, len / 3);
            yertle.left(PI / 3);

            koch(order - 1, len / 3);
            yertle.right(2 * PI / 3);

            koch(order - 1, len / 3);
            yertle.left(PI / 3);

            koch(order - 1, len / 3);
        }
    }



    public static void main(String[] args) {
        Koch koch = new Koch();
        koch.yertle = new Turtle(0);

        TurtleDisplayer turtleDisplayer =  new TurtleDisplayer(koch.yertle, 300, 300);
        turtleDisplayer.show();

        koch.yertle.penDown();
        koch.koch(10, 300);


        while(true) {

            turtleDisplayer.waitForUser();
        }
    }
}
