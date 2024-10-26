import java.util.Scanner;
public class SumOfDigitsInt {

	public static void main(String[] args) {
		int sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000: ");
		int number = sc.nextInt();
		while(number !=0) {
			sum = sum + (number %10);
			number = number/10;
		}
		System.out.println("Sum of digits: "+ sum);

	}

}
/*
Enter a number between 0 and 1000: 
999
Sum of digits: 27

Enter a number between 0 and 1000: 
456
Sum of digits: 15

Enter a number between 0 and 1000: 
781
Sum of digits: 16

Enter a number between 0 and 1000: 
123
Sum of digits: 6

Enter a number between 0 and 1000: 
69
Sum of digits: 15
*/