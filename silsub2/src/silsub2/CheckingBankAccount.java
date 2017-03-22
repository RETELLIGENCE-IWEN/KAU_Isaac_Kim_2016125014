package silsub2;

public class CheckingBankAccount extends Bank{
	
	double credit_limit = -100.0;
	double interest = 0.1;
	double loan_interest = 0.7;
	
	@Override public void debit(double sub){
		if ((money-sub)<credit_limit){
			System.out.println("Debit amount exceeded account credit limit : unable to get money\n");
		}
		else{
			money = money - sub;
		}
	}
	
	public void nextMonth(){
		if (money>0){
			money = money + money*interest;
		}
		else if (money<0){
			money = money-(-1*(money*loan_interest));
		}
	}
	public CheckingBankAccount(String name, double money){
		super(name, money);
		this.name = name;
		this.money = money;
	}

}
