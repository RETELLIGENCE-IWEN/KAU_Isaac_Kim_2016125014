package gts;

public class Road{
	
	private int SX, SY, DX, DY;
	private String type;

	
	private Vehicle[] lane;
	public Node LinkOut;
	private int length;
	private double Congestion;
	private int Usage_t[];
	
	public Road(int len, Node Link){
		length = len;
		LinkOut = Link;
		lane = new Vehicle[length];
	}

	public Road(int sX, int sY, int dX, int dY, int Type, Node link) {
		SX = sX;
		SY = sY;
		DX = dX;
		DY = dY;
	
		switch(Type){
		case 1: type = "General"; break;
		case 2: type = "Overpass"; break;
		case 3: type = "Underpass"; break;
		default : type = "General"; break;
		}
		// Vertical road
		if (SX==DX){
			length = Math.abs(DY-SY);
			length *= 60;
		}	
	}
	
	public int getSX(){
		return SX;
	}
	public int getSY(){
		return SY;
	}
	public int getDX(){
		return DX;
	}
	public int getDY(){
		return DY;
	}
	public String getType(){
		return type;
	}

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
}
