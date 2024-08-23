/**
 * @author CassieSand
 * 
 * This class takes in an owner's name to be on a banking account.
 * The account has a balance, account number, and name.
 * There is a static variable for counting the total number of banking accounts.
 * 
 * @param ownerName owner's name to be on the account
 */

package accountDriver;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements Comparable<Account>{
	private String ownerName;
	private double balance;
	private int accountNumber;
	private static int numberOfAccounts = 0;
	
	public Account(String ownerName) {
		numberOfAccounts += 1;
		this.ownerName = ownerName;
		balance = 0.00;
		accountNumber = numberOfAccounts;
	}
	
	public void setOwnerName(String name) {
		ownerName = name;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public String getBalanceString() {
		String balString = String.format("%.2f", balance);
		return balString;
	}
	
	public double getBalanceDouble() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * @param amount the amount of money to be deposited into the account
	 */
	public void deposit(double amount) {
		BigDecimal bd = BigDecimal.valueOf(amount);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
		balance += bd.doubleValue();
	}
	
	/**
	 * @param amount the amount of money to be withdrawn from the account
	 * @return if the amount to be withdrawn is not greater than the amount held
	 * 	in the account, the function returns true.
	 */
	public boolean withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		else {
			return false;
		}

	}
	
	public String toString() {
		String output = "";
		output += ownerName + "\t";
		output += balance + "\t";
		output += accountNumber;
		return output;
	}
	
	public boolean equals(Account other) {
		return accountNumber == other.getAccountNumber();
	}

	@Override
	public int compareTo(Account other) {
		return accountNumber - other.getAccountNumber();
	}
}
