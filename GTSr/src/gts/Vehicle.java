package gts;

public class Vehicle {

	final int passengers;
	public V_position position;
	public Node start;
	public Node destination;
	
	public Vehicle(int pass, int bornID){
		passengers = pass;
		V_position position = new V_position(bornID);

	}
}
