package com.demo.assignment4;

import Media.Turtle;
import Media.TurtleDisplayer;

import static java.lang.Math.PI;

public class KochCurve {

    Turtle yertle;

    private void branch(int order, double len) {
        if(order == 0) {

            return;
        }
        branch(order - 1, len / 2);
        yertle.forward(len);
        yertle.right(PI / 4);
        branch(order - 1, len / 3);
        yertle.left(PI / 4);
        yertle.backward(len);
    }

    public static void main(String[] args) {
        KochCurve koch = new KochCurve();
        koch.yertle = new Turtle(0);

        TurtleDisplayer turtleDisplayer =  new TurtleDisplayer(koch.yertle, 400, 400);
        turtleDisplayer.show();

        koch.yertle.penDown();
        koch.branch(10, 100);


        while(true) {
            turtleDisplayer.waitForUser();
        }

    }
}
