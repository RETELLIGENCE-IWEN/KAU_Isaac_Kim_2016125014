package silsub2;

public abstract class Account {
	private double balance;
	private int timePast;
	
	public Account(double balance){
		this.balance = balance;
		timePast = 0;
	}
	
	public void setBalance(double neww){
		balance = neww;
	}
	
	public double getBalance(){
		return balance;
	}

	
	public abstract double getWithdrawableAccount();
	public abstract void passTime(int t);
	/*
	public void debit(double out){
		if (out > balance){
			// error
		}
		else{
			balance = balance - out;
		}
	}
	*/
	public int getTimepast(){
		return timePast;
	}
	public void setTime(int t){
		timePast = t;
	}
}
