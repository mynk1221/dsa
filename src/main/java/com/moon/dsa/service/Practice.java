package com.moon.dsa.service;

import java.util.*;

public class Practice {
    public int[] dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adjList.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.getNode();
            int currW = pair.getWeight();
            for (int i = 0; i < adjList.get(node).size(); i++) {
                Pair nPair = adjList.get(node).get(i);
                int nNode = nPair.getNode();
                int weight = nPair.getWeight();
                if (weight + currW < dist[nNode]) {
                    dist[nNode] = weight + currW;
                    pq.add(new Pair(nNode, dist[nNode]));
                }
            }
        }
        return dist;
    }
}


