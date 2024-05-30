import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;
    private Account loggedInAccount;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolderName, String password, double initialBalance)
            throws AccountAlreadyExistsException {
        if (!accounts.containsKey(accountNumber)) {
            Account newAccount = new Account(accountNumber, accountHolderName, password, initialBalance);
            accounts.put(accountNumber, newAccount);
        } else {
            throw new AccountAlreadyExistsException("Account with this number already exists.");
        }
    }

    public void login(String accountNumber, String password) throws AccountNotFoundException, InvalidLoginException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found.");
        }
        if (!account.getPassword().equals(password)) {
            throw new InvalidLoginException("Invalid password.");
        }
        loggedInAccount = account;
    }

    public void logout() {
        loggedInAccount = null;
    }

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public void deposit(double amount) throws AccountNotFoundException {
        if (loggedInAccount == null) {
            throw new AccountNotFoundException("No account is logged in.");
        }
        loggedInAccount.deposit(amount);
    }

    public void withdraw(double amount) throws AccountNotFoundException, InsufficientBalanceException {
        if (loggedInAccount == null) {
            throw new AccountNotFoundException("No account is logged in.");
        }
        loggedInAccount.withdraw(amount);
    }
    
    public void emi_deposit(double amount) throws AccountNotFoundException{
    	 if (loggedInAccount == null) {
             throw new AccountNotFoundException("No account is logged in.");
         }
         loggedInAccount.emi_deposit(amount);
    }
    
    public void emi_withdrawal(double amount) throws AccountNotFoundException
	{
		if(loggedInAccount == null) {
			throw new AccountNotFoundException("No account is logged in.");
		}
		loggedInAccount.emi_withdrawal(amount);
	}

    public void transfer(String toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        if (loggedInAccount == null) {
            throw new AccountNotFoundException("No account is logged in.");
        }
        Account toAccount = accounts.get(toAccountNumber);
        if (toAccount == null) {
            throw new AccountNotFoundException("Beneficiary account not found.");
        }
        loggedInAccount.withdraw(amount);
        toAccount.deposit(amount);
        loggedInAccount.getTransactions().add(new Transaction("Transfer", amount, loggedInAccount.getBalance()));
        toAccount.getTransactions().add(new Transaction("Transfer", amount, toAccount.getBalance()));
    }

    public void printAccountInfo() {
        if (loggedInAccount != null) {
            System.out.printf("%-15s %-20s %-10s%n", "Account Number", "Account Holder", "Balance");
            System.out.println("---------------------------------------------------------------");
            System.out.println(loggedInAccount);
        }
    }

    public void printTransactions() {
        if (loggedInAccount != null) {
            System.out.printf("%-10s %-30s %-30s %-30s %-20s%n", "Txn ID", "Type", "Debit", "Credit", "Timestamp");
            System.out.println("--------------------------------------------------------------------------");
            for (Transaction transaction : loggedInAccount.getTransactions()) {
                String debit = transaction.getType().equals("Debit Transaction") ? String.format("%.2f", transaction.getAmount()) : "";
                String credit = transaction.getType().equals("Credit Transaction") || transaction.getType().equals("Transfer") ? String.format("%.2f", transaction.getAmount()) : "";
                System.out.printf("%-10s %-30s %-30s %-30s %-20s%n", transaction.getTransactionId(), transaction.getType(), debit, credit, transaction.getTimestamp());
            }
        }
    }

    public void printPassbook() {
        if (loggedInAccount != null) {
            System.out.println("Passbook:");
            System.out.printf("%-15s %-20s %-10s%n", "Account Number", "Account Holder", "Balance");
            System.out.println("---------------------------------------------------------------");
            System.out.println(loggedInAccount);
            System.out.printf("%%-10s %-30s %-30s %-30s %-20s%n", "Txn ID", "Type", "Debit", "Credit", "Timestamp");
            System.out.println("--------------------------------------------------------------------------");
            for (Transaction transaction : loggedInAccount.getTransactions()) {
                String debit = transaction.getType().equals("Debit Transaction") ? String.format("%.2f", transaction.getAmount()) : "";
                String credit = transaction.getType().equals("Credit Transaction") || transaction.getType().equals("Transfer") ? String.format("%.2f", transaction.getAmount()) : "";
                System.out.printf("%-10s %-30s %-30s %-30s %-20s%n", transaction.getTransactionId(), transaction.getType(), debit, credit, transaction.getTimestamp());
            }
        }
    }
}
