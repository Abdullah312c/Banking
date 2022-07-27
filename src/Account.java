import java.util.Scanner;

public class Account {

	String customerName;
	String customerId;
	float balance;
	float lastTransaction;
	
	Account (String customerName, String customerId) {
		
		this.customerName = customerName;
		this.customerId = customerId;
	}
	
	/**
	 * Function to deposit money in the bank account
	 * @param amount of money the user specifies
	 */
	private void deposit(float amount) {
		
		if(amount != 0) {
			
			balance += amount;
			lastTransaction = amount;
		}
	}
	
	/**
	 * Function to withdraw money in the bank account
	 * @param amount of money the user specifies
	 */
	private void withdraw(float amount) {
		
		if(amount != 0) {
			
			if(amount <= balance) {
				
				balance -= amount;
				lastTransaction = -amount;
			}

			else {
				
				System.out.println();
				System.out.println("Soory, this amount of money is bigger than your balance.");
			}
		}
	}
	
	/**
	 * Function to view the last transaction the user did
	 */
	private void showLastTransaction() {
		
		if(lastTransaction > 0) {
			
			System.out.printf("You deposited %.2f$\n", lastTransaction);
		}
		
		else if(lastTransaction < 0) {
			
			System.out.printf("You withdrew %.2f$\n", Math.abs(lastTransaction));
		}
		
		else {
			
			System.out.println("You didnot do any transaction.");
		}
	}
	
	/**
	 * Method to calculate interest of current funds after a number of years
	 * @param number of years the user specifies
	 */
	private void interest(int years) {
		
		final float interestRate = (float) 1.85;
		System.out.println();
		System.out.println("The current interest rate is " +interestRate+"%");
		System.out.println("Your balance after " +years+  " years will be "+ ((balance * interestRate * years) + balance) +"$");
	}
	
	/**
	 * Function to show the main menu
	 */
	public void showMenu() {
		
		System.out.println("Welcome to our bank " +customerName +"!");
		System.out.println("Your id is: " +customerId);
		System.out.println("What would you like to do?");
		System.out.println("A. Check the balance.");
		System.out.println("B. Make a deposit.");
		System.out.println("C. Make a withdraw.");
		System.out.println("D. View the previous transaction.");
		System.out.println("E. Calculate the interest.");
		System.out.println("F. Exit.");
		
		char operation = 'A';
		
		do {
			Scanner s = new Scanner(System.in);
			System.out.print("Enter an option: ");
			operation = s.next().charAt(0);
			operation = Character.toUpperCase(operation);
			System.out.println();
			
			switch(operation) {
			
			// Allow the user to check his/her balance.
			case 'A':
				System.out.println("--------------------------------------");
				System.out.printf("Your balance is: %.2f$\n", balance);
				System.out.println("--------------------------------------");
				System.out.println();
				break;
			
			// Allow the user to deposit money in his/her bank account.
			case 'B':
				System.out.println("--------------------------------------------------------");
				System.out.print("Enter the amount of money you want to deposit: ");
				try {
					Float deposit = s.nextFloat();
					deposit(deposit);
				} catch(Exception e) {
					
					System.out.println("Error: You must enter a number.");
				}
				System.out.println("--------------------------------------------------------");
				System.out.println();
				break;
				
			// Allow the user to withdraw money from his/her bank account.
			case 'C':
				System.out.println("--------------------------------------------------------");
				System.out.print("Enter the amount of money you want to withdraw: ");
				try {
					Float withdraw = s.nextFloat();
					withdraw(withdraw);
				} catch(Exception e) {
					
					System.out.println("Error: You must enter a number.");
				}
				System.out.println("--------------------------------------------------------");
				System.out.println();
				break;
				
			// Allow the user to see his/her last transaction.
			case 'D':
				System.out.println("--------------------------------------------------------");
				showLastTransaction();
				System.out.println("--------------------------------------------------------");
				System.out.println();
				break;
				
			// Calculate the accrued interest on the user's bank account after a number of years.
			case 'E':
				System.out.println("--------------------------------------------------------");
				System.out.print("Enter how many years of accrued interest: ");
				try {
					int years = s.nextInt();
					interest(years);
				} catch(Exception e) {
					
					System.out.println("Error: You must enter a number.");
				}
				System.out.println("--------------------------------------------------------");
				System.out.println();
				break;
				
			// Exit from the account.
			case 'F':
				System.out.println();
				System.out.println("Thank you for banking with us!");
				break;
				
			// Let the user know than he/she entered a wrong option
			default:
					System.out.println("Error : wrong option please Enter A, B, C, D, E or F:");
				break;
			}
		} while(operation != 'F');
	}
}
