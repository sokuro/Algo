package Nodes;

/*
 * Store all elements in a particular depth
 */
public class NodeCounter {
	
	static int[] counter;

	static int nodeCnt(BTreePosition t, int depthLimit) {
		
		int level = 0;
		counter = new int[t.size()];	//store the sum of elements in particular depth
		getNodes(t, t.root(), level, depthLimit);
		
		return getSum(counter);	//return int
//		return (int) getSum(counter);
	}
	
	private static void getNodes(BTreePosition t, Position root, int level, int depthLimit) {
		while (level >= depthLimit) {
//			try {
				if (root != null) {
					counter[level]++;	//increment the counter before leaving the level
				
					if (t.leftChild(root) != null)
						getNodes(t, t.leftChild(root), level + 1, depthLimit);
					if (t.rightChild(root) != null) 
						getNodes(t, t.rightChild(root), level + 1, depthLimit);	
				}
				else counter[level] = 0;
//			} catch (Exception ex) {
//				System.out.println("Tree has no elements.. => . The depth of the tree is: " + 0);
//			}
		}
		level++;
	}
	
	private static int getSum(int[] count) {
		int sum = count[0];
		return sum;
	}
	
}
