public class BankAccount {

	int accNo;
	long balance;

	public BankAccount(int accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	synchronized int withdraw(int amount)
	{
		if(balance<amount)
		{
			System.out.println("Cannot process the emi due to low balance....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return withdraw(amount);
		}
		balance = balance - amount;
        System.out.println("EMI Process succeeded. Processed " + amount + " towards your EMI payment");
		System.out.println("Available balance is: " + balance);
		return amount;
	}
	
	synchronized void deposit(int amount)
	{
		balance = balance + amount;
		System.out.println("Successfully deposited:" + amount);
		System.out.println("Available balance:" + balance);
		notify();
	}
}