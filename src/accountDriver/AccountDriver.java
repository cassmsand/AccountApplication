package accountDriver;

import java.util.Scanner;

public class AccountDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = scan.next();
		
		System.out.println("Name is: " + name);
		
		Account account1 = new Account(name);
		boolean loggedIn = true;
		
		System.out.println("Balance: " + account1.getBalanceString());
		
		while (loggedIn == true) {
			System.out.print("Enter '1' to make a deposit or '2' to make a withdrawl or '3' to exit: ");
			int numEntered = scan.nextInt();
			
			if (numEntered == 1) {
				System.out.print("Enter the amount you want to deposit: ");
				double deposit = scan.nextDouble();
				account1.deposit(deposit);
				System.out.println("Balance: " + account1.getBalanceString());
				
			} else if (numEntered == 2) {
				System.out.print("Enter the amount you want to withdrawl: ");
				double withdrawl = scan.nextDouble();
				account1.withdraw(withdrawl);
				System.out.println("Balance: " + account1.getBalanceString());
				
			} else if (numEntered == 3) {
				loggedIn = false;
				System.out.print("You have been logged out.");
			}
			
		}

	}

}
