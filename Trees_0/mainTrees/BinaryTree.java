package mainTrees;

public class BinaryTree {

	    private static Node root;

	    public void Binarytree(int data)
	    {
	        root = new Node(data);
	    }

	    public void add(Node parent,Node child, String orientation)
	    {
	        if(orientation=="left")
	        {
	           parent.setLeft(child);
	        }
	        else if (orientation=="right")
	        {
	            parent.setRight(child);
	        }

	    }

	    public static void main(String ar[])
	    {
	        Node n1=new Node(1);
	        Node n2=new Node(4);
	        Node n3=new Node(2);
	        Node n4=new Node(5);

	        BinaryTree l1=new BinaryTree();
	        l1.add(root,n1,"left");
	        l1.add(root,n2,"right");
	        l1.add(root,n3,"left");
	        l1.add(root,n4,"right");


	    }
	}

	class Node {
	    private int key;
	    private Node left;
	    private Node right;
	    Node (int key) {
	        this.key = key;
	        right = null;
	        left = null;
	    }

	    public void setKey(int key) {
	        this.key = key;
	    }

	    public int getKey() {
	        return key;
	    }

	    public void setLeft(Node left) {
	        this.left = left;
	    }

	    public Node getLeft() {
	        return left;
	    }

	    public void setRight(Node right ) {
	        this.right = right;
	    }

	    public Node getRight() {
	        return right;
	    }

	}
