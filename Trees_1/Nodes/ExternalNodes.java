package Nodes;

import java.util.ArrayList;

public class ExternalNodes {
	
	static ArrayList<Locator> extNodes = new ArrayList<Locator>();

	static private Locator[] externalNodes (BTree t) {
		
		if (t.root() != null) {
			externalNod(t, t.root());
			return (Locator[]) extNodes.toArray();
		}
		else 
			return new Locator[0];
	}

	private static void externalNod(BTree t, Locator n) {
		
		Locator node = n;
		Locator leftChild = t.leftChild(node);
		Locator rightChild = t.rightChild(node);
		
		if (t.isExternal(leftChild)) extNodes.add(leftChild);
		else externalNod(t, leftChild);
		if (t.isExternal(rightChild)) extNodes.add(rightChild);
		else externalNod(t, rightChild);
	}
	
}
