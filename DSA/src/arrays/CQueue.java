package arrays;

public class CQueue {
	int size = 5;
	int front, rear;
	int qitems[] = new int [size];

	public CQueue() {
		front = -1;
		rear = -1;
	}

	boolean isFull() {
		if (front == 0 && rear == size-1) {
			System.out.println("Queue is full");
			return true;
		}
		if(front == rear + 1) {
			return true;
		}
		return false;
	}

	boolean isEmpty() {
		if(front == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	void enqueue(int element) {
		if(isFull()) {
			System.out.println("Queue is full. Cannot add element");
		}
		else {
			if(front == -1) {
				front = 0;
			}
			rear += 1;
			qitems[rear] = element;
			System.out.println("Element " + element + " added to queue");
		}
	}
	
	int dequeue() {
		int element;
		if(isEmpty()) {
			System.out.println("Queue is empty. Cannot dequeue");
			return -1;
		}
		else {
			element = qitems[front];
			if(front == rear) {
				front = -1;
				rear = -1;
			}
			else {
				front = (front + 1) % size;
			}
			System.out.println("Removed the element "+ element);
			return element;
		}
	}
	void display() {
		int i = 0;
		
		if(isEmpty()) {
			System.out.println("[]");
		}
		else {
//			System.out.println("Front --> " + front);
			System.out.println("Queue Items: ");
			for(i=front;i!=rear;i++) {
				System.out.print(qitems[i]+" ");
			}
			System.out.println(qitems[i]);
//			System.out.println("Rear --> " + rear);
		}
	}
	public static void main(String[] args) {
		CQueue cq = new CQueue();
		cq.enqueue(10);cq.enqueue(30);
		cq.enqueue(20);cq.enqueue(40);
		cq.enqueue(60);
		cq.display();
		cq.dequeue();
		cq.display();
	}
}
