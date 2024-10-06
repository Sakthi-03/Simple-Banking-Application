package bank1;

import java.util.Scanner;

public class CurrentAcc extends Bank {

	int wamtHis;
	int damtHis;
	Scanner sc = new Scanner(System.in);

	public CurrentAcc(String usrname, String usrpwd, double amount, String accType) {
		super(usrname, usrpwd, amount, accType);
	}

	void display() {

		int ch = 1;
		while (ch == 1) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1.For Check Balance \n2.For Withdrawl \n3.For Deposit \n4.Details \n5.Exit");
			System.out.println("Enter your option...");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				checkBalance();
				break;
			case 2:
				withDrawl();
				break;
			case 3:
				Deposit();
				break;
			case 4:
				details();
				break;
			case 5:
				ch = 0;
				System.out.println("Thank you...");
				break;
			default:
				System.out.println("Please enter the correct input!");
				break;
			}
		}
	}

	private void checkBalance() {
		System.out.println("Your Current Account balance: " + amount);
	}

	private void withDrawl() {
		int wamt = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter the amount to Withdrawl (MAX:100): ");
			int wamt1 = sc.nextInt();
			if (wamt1 >= 100) {
				wamt = wamt1;

				if (wamt <= amount) {
					amount -= wamt;
					wamtHis += wamt;
					System.out.println("Please collect your Cash!... Balance = " + amount);
					valid = true;

				} else {
					System.out.println("Insufficient Account balance...Your balance: " + amount);

				}
			} else {
				System.out.println("Please enter 100 or above!");
				System.out.println("~~~~~~ ~~~~~ ~~~ ~~ ~~~~~");
			}
		}
	}

	private void Deposit() {
		int damt = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print("Enter the amount to Deposit: ");
			int damt1 = sc.nextInt();
			if (damt1 >= 100) {
				damt = damt1;
				amount += damt;
				damtHis += damt;
				System.out.println("Your amount " + damt
						+ " successfully credited to your Current Account...  Balance = " + amount);
				isValid = true;
			} else {
				System.out.println("Please enter 100 or above!");
				System.out.println("~~~~~~ ~~~~~ ~~~ ~~ ~~~~~");
			}
		}

	}

	private void details() {
		System.out.println("Account Holder name: " + usrname);
		System.out.println("Account Type: " + accType);
		System.out.println("Total Amount Withdrawl: " + wamtHis);
		System.out.println("Total Amount Deposit: " + damtHis);
		System.out.println("Account Balance: " + amount);
	}
}
