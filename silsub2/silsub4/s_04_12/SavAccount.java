package s_04_12;

public class SavAccount implements Valuable {
	private double interest;
	private double balance = 0;
	private int is = 0;
	private int time;
	private int up;
	
	public SavAccount(double balance, double inter) {
		this.balance = balance;
		this.interest = inter;	
	}

	
	public double getBalance(){
		return balance;
	}
	// 출금가능 금액
	public double getWithdraw(){
		if (time<12){
			return 0;
		}
		else{
			return(balance);
		}
	}
	
	// 출금
	public void debit(double out)
	throws Exception{
		if (out <0) throw new Exception("으음수 입려억");
		if(getWithdraw() > out){
			balance = (balance-out);			
		}
		else throw new Exception("한도초과^^ ㄲㅈ삼");
	}
	
	public void passTime(int t){
		time += t;
		
		balance = balance * Math.pow((1+interest), time);
		
	}



	@Override
	public double EstimateValue(int month) {
		passTime(month);
		return balance;
	}
	
	@Override
	public String toString(){
		return String.format("Saving Account Balance : %f", balance);
	}
}
