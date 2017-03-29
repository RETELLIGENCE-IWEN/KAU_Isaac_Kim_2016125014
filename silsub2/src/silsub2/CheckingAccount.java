package silsub2;

public class CheckingAccount extends Account{
	
	final double loan_limit;
	final double interest;
	final double loa_interest;
	
	// »ý¼ºÀÚ 
	public CheckingAccount(double in, double limit, double inter, double lLinter){
		super(in);
		this.loan_limit = limit;
		this.interest = inter;
		this.loa_interest = lLinter;
	}
	
	@Override
	public double getWithdrawableAccount(){
		if (getBalance()+loan_limit<0){
			return 0;
		}
		else{
			return(getBalance()+loan_limit);
		}
	}
	
	public void debit(double out){
		setBalance(getBalance()-out);
	}
	
	public boolean isBankrupted(){
		if (getBalance()+loan_limit >= 0){
			return (false);
		}
		else{
			return true;
		}
	}

	
	
	public void passTime(int t){
		setTime(t+getTimepast());
		
		if(getBalance()>0){
			setBalance(getBalance()*Math.pow(1 + interest, t));
		}
		else if (getBalance()<0){
			setBalance(getBalance()*Math.pow(1 + loa_interest, t));
		}
	}
	
}
