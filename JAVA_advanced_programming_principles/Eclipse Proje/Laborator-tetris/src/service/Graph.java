package service;

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph  {
    private int nrNoduri;
    private LinkedList<Integer> listeAdiacente[]; // Array of lists for Adjacency List Representation

    // Constructor
    public Graph(Integer nrNoduri) {
        this.nrNoduri = nrNoduri;
        listeAdiacente = new LinkedList[nrNoduri];
        for (int i = 0; i < nrNoduri; i++)
            listeAdiacente[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    public void addMuchie(int v, int w) {
        listeAdiacente[v].add(w);
    }

    // A function used by DFS
    private void DFSUtil(int vârf, boolean vizitat[]) {
        // Mark the current node as visited
        vizitat[vârf] = true;
        System.out.print(vârf + " ");

        // Recur for all the vertices adjacent to this vertex
        for (Integer i : listeAdiacente[vârf]) {
            if (!vizitat[i])
                DFSUtil(i, vizitat);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(int vârf) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean vizitat[] = new boolean[this.nrNoduri];
        // Call the recursive helper function to print DFS traversal
        DFSUtil(vârf, vizitat);
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addMuchie(0, 1);
        g.addMuchie(0, 2);
        g.addMuchie(1, 2);
        g.addMuchie(2, 0);
        g.addMuchie(2, 3);
        g.addMuchie(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}