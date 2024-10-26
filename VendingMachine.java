import java.util.Scanner;
import java.util.Random;
public class VendingMachine {

	public static void main(String[] args) {
		int amount, quarters, dimes, nickels, pennies;
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		System.out.println("Enter amount of quarters: ");
		quarters = sc.nextInt();
		System.out.println("Enter amount of dimes: ");
		dimes = sc.nextInt();
		System.out.println("Enter amount of nickels: ");
		nickels = sc.nextInt();
	
		int cents = quarters*25 + dimes*10 + nickels*5;
		boolean bool = true;
		System.out.println("Menu: 1) Potato chips $1.25; 2) Cookies $0.85; 3) Candies $0.95. Press 4 to cancel your transaction.");
		System.out.println("Enter the corresponding number of the item that you wish to purchase: ");
		
		
		while(true) {
			int item = sc.nextInt();
		switch(item) {
		case 1: 
			amount = random.nextInt(3);
			System.out.println("Quantity of the snack: "+ amount);
			if(amount <=0) {
				System.out.println("Sold out. Please make another choice.");
				break;
			}
			
			if((cents -125) >=0) {
				cents = cents - 125;
				System.out.println("Please take your Chips.");
				System.out.println("Your change is: ");
				quarters = cents/25;
				cents = cents % 25;
				dimes = cents/10;
				cents = cents % 10;
				nickels = cents/5;
				cents = cents % 5;
				pennies = cents;
				amount = amount -1;
            
				System.out.println(quarters + " quarter(s)");
				System.out.println(dimes + " dime(s)");
				System.out.println(nickels + " nickel(s) and");
				System.out.println(pennies + " pennies");
				System.exit(0);
			}
			else {
				System.out.println("Not enough money for Potato chips, please select a different snack.");
				System.out.println("Menu: 1) Potato chips $1.25; 2) Cookies $0.85; 3) Candies $0.95. Press 4 to cancel your transaction.");
				System.out.println("Enter the corresponding number of the item that you wish to purchase: ");
			}
			break;
			
		case 2:
			amount = random.nextInt(3);
			System.out.println("Quantity of the snack: "+ amount);
			if(amount <=0) {
				System.out.println("Sold out. Please make another choice.");
				break;
			}
			
			if((cents -85)>=0) {
			cents = cents - 85;
			System.out.println("Please take your Candies.");
			System.out.println("Your change is: ");
			quarters = cents/25;
            cents = cents % 25;
            dimes = cents/10;
            cents = cents % 10;
            nickels = cents/5;
            cents = cents % 5;
            pennies = cents;
            amount = amount -1;
             
            System.out.println(quarters + " quarter(s)");
            System.out.println(dimes + " dime(s)");
            System.out.println(nickels + " nickel(s) and");
            System.out.println(pennies + " pennies");
            System.exit(0);
			}
			else {
				System.out.println("Not enough money for Cookies, please select a different snack.");
				System.out.println("Menu: 1) Potato chips $1.25; 2) Cookies $0.85; 3) Candies $0.95. Press 4 to cancel your transaction.");
				System.out.println("Enter the corresponding number of the item that you wish to purchase: ");
			}
			break;
		case 3:	
			amount = random.nextInt(3);
			System.out.println("Quantity of the snack: "+ amount);
			if(amount <=0) {
				System.out.println("Sold out. Please make another choice.");
				break;
			}
			
			if((cents -95) >=0) {
				cents = cents - 95;
				System.out.println("Please take your Candies.");
				System.out.println("Your change is: ");
				quarters = cents/25;
				cents = cents % 25;
				dimes = cents/10;
				cents = cents % 10;
				nickels = cents/5;
				cents = cents % 5;
				pennies = cents;
				amount = amount -1;
             
				System.out.println(quarters + " quarter(s)");
				System.out.println(dimes + " dime(s)");
				System.out.println(nickels + " nickel(s) and");
				System.out.println(pennies + " pennies");
				System.exit(0);
			}
			else {
				System.out.println("Not enough money for Candies, please select a different snack.");
				System.out.println("Menu: 1) Potato chips $1.25; 2) Cookies $0.85; 3) Candies $0.95. Press 4 to cancel your transaction.");
				System.out.println("Enter the corresponding number of the item that you wish to purchase: ");
			}
			break;
		case 4:
			System.out.println("Your change is: ");
			quarters = cents/25;
			cents = cents % 25;
			dimes = cents/10;
			cents = cents % 10;
			nickels = cents/5;
			cents = cents % 5;
			pennies = cents;
         
			System.out.println(quarters + " quarter(s)");
			System.out.println(dimes + " dime(s)");
			System.out.println(nickels + " nickel(s) and");
			System.out.println(pennies + " pennies");
			System.exit(0);	
		
		default:
			System.out.println("Please enter a number that corresponds to a snack.");
			System.out.println("Menu: 1) Potato chips $1.25; 2) Cookies $0.85; 3) Candies $0.95.");
			System.out.println("Enter the corresponding number of the item that you wish to purchase: ");
			item = sc.nextInt();
			break;
		}
	}
	
}

}
