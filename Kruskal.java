package A2;
import java.util.*;

public class Kruskal{

	
    public static WGraph kruskal(WGraph g){
    		WGraph graph = new WGraph();
    		ArrayList <Edge> edges = g.listOfEdgesSorted();
    		DisjointSets d = g.translate();
    		for (Edge e: edges)
    		{
    			if (IsSafe(d, e)) 
    			{ 
    				graph.addEdge(e);
    				d.union(e.nodes[0], e.nodes[1]);
    			}
    		}
    		return graph;
    	
    	/* Fill this method (The statement return null is here only to compile) */
        
        
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){
    		if(p.find(e.nodes[0]) == p.find(e.nodes[1]))
    		{
    			return false;
    		}
        
        return true;
    
    }

    public static void main(String[] args){

        String file = args[0];//"/Users/nathalieraffray/Documents/Comp251/A2/A2/src/A2/g1.txt";
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
