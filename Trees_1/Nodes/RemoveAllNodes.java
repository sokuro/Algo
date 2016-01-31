package Nodes;

public class RemoveAllNodes {

	public static void removeAll(BTreePosition t, int depth) {
		int level = 0;
		delete(t, t.root(), level, depth);
	}
	
	static void delete(BTreePosition t, Position p, int level, int depth) {
		while (level >= depth) {
			try {
				if (p != null) {
					if (t.leftChild(p) != null) 
						delete(t, t.leftChild(p), level + 1, depth);
					else t.remove(t.leftChild(p));
					if (t.rightChild(p) != null)
						delete(t, t.rightChild(p), level + 1, depth);
					else t.remove(t.rightChild(p));
				}
			} catch (Exception ex) {
				System.out.println("No more elements to remove!");
			}
		}
		level++;
	}

}
