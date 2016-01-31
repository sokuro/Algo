package connected;

public class IsConnected {
	
	static boolean[] visited;

	public static boolean isConnected(int[][] ad) {
	
		visited = new boolean[ad.length];	//build the Flag array
		
		dfs(ad, 0);
		
		for (int i = 0; i < ad.length; i++) {
			if (visited[i] != true) return false;	
		}
		return true;
	}
	
	static void dfs(int[][] ad, int s) {
		visited[s] = true;
	
		for (int i = 0; i < ad.length; i++) {
			if (ad[i][s] == 1 && !visited[i]) {
				dfs(ad, i);	//swap [column][row]
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
		
		System.out.println(isConnected(matrix));
	}
}
