package algorithm_analysis_exer;

import java.io.*;
import java.util.*;

public class Min_cut_algo_exer {

	// graph class	
	private static class Graph{
		// TreeMap sorted by natural comparison
		// A final class cannot be subclassed.
		// Doing this can confer security and efficiency benefit 
		private final Map<Integer, Vertex> vertices = new TreeMap<Integer, Vertex>( new Comparator<Integer>(){
			//for pretty printing
			// override the compare method in Comparator class.
			@Override
			public int compare( Integer arg0, Integer arg1 ) {
				return arg0.compareTo( arg1 );
			}			
		});

		private final List<Edge> edges = new ArrayList<Edge>();

		public void addVertex( Vertex v ){
			vertices.put( v.lbl, v);
		}

		// if no Vertex lbl, then create it , save it in vertices
		// and return it
		public Vertex getVertex( int lbl ) {
			Vertex v;
			if( ( v = vertices.get( lbl )) == null ) {
				v = new Vertex( lbl );
				addVertex( v );
			}
			return v;
		} 
	}

	// vertex class
	private static class Vertex{
		private final int lbl;
		// set edges, no duplicates
		// entry in this set is Edge object
		private final Set<Edge> edges = new HashSet<Edge>(); 
		public Vertex( int lbl){
			this.lbl = lbl;
		}
		// add an edge associated with this Vertex into its edge set
		public void addEdge( Edge edge){
			edges.add(edge);
		}
		// find the edge of this vertex, which ends to Vertex v2
		public Edge getEdgeTo( Vertex v2){
			for(Edge edge : edges){
				if(edge.contains(this, v2))
					return edge;
			}
			return null;
		}
	}

	// Edge Class
	private static class Edge{		
		// entry in this List is Vertex object, which are two ends of this edge object
		private final List<Vertex> ends = new ArrayList<Vertex>();
		public Edge(Vertex fst, Vertex snd){
			if(fst == null || snd == null){
				throw new IllegalArgumentException("Both vertices are required");
			}
			ends.add( fst );
			ends.add( snd );
		}

		// check if this edge is the edge of v1 and v2
		public boolean contains( Vertex v1, Vertex v2){
			return (ends.contains( v1 ) && ends.contains( v2 ));
		}

		// return the other vertex of v in this edge
		public Vertex getOppositeVertex(Vertex v){
			if (!ends.contains(v)){
				throw new IllegalArgumentException("No Vertex " + v.lbl);			
			}
			return ends.get(1-ends.indexOf(v));
		}

		public void replaceVertex( Vertex oldV, Vertex newV) {
			if( !ends.contains( oldV )){
				throw new IllegalArgumentException("No Vertex " + oldV.lbl );
			}
			ends.remove( oldV );
			ends.add( newV );
		}
	}


	public static void main(String[] args) {
		int [][] arr = getArray("kargerMinCut.txt");
		Map<Integer, Integer> statistics = new LinkedHashMap<Integer, Integer>();

		int min = arr.length; // set the initial min-cut value.
		int iter = arr.length*arr.length; // repeat n^2 times
		for (int i = 0; i< iter; i++){
			Graph gr = createGraph(arr);

			//printGraph( gr );
			int currMin = minCut( gr );
			min = Math.min( min, currMin );
			Integer counter;
            if( ( counter = statistics.get( currMin ) ) == null ) {
                counter = 0;
            }
            statistics.put( currMin, counter+1 );
		}
		System.out.println( "Min: " + min + " stat: " + (statistics.get( min )*100/iter) + "%" );	
	}

