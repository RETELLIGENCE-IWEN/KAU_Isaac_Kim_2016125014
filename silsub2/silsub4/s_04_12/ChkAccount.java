package s_04_12;

public class ChkAccount implements Valuable {
	
	private double balance;
	final double loan_limit;
	final double interest;
	final double loa_interest;
	private int time;
	// 생성자 
	public ChkAccount(double in, double limit, double inter, double lLinter){
		this.balance = in;
		this.loan_limit = limit;
		this.interest = inter;
		this.loa_interest = lLinter;
	}
	
	
	public double getBalance(){
		return balance;
	}
	// 출금가능 금액
	public double getWithdraw(){
		if (balance+loan_limit<0){
			return 0;
		}
		else{
			return(balance+loan_limit);
		}
	}
	
	// 출금
	// 출금
	public void debit(double out)
	throws Exception{
		if (out <0) throw new Exception("으음수 입려억");
		if(getWithdraw() > out){
			balance = (balance-out);			
		}
		else throw new Exception("한도초과^^ ㄲㅈ삼");
	}
	
	
	// 시간이 끊임없이 흐르지 tic-toc
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
