package silsub2;

public class Human implements Valuable{

	private String name;
	private int age;
	
	public Human(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public double EstimateValue(int month) {
		return Double.POSITIVE_INFINITY;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	@Override
	public String toString(){
		return String.format("Hman name :  %s\nregistered age %d: ",name, age);
	}
}
