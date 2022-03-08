package com.demo.assignment3;

import com.demo.assignment3.GENE.Genome;
import com.demo.assignment3.GENE.MyGene;

public class GeneClient {

    public static void main(String[] args) {
        try {
            Genome genome = new MyGene("aaagadac");
            System.out.println(genome.Card());

            System.out.println(genome.Clone());
            System.out.println(genome.Clone().getGene());
            System.out.println(genome);

            System.out.println(genome.ConCat(new MyGene("ggg")).getGene());
            System.out.println(genome.getGene());

            System.out.println(genome.Equal(new MyGene("aaagada")));

            System.out.println(genome.Mutate(1.0).getGene());

            System.out.println(genome.OnePointCrossOver(new MyGene("ddddddd"), 2).getGene());
            System.out.println(genome.TwoPointCrossOver(new MyGene("ddddddd"), 2, 4).getGene());

            System.out.println(genome.Inversion().getGene());
            System.out.println(genome.getGene());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
