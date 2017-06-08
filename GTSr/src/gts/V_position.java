package gts;

public class V_position {
	// on what Node 
	private Node cNode;
	private int laneN;
	private int indexN;
	private String state;
	
	
	public V_position(int bornID){

		state = "initialized";
	}
	
	public void V_enterNew(Node dest){
		Node temp = new Node();
		temp = cNode; 
		cNode = dest;
		
		state = String.format("*From : %i|| *Entering node : &i",  temp.getPositionID(), cNode.getPositionID());
	}
	
	public String getState(){ 
		return state;
	}
}
