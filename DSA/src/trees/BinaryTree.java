package trees;

class Node{
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;

	}
}
public class BinaryTree {
	Node root;
	public BinaryTree(int data) {
		root = new Node(data);
	}
	public BinaryTree() {
		root = null;
	}
	
	public void inOrderTraversal(Node node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.print(" " + node.data);
			inOrderTraversal(node.right);
		}
	}
	
	public void preOrderTraversal(Node node) {
		if(node != null) {
			System.out.print(" " + node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	public void postOrderTraversal(Node node) {
		if(node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(" " + node.data);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		btree.root = new Node(1);
		btree.root.left = new Node(2);
		btree.root.right = new Node(3);
		btree.root.left.left = new Node(4);
		btree.root.left.right = new Node(5);
		btree.root.right.left = new Node(6);
		btree.root.right.right = new Node(7);
		btree.root.right.left.left = new Node(8);
		btree.root.right.left.right = new Node(9);
		btree.root.right.left.right.left = new Node(10);
		
		System.out.println("InOrder");
		btree.inOrderTraversal(btree.root);
		System.out.println();
		System.out.println("PreOrder");
		btree.preOrderTraversal(btree.root);
		System.out.println();
		System.out.println("PostOrder");
		btree.postOrderTraversal(btree.root);
	}
}
