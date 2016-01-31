package connected;

public class IsTree {
	
	static boolean[] visited;

	static boolean isTree(int[][] ad) {
		
		if (isConnected(ad)) {
			for (int i = 0; i < ad.length; i++) {
				for (int j = 0; j < ad.length; j++) {
//					if (i == j && ad[i][j] == 1)
//						return false;
					if (ad[i][j] == 1 && ad[j][i] == 1) {
						if (!visited[i])
							visited[j] = true;
					}
				}
			}
			return true;
		}
		else return false;
	}
	
	private static boolean isConnected(int[][] ad) {
		
		visited = new boolean[ad.length];	//build the Flag array
		
		dfs(ad, 0);
		
		for (int i = 0; i < ad.length; i++) {
			if (visited[i] != true) return false;	
		}
		return true;
	}
	
	private static void dfs(int[][] ad, int s) {
		visited[s] = true;
	
		for (int i = 0; i < ad.length; i++) {
			if (ad[i][s] == 1 && !visited[i]) {
				dfs(ad, i);	//swap [column][row]
			}
		}
	}
}
