package distances;

import java.util.Queue;

public class Distance {
	
	static public int distance(int[][] adj, int from, int to){
		return 0;
	}
	
	private static Queue<Integer> queue;
	
	static void bfs(int[][] ad, int s) {
		
		int[] visited = new int[ad[s].length-1];
		
		for (int i = 0; i < ad.length; i++) {
			if (ad[i][s] == 1) {
				visited[s] = 1;			
				queue.add(s);
			}
		}
		while (!queue.isEmpty()) {
			
		}
	}
}
