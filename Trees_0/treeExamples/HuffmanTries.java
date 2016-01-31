package treeExamples;

/*
 * HuffmanTrie: Element = ext. Node
 */
public class HuffmanTries {

	private static void printCodeTable(BTree t) {
	
		printCode(t, t.root(), " ");
	}
	
	private static void printCode(BTree t, Position p, String code) {
		
		if (t.isExternal(p))
			System.out.println(p.element() + " : " + code);	//print the element and 1/0
		else {
			printCode(t, t.leftChild(p), code + "0");
			printCode(t, t.rightChild(p), code + "1");
		}
	}
}
