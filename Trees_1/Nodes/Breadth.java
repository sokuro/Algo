package Nodes;

/*
 * Count the maximal number of elements in the specific tree height
 */
public class Breadth {
	
	public static int[] count;

	public static int breadth(BTreePosition t) {
		
		int level = 0;	//increment each level
		count = new int[t.size()];
		getBreadthRecursive(t, t.root(), level);
		return getMax(count);
	}
	

	private static void getBreadthRecursive(BTreePosition t, Position p, int level) {
		
		if (p != null) {
			count[level]++;	//increment the counter before leaving the level
			
			if (t.leftChild(p) != null) {
				getBreadthRecursive(t, t.leftChild(p), level + 1);
			}
			if (t.rightChild(p) != null) {
				getBreadthRecursive(t, t.rightChild(p), level + 1);
			}
		}
	}
	
	private static int getMax(int[] count) {
		int max = count[0];
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max)
				max = count[i];
		}
		return max;		
	}
	
}
