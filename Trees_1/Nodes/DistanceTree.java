package Nodes;

public class DistanceTree {

	public static int dist(BTreePosition t, Position p1, Position p2) {
		int level = 0;
		Position lca = LCA(t, t.root(), p1, p2);
	
		int distP1 = distRecursive(t, t.root(), p1, level);
		int distP2 = distRecursive(t, t.root(), p2, level);
		int distLCA = distRecursive(t, t.root(), lca, level);
		
		return (distP1 + distP2) - 2*distLCA;
	}
	
	//Position of the last shared element (parent)
	private static Position LCA(BTreePosition t, Position root, Position p1, Position p2) {
		
		if (root != null) {
			if (t.root() == p1 || t.root() == p2)
				return root;
			
			Position leftChild = LCA(t, t.leftChild(root), p1, p2);
			Position rightChild = LCA(t, t.rightChild(root), p1, p2);
			
			if (leftChild != null && rightChild != null) 
				return root;
			if (leftChild != null) return rightChild;
			else return leftChild;
		}
		return null;
	}
	
	private static int distRecursive(BTreePosition t, Position root, Position to, int level) {
		
		if (root == to) 
			return level;	
		
		if (root != null) {
			if (t.leftChild(root) != null) 
				distRecursive(t, t.leftChild(root), to, level + 1);
		
			if (t.rightChild(root) != null) 
				distRecursive(t, t.rightChild(root), to, level + 1);
			}
		return level;
	}
	
}
