package Nodes;

import java.util.ArrayList;

public class TreeHeap {

	static ArrayList<Locator> list = new ArrayList<Locator>();
	
	static private Locator[] toBArray (BTree t) {
		
		if (t.root() != null) {
			allElements(t, t.root(), 1);
			return (Locator[]) list.toArray();
		}
		else 
			return new Locator[0]; 
	}

	private static void allElements(BTree t, Locator n, int position) {
		
		if (t.element() != null) {
			Locator node = n;
			Locator leftChild = t.leftChild(node);
			Locator rightChild = t.rightChild(node);
		
			if (leftChild != null) {
				list.add((2*position), leftChild);
				allElements(t, leftChild, (2*position));
			}
			if (rightChild != null) {
				list.add((2*position)+1, rightChild);
				allElements(t, rightChild, (2*position)+1);
			}
		}
		else 
			list.add(position, null);
	}
}
