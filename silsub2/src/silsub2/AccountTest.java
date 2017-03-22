package silsub2;
import java.util.Scanner;
public class AccountTest {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		// get input
		/*
		System.out.printf("account1 balance : ");
		double m1 = input.nextDouble();
		System.out.printf("account2 balance : ");
		System.out.println();
		double m2 = input.nextDouble();
		*/
		
		// make two accounts
		CheckingBankAccount myBank1 = new CheckingBankAccount("account1", 100);		
		CheckingBankAccount myBank2 = new CheckingBankAccount("account2", 100);
		
		
		// use 1
		myBank1.balance();
		myBank2.balance();
		System.out.printf("\nEnter deposit amount for Account1 : ");
		double m11 = input.nextDouble();
		
		myBank1.credit(m11);

		
		// use 2
		myBank1.balance();
		myBank2.balance();
		System.out.printf("\nEnter withdrawal amount for Account2 : ");
		double m22 = input.nextDouble();
		
		myBank2.debit(m22);

		
		// print
		
		myBank1.balance();
		myBank2.balance();
		System.out.println("\nnext month!");
		myBank1.nextMonth();
		myBank2.nextMonth();
		myBank1.balance();
		myBank2.balance();
	}

}
