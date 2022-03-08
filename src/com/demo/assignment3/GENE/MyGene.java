package com.demo.assignment3.GENE;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyGene implements Genome, AlphabetInterface {
    private String gene;

    public MyGene(String gene) throws UsageException {
        for(char c : gene.toCharArray()) {
            int i = 0;
            for(; i < alphabet.length; i++) {
                if(alphabet[i] == c) {
                    break;
                }
            }
            if(i >= alphabet.length){
                throw new UsageException("Elements " + c + " of Genome are not part of alphabet: " + Arrays.asList(alphabet));
            }
        }
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
    public Genome Clone() throws UsageException {
        return new MyGene(this.gene);
    }

    @Override
    public Genome ConCat(Genome g)  throws UsageException {
        return new MyGene(this.gene.concat(g.getGene()));
    }

    @Override
    public boolean Equal(Genome g) {
        return this.gene.equals(g.getGene());
    }

    // Each element of this will randomly mutate to another element of the alphabet
    // if a random variable Pi<p where 0<=Pi<=1 & 0<=p<=1
    @Override
    public Genome Mutate(double p)  throws UsageException {
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

    // The first i elements of this will be prepended to the tail elements of B which
    // contains the elements of B less the first i elements.
    //
    // E.g. A = aaaaa & B=bbbbb then A.OnePointCrossOver(B,2) => aaabb
    // Raises UsageException if A & B are not the same length or i>A.Card().
    public Genome OnePointCrossOver(Genome g, int i) throws UsageException {
        if(this.gene.length() != g.getGene().length()){
            throw new UsageException("Genome length is not same.");
        }

        if(i > this.Card()) {
            throw new UsageException("Index " + i + " is greater than Genome length " + this.gene.length() + ".");
        }

        if(i == this.Card()) {
            return new MyGene(this.gene);
        } else {
            return new MyGene(this.gene.substring(0, i + 1) + g.getGene().substring(i + 1));
        }
    }

    // The elements of this which lye within i & j are substituted with the element
    // that lye within i & j of g.
    //
    // E.g. A=aaaaaa & B=bbbbbb then A.TwoPointCrossOver(B,2,4) => aabbba
    // Raises UsageException if A & B are not the same length or i>j>A.Card().
    public Genome TwoPointCrossOver(Genome g, int i, int j) throws UsageException {
        if(this.gene.length() != g.getGene().length()){
            throw new UsageException("Genome length is not same.");
        }

        if(i > j) {
            throw new UsageException("Start index " + i + " is greater than end index " + j + ".");
        }

        if(j > this.Card()) {
            throw new UsageException("End index " + j + " is greater than Genome length " + this.gene.length() + ".");
        }

        return new MyGene(this.gene. substring(0, i) + g.getGene().substring(i, j+1) + this.gene. substring(j+1));
    }

    // The Genome this is reversed. E.g. A=abcde then A.Inversion() => edcba
    @Override
    public Genome Inversion()  throws UsageException {
        char[] c = this.gene.toCharArray();
        String newGene = "";
        for(int i = c.length - 1; i >= 0; i--) {
           newGene = newGene + c[i];

        }
        return  new MyGene(newGene);
    }
}
