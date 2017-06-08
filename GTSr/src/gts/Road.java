package gts;

public class Road extends Node{
	
	private Vehicle[] lane;
	public Road[] connection;
	private int length;
	private double Congestion;
	
	
	
	public int enter(Vehicle newbe){
		// put new Vehicle object into appropriate lane 
		if(lane_is_full() == 1){// if successful
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public void exit(Vehicle betray){
		
	}
	
	public int lane_is_full(){
		// if lane is not full
		return 0; 
	}
	public void block(){
		// prevent more cars to enter this road
	}
	
	public void set(){
		// open road
	}
		
	
	public Road(int length, Node start, Node end){
		
	}

}
