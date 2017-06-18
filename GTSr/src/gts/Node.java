package gts;

public class Node {


	private int positionID;
	protected Road[] outLinks;
	protected Road[] inLinks;
	protected int population = 0;
	private String type;
	private int outLinkCount, inLinkCount;
	
	// Constructor (NormalArea)
	public Node(int pos, int pop, int t){
		this.positionID = pos;
		this.population = pop;
		if (t==2){
			type = "Residential area";
		}
		else if (t==1){
			type = "Commercial area";
		}
		else if (t==3){
			type = "Intersection";
		}
	}
	
	// Constructor Abstract (Intersection)
	public Node(int pos, int t){
		this.positionID = pos; // which means 'undefined'
		if (t==3){
			type = "Intersection";
		}
	}
	
	// Constructor Basic
	public Node(){
		this.positionID = 0; // which means 'undefined'
		this.type = "Undefined Node";
	}
	
	
	
	// Add out Link
	public void Add_link_out(Road target){
		
		// totally isolated before
		if (outLinkCount==0){
			outLinks = new Road[1];
			outLinks[0] = target;
			outLinkCount += 1;
		}
		else{
			Road[] temp = new Road[1 + (outLinkCount)];
			for (int i = 0; i<outLinkCount; i++){
				temp[i] = outLinks[i];
			}
			temp[-1] = target;
			outLinks = temp;
			outLinkCount += 1;
		}
	}
	
	// Add in Link
	public void Add_link_in(Road target){
		
		// totally isolated before
		if (inLinks==null){
			inLinks = new Road[1];
			inLinks[0] = target;
		}
		else{
			Road[] temp = new Road[1 + (inLinks.length)];
			temp[-1] = target;
			inLinks = temp;
		}
	}
	
	
	
	// Population Handler
	public int getPopulation(){
		return population;
	}
	public void setPopulation(int newval){
		this.population = newval;
	}
	
	// Type Handler
	public String getType(){
		return type;
	}
	
	// PositionID Handler
	public int getPositionID(){
		return this.positionID;
	}
	public void setPositionID(int newval){
		this.positionID = newval;
	}

	public void test() {
		System.out.print("Hello Sungsoo");
	}

	public void ressetRoads() {
		// TODO Auto-generated method stub
		
	}

}
