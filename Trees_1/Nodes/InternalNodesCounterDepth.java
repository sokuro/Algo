package Nodes;

public class InternalNodesCounterDepth {
	
	public static int[] count;
	
	public static int[] getDepthCounts(BTree t) {
		
		int level = 0;
		count = new int[t.size()];
		depthCounts(t, t.root(), level);
		return count;
	}
	
	private static void depthCounts(BTree t, Locator p, int level) {
		
		if (p != null) {
			count[level]++;
				
//				count[level] = level;
			if (!(t.isExternal(p))) {
				
//				if (!(t.isExternal(t.leftChild(p))))
				depthCounts(t, t.leftChild(p), level + 1);
//				if (!(t.isExternal(t.rightChild(p))))
				depthCounts(t, t.rightChild(p), level + 1);			
			}
		}
	}
}
