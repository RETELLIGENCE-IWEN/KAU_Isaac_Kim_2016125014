package gts;

public class TrafficLight {
	private int state;
	private int Queue[];
	
	
	
	
	public void add(int id){
		int temp[];
		temp = new int[Queue.length+1];
		for (int i = 0; i<Queue.length; i++){
			temp[i] = Queue[i];
		}
		temp[-1] = id;
		Queue = temp;
	}
	
	public void Step(){
		// Queue[state+1] = open
		state = ((state+1)%state);
	}
}
