package linkedlists;

public class DoublyLinkedList {
	static Nodes head = new Nodes(10);
	public void add(int data) {
		Nodes new_node = new Nodes(data);
		new_node.next= head;
		new_node.prev = null;
		
		if(head !=null) {
			head.prev = new_node;
		}
		
		head = new_node;
	}
	
	static void traverseLinkedList(Nodes node) {
		Nodes current = node;
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
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(34);
		dll.add(56);
		traverseLinkedList(head);
	}
}

class Nodes{
	int data;
	Nodes next;
	Nodes prev;
	public Nodes(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

}
