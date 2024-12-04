package mini_project;
import java.util.*;
class BankOperations
{
	private String accountno;
	private String name;
	private double balance;

public BankOperations(String accountno, String name,double initial_balance)
{
	this.accountno= accountno;
	this.name= name;
	this.balance= initial_balance;

	
}
public String getAccountNumber() 
{
    return accountno;
}

public String getAccountHolderName()
{
    return name;
}

public double getBalance()
{
    return balance;
}
public void deposit(double amount) {
    if (amount > 0)
    {
        balance = balance+ amount;
        System.out.println("Successfully deposited: " + amount);
        System.out.println("Balance after deposit:"+balance);
    } 
    else 
    {
        System.out.println("Amount deposition failed.");
    }
}
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) 
    {
        balance = balance- amount;
        System.out.println("Amount withdrawal successful:" + amount);
        System.out.println("Balance after withdrawal:"+balance);
    } 
    else
    {
        System.out.println("Insufficient Balance.");
    }
}
public void displayAccountDetails()
{
    System.out.println("Account Number: " + accountno);
    System.out.println("Account Holder Name: " + name);
    System.out.println("Balance: " + balance);
}
}
class Bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankOperations account = null;

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    String accountno = "";
                    while (true) 
                    {
                        System.out.print("Enter 12-digit Account Number: ");
                        accountno = sc.next(); // Read as a string
                        if (accountno.matches("\\d{12}")) //checking for 12 digits
                        { 
                            break; 
                        } else {
                            System.out.println("Invalid account number. Please enter a 12-digit number.");
                        }
                    }
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = sc.nextDouble();

                    account = new BankOperations(accountno, name, initialDeposit);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawalAmount = sc.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 4:
                    if (account != null) {
                        account.displayAccountDetails();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Banking System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
