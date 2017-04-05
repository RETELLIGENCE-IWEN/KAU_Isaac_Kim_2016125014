package silsub3;

public class Car implements Valuable{
	
	private String name;
	private double price;
	private int time;
	
	// constructor
	public Car(String name, double price){
		this.name = name;
		this.price = price;
	}

	@Override
	public double EstimateValue(int month) {
		time += month;
		price = (price*0.8)*(Math.pow((0.99), time));
		return price;
		
	}
	
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	@Override
	public String toString(){
		return String.format("Car name : %s\ninitial price : %f", name, price);
	}
}
