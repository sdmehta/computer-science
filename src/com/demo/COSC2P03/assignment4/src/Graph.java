package com.demo.COSC2P03.assignment4.src;

import java.util.*;

public class Graph {
    private List<Pair>[] adjList;
    private boolean[] vis;

    private int numberOfLayers;
    private int numberOfRows;
    private int numberOfCols;
    private int numberOfNodes;

    private int s;
    private int d;

    private int[] dist;
    private int[] parents;

    private boolean isCalculated;

    private class Pair {
        int v;
        int w;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private class CummulativePair implements  Comparable<CummulativePair> {
        int w;
        int u;

        CummulativePair(int w, int u) {
            this.w = w;
            this.u = u;
        }

        @Override
        public int compareTo(CummulativePair other) {
            return this.w - other.w;
        }
    }

    public Graph(char[][][] input) {
        numberOfLayers = input.length;
        numberOfRows = input[0].length;
        numberOfCols = input[0][0].length;
        numberOfNodes = numberOfLayers * numberOfRows * numberOfCols;


        adjList = new ArrayList[numberOfNodes + 1];
        vis = new boolean[numberOfNodes + 1];

        for (int i = 1; i <= numberOfNodes; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int l = 0; l < numberOfLayers; l++) {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfCols; j++) {
                    int node1 = l * numberOfRows * numberOfCols +  i * numberOfCols + j + 1;
                    int node2;

                    if (input[l][i][j] == 'X') continue;


                    if (input[l][i][j] == 'S')
                        s =  (l * numberOfRows * numberOfCols) + (i * numberOfCols) + j + 1;

                    if (input[l][i][j] == 'E')
                        d =  (l * numberOfRows * numberOfCols) + (i * numberOfCols) + j + 1;

                    // north
                    if (i > 0 && input[l][i - 1][j] != 'X') {
                        node2 =  (l * numberOfRows * numberOfCols) + ((i - 1) * numberOfCols) + j + 1;
                        adjList[node1].add(new Pair(node2, 1));
                    }

                    // south
                    if (i < numberOfRows - 1 && input[l][i + 1][j] != 'X') {
                        node2 =  (l * numberOfRows * numberOfCols) + ((i + 1) * numberOfCols) + j + 1;
                        adjList[node1].add(new Pair(node2, 1));
                    }

                    // East
                    if (j < numberOfCols - 1 && input[l][i][j + 1] != 'X') {
                        node2 =  (l * numberOfRows * numberOfCols) + (i * numberOfCols) + (j + 1) + 1;
                        adjList[node1].add(new Pair(node2, 1));
                    }

                    // West
                    if (j > 0 && input[l][i][j - 1] != 'X') {
                        node2 =  (l * numberOfRows * numberOfCols) + (i * numberOfCols) + (j - 1) + 1;
                        adjList[node1].add(new Pair(node2, 1));
                    }

                    // up
                    if (l > 0 && input[l-1][i][j] != 'X') {
                        node2 =  ((l-1) * numberOfRows * numberOfCols) + (i * numberOfCols) + j + 1;
                        adjList[node1].add(new Pair(node2, 1));
                    }

                    // down
                    if (l < numberOfLayers - 1 && input[l+1][i][j] != 'X') {
                        node2 =  ((l+1) * numberOfRows * numberOfCols) + (i * numberOfCols) + j + 1;
                        adjList[node1].add(new Pair(node2, 1));
                    }
                }
            }
        }
    }

    /**
     * Dijkstra's Algorth - Shorted path finding
     * @param s
     * @param d
     * @return
     */
    private boolean shortedPath() {
        // step 1  - create dist array
        dist = new int[numberOfNodes + 1];
        parents = new int[numberOfNodes + 1];

        for(int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            parents[i] =  Integer.MAX_VALUE;
        }


        //step 2 - create min Heap
        PriorityQueue<CummulativePair> minHeap = new PriorityQueue<>();

        dist[s] = 0;
        parents[s] = s;
        minHeap.add(new CummulativePair(0, s));

        while(!minHeap.isEmpty()) {
            CummulativePair curPair = minHeap.poll();
            int curV = curPair.u;
            int curW = curPair.w;

            if (curW == dist[curV]) {
                for (Pair adjPair : adjList[curV]) {
                    int adjU = adjPair.v;
                    int adjW = adjPair.w;
                    if (dist[curV] + adjW < dist[adjU]) {
                        dist[adjU] = dist[curV] + adjW;
                        parents[adjU] = curV;
                        minHeap.add(new CummulativePair(dist[adjU], adjU));
                    }
                }
            }
        }

        return dist[d] != Integer.MAX_VALUE ? true : false;
    }

    public int getShortestPathCost() {
        if (!isCalculated) shortedPath();
        return dist[d];
    }

    public List<Character> getShortestPath() {
        if (!isCalculated) shortedPath();
        List<Character> path = new ArrayList<>();

        if(dist[d] == Integer.MAX_VALUE)
            return path;

        int i = d;

        while(parents[i] != i) {
            int parent = parents[i];

            if(i - parent == -numberOfCols) path.add('N'); // north
            if(i - parent == numberOfCols) path.add('S'); // south
            if(i - parent  == 1) path.add('E'); // east
            if(i - parent  == -1) path.add('W'); // west
            if(i - parent  == numberOfCols * numberOfRows * -1) path.add('U'); // up
            if(i - parent  == numberOfCols * numberOfRows) path.add('D'); // down

            i = parent;
        }

        Collections.reverse(path);
        return  path;
    }
}
