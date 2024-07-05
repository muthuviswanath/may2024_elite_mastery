package arrays;

public class QueueExample {
	int size = 5;
	int items[] = new int[size];
	int front,rear;

	public QueueExample() {
		front = -1;
		rear = -1;
	}

	boolean isFull() {
		if (front ==0 && rear == size-1) {
			return true;
		}
		return false;
	}

	boolean isEmpty() {
		if(front == -1) 
			return true;
		else
			return false;
	}

	void enqueue(int ele) {
		if(isFull()) {
			System.out.println("Cannot add element, Queue is full");
		}
		else {
			if(front==-1)
				front= 0;
			rear += 1;
			items[rear] = ele;
		}
	}
	int dequeue() {
		if(isEmpty()) {
			System.out.println("Cannot remove element. Queue is already empty");
			return -1;
		}

		else {
			int element = items[front];
			if(front >=  rear) {
				front = -1;
				rear = -1;
			}
			else {
				front++;
			}
			System.out.println("Removed Element: " + element);
			return element;
		}
	}

	void showqueue() {

		if (rear == -1 && front == -1) {
			System.out.println("[]");
		}
		else {
			for(int i=front; i<= rear; i++) {
				System.out.println(items[i]+" ");
			}
		}
	}

	public static void main(String[] args) {
		QueueExample q = new QueueExample();
		q.enqueue(10);q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.showqueue();

		q.dequeue();
		q.showqueue();
		q.dequeue();
		q.showqueue();
		q.dequeue();
		q.showqueue();
		q.dequeue();
		q.showqueue();
		q.dequeue();
		q.showqueue();
		q.dequeue();
	}
}
