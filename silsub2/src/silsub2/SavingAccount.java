package silsub2;

public class SavingAccount extends Account{

	private double interest;
	private int is = 0;
	
	public SavingAccount(double balance, double inter) {
		super(balance);
		this.interest = inter;
		
	}

	public void debit(double out){
		if (getTimepast()<12){
			// cant do it
		}
		else{
			if(getBalance()<out){
				//cant do it
			}
			else{
				setBalance(getBalance() - out);
			}
		}
	}
	
	
	public void passTime(int t){
		setTime(t+getTimepast());
		
		if (getTimepast()>=12&&is==0){
			setBalance(getBalance() * Math.pow((1+interest), 12)) ;
			is = 1;
		}
	}
	
	
	public double getWithdrawableAccount() {
		if (getTimepast()<12){
			return 0;
		}
		else{
		return getBalance();
		}
	}

	
}
