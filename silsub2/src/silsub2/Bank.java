package silsub2;

public class Bank {
	
	private double money;
	public final String name;
	
	
	public void credit(double add){
		money = money + add;
	}
	
	public void balance(){
		System.out.printf("%s balance : $%f\n", name, money);
	}
	
	public void debit(double sub){
		if (money<sub){
			System.out.println("Debit amount exceeded account balance\n");
		}
		
		else{
			money = money - sub;
			System.out.printf("substracting $%f from %s balance\n", sub, name);
		}
		
	}
	
	public Bank(String name, double money){
		this.name = name;
		this.money = money;
	}

}
