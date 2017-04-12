package s_04_12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Atest {

	public static void main(String args[]){
		ChkAccount ac1 = new ChkAccount(100,50,0.01,0.07);
		SavAccount ac2 = new SavAccount(100,0.05);
		
		Scanner scan = new Scanner(System.in);
		
		
		double amount;
		
		try{
			System.out.println("Enter deposit amount for Account 1 : ");
			amount = scan.nextDouble();
			ac1.debit(amount);
			System.out.println("Account 1 balance : $" + ac1.getBalance());
			
			System.out.println("Enter deposit amount for Account 2 : ");
			amount = scan.nextDouble();
			ac2.debit(amount);
			System.out.println("Account 2 balance : $" + ac2.getBalance());
		} 
		
		catch (InputMismatchException e) {
			System.out.println("예외발생 : 숫자를 입혈하세요 \n" + e.toString());
			}
		catch (Exception e) {
			System.out.println("예외발생 : " + e.toString());
		}
		

		
		finally{
			ac1.passTime(2);
			System.out.println("2month later account 1 : " + ac1.getBalance());
		}
		
		
	}
}