	public static int[][] getArray(String relPath){

		Map<Integer, List<Integer>> vertices = new LinkedHashMap<Integer, List<Integer>>();

		//Convenience class for reading character files. The constructors of 
		//this class assume that the default character encoding and the default
		//byte-buffer size are appropriate.
		FileReader fr;
		try{
			// readin by lines and save data in LinkedHashMap,
			// key is vertice and value list represents the edges
			fr = new FileReader(relPath);
			//»º´æÇø£ºBuffer
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine())!=null){
				String[] split = line.trim().split("(\\s)+");
				List<Integer> adjList = new ArrayList<Integer>();
				for(int i = 1; i < split.length; i++){
					adjList.add(Integer.parseInt(split[i]) -1 );
				} // start from vertice 0, instead of 1.
				vertices.put(Integer.parseInt(split[0])-1, adjList);			 
			}
			fr.close();
		} catch (Exception e){
			e.printStackTrace();			
		}
		// re-save data in a jagged 2-D array, each row is a vertex.
		int [][] array = new int[vertices.size()][]; //jagged array
		for (Map.Entry<Integer, List<Integer>> entry : vertices.entrySet()){
			List<Integer> adjList = entry.getValue();
			int[] adj = new int[adjList.size()];
			for( int i = 0; i < adj.length; i++){
				adj[i] = adjList.get(i);
			}
			array[entry.getKey()] = adj;
		}
		return array;
	}

	public static Graph createGraph(int[][] array){
		Graph gr = new Graph();
		for (int i = 0; i < array.length; i++){
			// create "from" Vertex in each interation
			Vertex v = gr.getVertex( i );
			for (int edgeTo : array[i]){
				// create "to" Vertex in each interation
				Vertex v2 = gr.getVertex(edgeTo);
				Edge e;
				if( ( e = v2.getEdgeTo(v)) == null ){
					e = new Edge( v, v2 );
					gr.edges.add(e);
					v.addEdge(e);
					v2.addEdge(e);
				}
			}
		}
		return gr;
	}

	public static int minCut(Graph gr){

		Random rnd = new Random();

		while( gr.vertices.size() > 2){
			Edge edge = gr.edges.remove(rnd.nextInt(gr.edges.size()));
			// remove v1,v2 from graph, remove edge from v1, v2
			Vertex v1 = cleanVertex(gr, edge.ends.get( 0 ), edge);
			Vertex v2 = cleanVertex(gr, edge.ends.get( 1 ), edge);
			//contract
			Vertex mergedVertex = new Vertex( v1.lbl);
			// redirect edges to this new merged Vertex
			redirectEdges( gr, v1, mergedVertex );
			redirectEdges( gr, v2, mergedVertex );

			gr.addVertex( mergedVertex);
		}
		return gr.edges.size(); // return the number of crossing edges		
	}

	private static Vertex cleanVertex( Graph gr, Vertex v, Edge e){
		gr.vertices.remove(v.lbl);
		v.edges.remove(e);
		return v;
	}

	private static void redirectEdges( Graph gr, Vertex fromV, Vertex toV){
		for ( Iterator<Edge> it = fromV.edges.iterator(); it.hasNext(); ) {
			Edge edge = it.next();
			it.remove(); // remove those edge from merging vertex   
			if( edge.getOppositeVertex( fromV ) == toV ) { 
				// if true, means v1 direct to merged vertex, which is a self-loop
				// then remove self-loop
				toV.edges.remove( edge );

				gr.edges.remove( edge ); // also remove from graph

			} else {
				edge.replaceVertex( fromV, toV ); 
				toV.addEdge( edge ); // add old vertex's other edges to new merged vertex
			}
		}
	}
	
	//  private static void printGraph( Graph gr ) {
	//  System.out.println("Printing graph");
	//  for ( Vertex v : gr.vertices.values() ) {
	//      System.out.print( v.lbl + ":");
	//      for ( Edge edge : v.edges ) {
	//          System.out.print( " " + edge.getOppositeVertex( v ).lbl );
	//      }
	//      System.out.println();
	//  }
	//}

	//Adj format to visualize in 
	//http://www.cs.rpi.edu/research/groups/pb/graphdraw/headpage.html
	//private static void toAdjFormat(int[][] arr) {
	//  System.out.println(arr.length);
	//  for ( int[] adj : arr ) {
	//      System.out.print(adj.length);
	//      for ( int i : adj ) {
	//          System.out.print( " " + i );
	//      }
	//      System.out.println();
	//  }
	//}
}
