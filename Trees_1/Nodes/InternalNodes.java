package Nodes;

import java.util.ArrayList;

public class InternalNodes {

		static ArrayList<Locator> intNodes = new ArrayList<Locator>();

		static private Locator[] internalNodes(BTree t) {
			
			if (t.root() != null) {
				internalNod(t, t.root());
				return (Locator[]) intNodes.toArray();
			}
			else 
				return new Locator[0];
		}

		private static void internalNod(BTree t, Locator n) {
			
			Locator node = n;
			Locator leftChild = t.leftChild(node);
			Locator rightChild = t.rightChild(node);
			
			if (!(t.isExternal(leftChild))) intNodes.add(leftChild);
			else internalNod(t, leftChild);
			if (!(t.isExternal(rightChild))) intNodes.add(rightChild);
			else internalNod(t, rightChild);
		}

}
