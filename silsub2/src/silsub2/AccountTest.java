package silsub2;
import java.util.Scanner;
public class AccountTest {
	
	public static void main(String[] args){
		
		// get input
		Scanner input = new Scanner(System.in);
		System.out.printf("account1 balance : ");
		double m1 = input.nextDouble();
		System.out.printf("account2 balance : ");
		double m2 = input.nextDouble();
		
		
		// make two accounts
		Bank myBank1 = new Bank("account1", m1);		
		Bank myBank2 = new Bank("account2", m2);
		
		
		// use 1
		System.out.printf("\nEnter withdrawal amount for account1 : ");
		double m11 = input.nextDouble();
		
		myBank1.debit(m11);
		myBank1.balance();
		myBank2.balance();
		
		// use 2
		System.out.printf("\nEnter withdrawal amount for account2 : ");
		double m22 = input.nextDouble();
		
		myBank2.debit(m22);
		myBank1.balance();
		myBank2.balance();
		
		// print
	}

}
