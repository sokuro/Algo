package distances;

import paths.MyQueue;

//import java.util.Queue;

public class Distance {
	
	private static MyQueue<Integer> vertices = new MyQueue<Integer>();
	private static boolean[] visited;	//Flag
	private static int[][] dist;
	private static int distance;
	
	
	static public int distance(int[][] adj, int from, int to) {
		visited = new boolean[adj.length];
		dist = new int[adj.length][adj.length];
		
//		vertices.enqueue(new Node(0, 0, distance));
		
		while (!vertices.isEmpty()) {
			int n = vertices.dequeue();
			bfs(adj, n, distance);
		}	
		return getMin(dist);
	}
	
	
	private static void bfs(int [][] adj, int v, int distance) {
		
		while(!vertices.isEmpty()) {	//loop for iteration the whole matrix
			for (int i = 0; i < adj.length; i++) {	//for each row
				if(adj[i][v] == 1 && !visited[i]){	//check [column][row]
					visited[i] = true;		//flag-> visited
					vertices.enqueue(i);	//push the element into queue
					dist[i][v] = distance;
					distance++;
				}
			}				
			if(!vertices.isEmpty()) {
				bfs(adj, vertices.dequeue(), distance);//take the element from the queue
											//as an input for the recursion
			}
		}
	}
	
	//pick-up the minimal distance from the distance matrix
	private static int getMin(int[][] distance) {
		int min = distance[0][0];
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance.length; j++) {
			if (distance[i][j] < min)
				min = distance[i][j];
			}
		}
		for (int k = 0; k < distance.length; k++) {
			for (int l = 0; l < distance.length; l++) {
				min = Math.max(min, distance[k][l]);
			}
		}
		return min;
	}
	
//	class Node{
//	    int col;
//	    int row;
//	    int dist;
//
//	    public Node(int _col, int _row, int _dist) {
//	        col = _col;
//	        row = _row;
//	        dist = _dist;
//	    }
//	}
	
	public static void main(String[] args) {	
		
		int[][] matrix = new int[4][4];
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[0][3] = 0;
		
		matrix[1][0] = 0;
		matrix[1][1] = 1;
		matrix[1][2] = 1;
		matrix[1][3] = 1;
		
		matrix[2][0] = 0;
		matrix[2][1] = 1;
		matrix[2][2] = 1;
		matrix[2][3] = 1;
		
		matrix[3][0] = 0;
		matrix[3][1] = 1;
		matrix[3][2] = 1;
		matrix[3][3] = 1;
		
		visited = new boolean[matrix.length];
		
		bfs(matrix, 0, 0);
	}
}
