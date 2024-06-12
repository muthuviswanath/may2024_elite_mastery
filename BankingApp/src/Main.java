import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();
		boolean loggedIn = false;

		while (true) {
			System.out.println("Banking System Menu:");
			if (!loggedIn) {
				System.out.println("1. Create Account");
				System.out.println("2. Login");
				System.out.println("3. Exit");
			} else {
				System.out.println("1. View Account");
				System.out.println("2. Deposit Money");
				System.out.println("3. Withdraw Money");
				System.out.println("4. Transfer Money");
				System.out.println("5. Process EMI");
				System.out.println("6. View Transactions");
				System.out.println("7. View Passbook");
				System.out.println("8. Logout");
			}
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			try {
				if (!loggedIn) {
					switch (choice) {
					case 1:
						System.out.print("Enter Account Number: ");
						String accountNumber = scanner.nextLine();
						System.out.print("Enter Account Holder Name: ");
						String accountHolderName = scanner.nextLine();
						System.out.print("Enter Password: ");
						String password = scanner.nextLine();
						System.out.print("Enter Initial Balance: ");
						double initialBalance = scanner.nextDouble();
						scanner.nextLine(); // Consume newline
						bank.createAccount(accountNumber, accountHolderName, password, initialBalance);
						System.out.println("Account created successfully.");
						break;

					case 2:
						System.out.print("Enter Account Number: ");
						accountNumber = scanner.nextLine();
						System.out.print("Enter Password: ");
						password = scanner.nextLine();
						bank.login(accountNumber, password);
						loggedIn = true;
						System.out.println("Login successful.");
						break;

					case 3:
						System.out.println("Exiting the system.");
						scanner.close();
						System.exit(0);

					default:
						System.out.println("Invalid choice. Please try again.");
					}
				} else {
					switch (choice) {
					case 1:
						bank.printAccountInfo();
						break;

					case 2:
						System.out.print("Enter Amount to Deposit: ");
						double depositAmount = scanner.nextDouble();
						scanner.nextLine(); // Consume newline
						bank.deposit(depositAmount);
						System.out.println("Amount deposited successfully.");
						break;

					case 3:
						System.out.print("Enter Amount to Withdraw: ");
						double withdrawAmount = scanner.nextDouble();
						scanner.nextLine(); // Consume newline
						bank.withdraw(withdrawAmount);
						System.out.println("Amount withdrawn successfully.");
						break;
						
					case 4:
						System.out.print("Enter Destination Account Number: ");
						String toAccountNumber = scanner.nextLine();
						System.out.print("Enter Amount to Transfer: ");
						double transferAmount = scanner.nextDouble();
						scanner.nextLine(); // Consume newline
						bank.transfer(toAccountNumber, transferAmount);
						System.out.println("Amount transferred successfully.");
						break;
					case 5:
						Thread t1 = new Thread("Paytm") {
							@Override
							public void run() {
								System.out.println(Thread.currentThread().getName() + " transaction initiated.....");
								try {
									bank.emi_deposit(10000);
								}
								catch (Exception e) {
									e.printStackTrace();
								}
							}
						};

						Thread t2 = new Thread("EMI process") {
							@Override
							public void run() {
								System.out.println(Thread.currentThread().getName() + " initiated.....");
								try {
									bank.emi_withdrawal(30000);
								}
								catch (Exception e) {
									e.printStackTrace();
								}
							}
						};
						Thread t3 = new Thread("Salary") {
							@Override
							public void run() {
								System.out.println(Thread.currentThread().getName() + " transaction initiated.....");
								try {
									bank.emi_deposit(10000);
								}
								catch (Exception e) {
									e.printStackTrace();
								}
							}
						};
						t2.start();
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						t1.start();
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						t3.start();
					case 6:
						bank.printTransactions();
						break;

					case 7:
						bank.printPassbook();
						break;

					case 8:
						bank.logout();
						loggedIn = false;
						System.out.println("Logged out successfully.");
						break;

					default:
						System.out.println("Invalid choice. Please try again.");
					}
				}
			} catch (AccountNotFoundException | AccountAlreadyExistsException |
					InvalidLoginException | InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
