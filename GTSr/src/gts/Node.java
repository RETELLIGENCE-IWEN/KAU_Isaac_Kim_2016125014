package gts;

public class Node {

	private int positionID;
	protected Node[] outLinks;
	protected Node[] inLinks;
	protected int population = 0;
	private String type;
	
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
		outLinks = new Node[1];
		inLinks = new Node[1];
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
	public void Add_link_out(Node target){
		
		// totally isolated before
		if (outLinks==null){
			Node[] outlinks = new Node[1];
			outlinks[0] = target;
		}
		else{
			Node[] temp = new Node[1 + (outLinks.length)];
			temp[-1] = target;
			outLinks = temp;
		}
	}
	
	// Add in Link
	public void Add_link_in(Node target){
		
		// totally isolated before
		if (inLinks==null){
			Node[] inlinks = new Node[1];
			inlinks[0] = target;
		}
		else{
			Node[] temp = new Node[1 + (inLinks.length)];
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

}
