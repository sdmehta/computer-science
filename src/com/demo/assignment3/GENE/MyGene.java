package com.demo.assignment3.GENE;

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
    public boolean Equal(Genome g) {
        return this.gene.equals(g);
    }
}
