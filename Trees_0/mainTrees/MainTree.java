package mainTrees;

public class MainTree {

	public int index;
	
	private int[] stor = new int[index];
	
	private class Node {
		
		Node prev, next;
		Node left, right;
		int value;
		int index;
		private Node(int value) {
			this.value = value;
		}
		private Node(int index, int value) {
			this.value = value;
			this.index = index;
		}
	}
	
	private void insert(Node node, int index, int value) {
		if (value < node.value) {
			if (node.prev != null) {
				insert(node.left, index, value);
			} else {
				node.prev = new Node(value);
				index++;
			}
		} else if (value > node.value) {
			if (node.next != null) {
				insert(node.right, index, value);
			} else {
				node.next = new Node(value);
				index++;
			}
		}
	}
	
	public static void main(String[] args) {
		MainTree main = new MainTree();
		main.insert(null, 0, 5);
		
	}
	
}
