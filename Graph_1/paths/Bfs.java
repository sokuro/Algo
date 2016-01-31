package paths;

public class Bfs {
	
	//Every discovered element will be saved in a queue.
	public static MyQueue<Integer> vertices = new MyQueue<Integer>();
	public static boolean[] visited;	//Flag

	static void bfs(int [][] adj, int v) {
		
		while(!vertices.isEmpty()) {	//loop for iteration the whole matrix
			for (int i = 0; i < adj.length; i++) {	//for each row
				if(adj[i][v] == 1 && !visited[i]){	//check [column][row]
					visited[i] = true;		//flag-> visited
					vertices.enqueue(i);	//push the element into queue
				}
			}				
			if(!vertices.isEmpty()) {
				bfs(adj, vertices.dequeue());//take the element from the queue
											//as an input for the recursion
			}
		}
	}
	
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
		
		bfs(matrix, 0);
	}
}
