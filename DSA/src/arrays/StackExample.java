package arrays;

public class StackExample {
	private int arr[];
	private int top;
	private int capacity;

	StackExample (int size) {
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	public void push(int ele) {
		if (isFull()) {
			System.out.println("Stack Overflow");
			System.exit(-10);
		}
		System.out.println("Adding element " + ele + " to the stack");
		arr[++top] = ele;

	}

	boolean isFull() {
		return top == capacity-1;
	}
	boolean isEmpty() {
		return top == -1;
	}

	int pop() {
		if(isEmpty()) {
			System.out.println("Cannot remove items from an empty stack");
			System.exit(-20);
		}
		return arr[top--];
	}

	void printStack() {
		System.out.println("Printing the current element in the stack");

		for(int i =0; i<=top; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackExample st = new StackExample(2);
		st.push(100);st.push(120);
		st.printStack();
		st.pop();
		st.printStack();
		st.pop();
		st.printStack();
		st.pop();
	}
}

