package com.demo.assignment3.GENE;

public interface Genome {

    public String getGene();

    public void setGene(String gene);

    // Returns the cardinality of this.
    public int Card();

    // Creates a clone object of this
    public Genome Clone()  throws UsageException ;

    // Concatenate this and g, this = this + g;
    public Genome ConCat(Genome g)  throws UsageException ;

    // Returns true if this and g are the same
    public boolean Equal(Genome g);


    // Each element of this will randomly mutate to another element of the alphabet
    // if a random variable Pi<p where 0<=Pi<=1 & 0<=p<=1
    public Genome Mutate(double p) throws UsageException ;


    // The first i elements of this will be prepended to the tail elements of B which
    // contains the elements of B less the first i elements.
    //
    // E.g. A = aaaaa & B=bbbbb then A.OnePointCrossOver(B,2) => aaabb
    // Raises UsageException if A & B are not the same length or i>A.Card().
    public Genome OnePointCrossOver(Genome g, int i) throws UsageException;

    // The elements of this which lye within i & j are substituted with the element
    // that lye within i & j of g.
    //
    // E.g. A=aaaaaa & B=bbbbbb then A.TwoPointCrossOver(B,2,4) => aabbba
    // Raises UsageException if A & B are not the same length or i>j>A.Card().
    public Genome TwoPointCrossOver(Genome g, int i, int j) throws UsageException;

    // The Genome this is reversed. E.g. A=abcde then A.Inversion() => edcba
    public Genome Inversion() throws UsageException ;
}
