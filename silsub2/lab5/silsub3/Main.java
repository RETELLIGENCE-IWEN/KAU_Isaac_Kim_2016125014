package silsub3;

public class Main{

	public static void main(String args[]){
		Valuable[] objectlist = new Valuable[4];	
		
		ChkAccount acc_1 = new ChkAccount(100, 50, 0.01, 0.07);
		SavAccount acc_2 = new SavAccount(100, 0.05);
		Human me = new Human("Isaac", 23);
		Car please = new Car("Boxter", 20000);
	
		
		objectlist[0] = acc_1;
		objectlist[1] = acc_2;
		objectlist[2] = me;
		objectlist[3] = please;
		
		
		
		for (Valuable objectItem : objectlist){
			System.out.printf("%s \n", objectItem.toString());
			System.out.printf("6months later Valuable : %.2f \n\n", objectItem.EstimateValue(6));
		}
	}
}
