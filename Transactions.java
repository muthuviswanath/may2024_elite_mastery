public class Transactions {

	public static void main(String[] args) throws InterruptedException {
		BankAccount ba = new BankAccount(1422015, 15000);
		Thread t1 = new Thread("Paytm") {
											@Override
											public void run() {
											System.out.println(Thread.currentThread().getName() + " transaction initiated.....");
											ba.deposit(10000);
											}
										};
										
		Thread t2 = new Thread("EMI process") {
											@Override
											public void run() {
											System.out.println(Thread.currentThread().getName() + " initiated.....");
											ba.withdraw(30000);
											}
										};
		Thread t3 = new Thread("Salary") {
											@Override
											public void run() {
											System.out.println(Thread.currentThread().getName() + " transaction initiated.....");
											ba.deposit(10000);
											}
										};
		t2.start();
		Thread.sleep(5000);
		t1.start();
		Thread.sleep(5000);
		t3.start();
	}
}