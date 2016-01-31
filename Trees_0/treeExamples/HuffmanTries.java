package treeExamples;

public class HuffmanTries {

	private static void printCodeTable(BTree t) {
	
		printCode(t, t.root(), " ");
	}
	
	private static void printCode(BTree t, Position p, String code) {
		
		if (t.isExternal(p))
			System.out.println(p.element() + " : " + code);
		else {
			printCode(t, t.leftChild(p), code + "0");
			printCode(t, t.rightChild(p), code + "1");
		}
	}
}
