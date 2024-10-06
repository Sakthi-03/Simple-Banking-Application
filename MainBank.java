package bank1;

import java.util.Scanner;

class MainBank {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to our Bank");
		System.out.println("~~~~~~~ ~~ ~~~ ~~~~");

		System.out.println("Do you have an Account [Y or N]: ");
		String c = sc.next().toUpperCase();
		switch (c) {
		case "Y":
		case "YES":
			login("SAKTHI", "123");
			break;
		case "N":
		case "NO":
			signUp();
			break;
		default:
			System.out.println("Please enter Correct Input!");
			break;
		}

	}

	static void signUp() {
		Scanner sc = new Scanner(System.in);
//		System.out.println("Welcome to our Bank");
//		System.out.println("~~~~~~~ ~~ ~~~ ~~~~");
		System.out.print("Please set your user name: ");
		String name1 = sc.next().toUpperCase();
		System.out.print("Please set you password: ");
		String pwd1 = sc.next();
		System.out.println();
		System.out.println("Your username and password successfully added...");
		System.out.println("~~~~ ~~~~~~~~ ~~~ ~~~~~~~~ ~~~~~~~~~~~~ ~~~~~");
		login(name1, pwd1);
	}

	static void login(String name1, String pwd1) {
		Scanner sc = new Scanner(System.in);

		String name = name1;
		String pwd = pwd1;

		boolean isValid = false;
		int count = 2;
		while (!isValid) {
			System.out.print("Enter your Username: ");
			String Uname = sc.next().toUpperCase();

			System.out.print("Enter your Password: ");
			String Upwd = sc.next();

			if (name.equals(Uname) && pwd.equals(Upwd)) {
				double amt = 0;
				boolean valid = false;
				while (!valid) {
					System.out.println();
					System.out.println("Welcome " + name);
					System.out.println("~~~~~~~ ~~~~~~");
					System.out.print("Enter the initial account Balance (MINIMUM 100): ");
					double amt1 = sc.nextDouble();

					if (amt1 > 100) {
						amt = amt1;
						valid = true;
					} else {
						System.out.println("Please enter more than 100");
					}
				}

				System.out.print("Enter account type (savings/current): ");
				String acctype = sc.next().toLowerCase();

				if (acctype.equals("savings")) {
					String accType = "SAVINGS ACCOUNT";
					SavingsAcc savings = new SavingsAcc(Uname, Upwd, amt, accType);
					savings.display();
				} else if (acctype.equals("current")) {
					String accType = "CURRENT ACCOUNT";
					CurrentAcc current = new CurrentAcc(Uname, Upwd, amt, accType);
					current.display();
				} else {
					System.out.println("Please enter correctly!");
				}
				isValid = true;
			} else {

				System.out.println("Incorrect Username or Password...");
				if (count > 0) {
					System.out.println("You have " + (count) + " attempt(s) left!");
				}
				count--;
				if (count < 0) {
					System.out.println("Your Account locked! Please contact your Branch!");
					isValid = true;
				}
			}
		}
	}

}
