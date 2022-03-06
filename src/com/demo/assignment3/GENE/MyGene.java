package com.demo.assignment3.GENE;

import java.util.Random;
import java.util.Stack;

public class MyGene implements Genome, AlphabetInterface {
    private String gene;

    public MyGene(String gene) {
        this.gene = gene;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    @Override
    public int Card() {
        return this.gene.length();
    }

    @Override
    public Genome Clone() {
        return new MyGene(this.gene);
    }

    @Override
    public Genome ConCat(Genome g) {
        return new MyGene(this.gene.concat(g.getGene()));
    }

    @Override
    public boolean Equal(Genome g) {
        return this.gene.equals(g.getGene());
    }

    // Each element of this will randomly mutate to another element of the alphabet
    // if a random variable Pi<p where 0<=Pi<=1 & 0<=p<=1

    // p = 0.6
    // need to generate Pi random number between 0 and 1
    // Pi = 0.5
    // gene = 'abcd', alphabet = select random char for each element from gene.
    @Override
    public Genome Mutate(double p) {
        double pi = Math.random();

        if(pi < p){
            // we need pick char from 0 to length - 1 index from  array.
            Random random = new Random();
            int randomIndex;
            String mutatedGene = "";

            for(int i = 0; i < gene.length(); i++) {
                randomIndex = random.nextInt(alphabet.length);
                mutatedGene.concat(String.valueOf(alphabet[randomIndex]));
            }

            return new MyGene(mutatedGene);
        } else {
            return new MyGene(this.gene);
        }
    }

    // The Genome this is reversed. E.g. A=abcde then A.Inversion() => edcba
    @Override
    public Genome Inversion() {
        char[] c = this.gene.toCharArray();
        char[] newC = new char[c.length];

        for(int i = 0; i<c.length-1; i++){
           newC[i] =  c[c.length-1-i];
        }



        // u need implement string reversal code in single line


        // stack -- continuos adjacent characters
        //Stack - linked list implementation - push, pop, peek

        // STack - java class

        Stack stack = new Stack<>();
        stack.p



        return null;
    }
}
