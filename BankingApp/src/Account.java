import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountNumber;
	private String accountHolderName;
	private String password;
	private double balance;
	private List<Transaction> transactions;

	public Account(String accountNumber, String accountHolderName, String password, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.password = password;
		this.balance = balance;
		this.transactions = new ArrayList<>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getPassword() {
		return password;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactions.add(new Transaction("Credit Transaction", amount, balance));
		}
	}

	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			transactions.add(new Transaction("Debit Transaction", amount, balance));
		} else {
			throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
		}
	}

	public synchronized void emi_deposit(double amount)
	{
		balance = balance + amount;
		System.out.println("Successfully deposited:" + amount);
		System.out.println("Available balance:" + balance);
		notify();
	}

	public synchronized double emi_withdrawal(double amount) {
		if(balance<amount)
		{
			System.out.println("Cannot process the emi due to low balance....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return emi_withdrawal(amount);
		}
		balance = balance - amount;
		System.out.println("EMI Process succeeded. Processed " + amount + " towards your EMI payment");
		System.out.println("Available balance is: " + balance);
		return amount;
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-20s %-10.2f", accountNumber, accountHolderName, balance);
	}
}
