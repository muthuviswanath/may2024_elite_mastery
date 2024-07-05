package linkedlists;

public class SinglyLinkedList {

	static Node head = new Node(10);

	static void traverseLinkedList(Node node) {
		Node current = node;
		while (current != null) {
			System.out.print(current.data);
			if(current.next == null) {
				System.out.print(" ");
			}
			else {
				System.out.print("->");
			}
			current = current.next;
		}

	}

	static void searchData(Node node, int data) {
		Node current = node;
		int count = 0;
		while (current != null) {
			if(current.data == data) {
				System.out.println(current.data +" is found");
				count++;
			}
			current = current.next;
		}
		if (count ==0) {
			System.out.println(data + " is not found");
		}
	}

	static int length(Node node) {
		Node current = node;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	static void insert(int position, int data) {
		Node new_node = new Node(data);
		if (position ==0 || head== null) {
			System.out.println("Inserting at position " + position);
			new_node.next= head;
			head = new_node;
			return;
		}
		
		Node current = head;
		for (int i = 1;i<position && current.next !=null;i++) {
			current = current.next;
		}
		System.out.println("Inserting at position " + position);
		new_node.next= current.next;
		current.next = new_node;
	}
	
	static void deleteAtBegining() {
		if (head == null) {
			System.out.println("Cannot delete empty list");
			return;
		}
		head = head.next;
	}
	public static void main(String[] args) {
		Node first = new Node(6);
		Node second = new Node(9);
		Node third = new Node(7);
		Node fourth = new Node(2);
		Node fifth = new Node(97);
		head.next = first;
		first.next = second;
		second.next = third;
		third.next= fourth;
		fourth.next = fifth;
		fifth.next = null;
		traverseLinkedList(first);
		System.out.println();
		insert(1,9999);
		traverseLinkedList(head);

	}

}

class Node{
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
