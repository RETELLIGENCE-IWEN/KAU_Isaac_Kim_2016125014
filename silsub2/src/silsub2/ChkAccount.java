package silsub2;

public class ChkAccount implements Valuable {
	
	private double balance;
	final double loan_limit;
	final double interest;
	final double loa_interest;
	private int time;
	// ������ 
	public ChkAccount(double in, double limit, double inter, double lLinter){
		this.balance = in;
		this.loan_limit = limit;
		this.interest = inter;
		this.loa_interest = lLinter;
	}
	
	// ��ݰ��� �ݾ�
	public double getWithdraw(){
		if (balance+loan_limit<0){
			return 0;
		}
		else{
			return(balance+loan_limit);
		}
	}
	
	// ���
	public void debit(double out){
		if(getWithdraw() > out){
			balance = (balance-out);			
		}
	}
	
	// �ð��� ���Ӿ��� �帣�� tic-toc
	public void passTime(int t){
		time += t;
		if(balance>0){
			balance = (balance*Math.pow(1 + interest, time));
		}
		else if (balance<0){
			balance = (balance*Math.pow(1 + loa_interest, time));
		}
	}

	@Override
	public double EstimateValue(int month) {
		passTime(month);
		return balance;
	}
	
	@Override
	public String toString(){
		return String.format("Checking Avvount Balance : %f", balance);
	}
	
}
