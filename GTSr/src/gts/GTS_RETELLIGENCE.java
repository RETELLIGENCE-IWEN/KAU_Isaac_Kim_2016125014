// Licencce
package gts;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GTS_RETELLIGENCE extends JComponent{

	private static final long serialVersionUID = -2451104197357070767L;
	static Scanner scan = new Scanner(System.in);	
	public static boolean isINIT = false;
	public static int NodeCount = 0;
	public static int X_limit = 13;
	public static int Y_limit = 13;
	
	public static Node[] NodeTable = new Node[(X_limit*Y_limit)];
	
	private static class Line{
	    final int x1; 
	    final int y1;
	    final int x2;
	    final int y2;   
	    final Color color;

	    public Line(int x1, int y1, int x2, int y2, Color color) {
	        this.x1 = x1;
	        this.y1 = y1;
	        this.x2 = x2;
	        this.y2 = y2;
	        this.color = color;
	    }               
	}

	private final LinkedList<Line> lines = new LinkedList<Line>();

	public void addLine(int x1, int x2, int x3, int x4) {
	    addLine(x1, x2, x3, x4, Color.black);
	}

	public void addLine(int x1, int x2, int x3, int x4, Color color) {
	    lines.add(new Line(x1,x2,x3,x4, color));        
	    repaint();
	}

	public void clearLines() {
	    //lines.clear();
	    //repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    for (Line line : lines) {
	        g.setColor(line.color);
	        g.drawLine(line.x1, line.y1, line.x2, line.y2);
	    }
	}
	

	
	static void newNode(int id, int population, int t){
		if (NodeCount < X_limit*Y_limit){
			if(t==3){
				Node temp = new Node(id, t);
				NodeTable[NodeCount] = temp;
				NodeCount += 1;
			}
			else if (t==2 || t==1){
				Node temp = new Node(id, population, t);
				NodeTable[NodeCount] = temp;
				NodeCount += 1;
			}
			else {
				// wrong type
				System.out.print("\nWrong type for new Node");
			}
		}
	}
	
	@SuppressWarnings("unused")
	static void delNode(int id){
		for (int i = 0; i<NodeTable.length; i++){
			if ((NodeTable[i].getPositionID())==id){
				int k = i;
				for(int j=k+1; j<NodeTable.length; j++){
					if(NodeTable[j]!=null){
						NodeTable[k]=NodeTable[j];
					}
					k+=1;
					break;
				}
			}
			NodeCount -= 1;
		}
	}
	
	public static Node getNode(int id){
		Node temp = new Node();
		for (int i = 0; i<NodeTable.length; i++){
			if ((NodeTable[i].getPositionID())==id){
				temp = NodeTable[i];
				return temp;
			}		
		}
		return null;
	}
	
	
	
	static void newRoad(int start, int end){
		int stat=0;
		for (int i = 0; i<NodeTable.length; i++){
			if ((NodeTable[i].getPositionID())==start){
				for (int j = 0; j<NodeTable.length; j++){
					if ((NodeTable[j].getPositionID())==end){
						NodeTable[i].Add_link_out(NodeTable[j]);
						NodeTable[j].Add_link_in(NodeTable[i]);
						System.out.print("\nNew Road Created");
						stat += 1 ;
						break;
					}
				}
			}
			if (stat==1){
				break;
			}
		}
	}

	static void Run(){
		int time;
		System.out.print("Enter steps : ");
		time = scan.nextInt();
		for (int i = 0; i<time; i++){
			// for all 
		}
		
	}
	
	static void print(){
		System.out.print("\nprint");
		for(int i = 0; i<NodeTable.length; i++){
			if(NodeTable[i]!=null){
				System.out.printf("\nNode %d : %d, %d    Type : %s   Polulation : %d", i, 
						(NodeTable[i].getPositionID())/100, (NodeTable[i].getPositionID())%100, 
						NodeTable[i].getType(), NodeTable[i].getPopulation());
			}
		}
	}
	

	
	
	
	
	
	public static void main(String[] args){


		//System.out.print((NodeTable(1).getPositionID()));

		// initialize
		
		// initialize grid
	
		// initialize nodes
		
		
		// GUI Frame
	    JFrame testFrame = new JFrame("Ground Transportation Simulation - RETELLIGENCE");
	    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    final GTS_RETELLIGENCE comp = new GTS_RETELLIGENCE();
	    comp.setPreferredSize(new Dimension(700, 800));
	    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
	   
	    // INTERFACE Frame
	    JFrame testFrame2 = new JFrame("Ground Transportation Simulation - RETELLIGENCE");
	    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    final GTS_RETELLIGENCE comp1 = new GTS_RETELLIGENCE();
	    comp1.setPreferredSize(new Dimension(700, 800));
	    testFrame.getContentPane().add(comp1, BorderLayout.CENTER);



	    JPanel buttonsPanel = new JPanel();
	    JPanel buttonsPanel2 = new JPanel();
	    JPanel inputPanel = new JPanel();
	    JButton initializeButton = new JButton("Initialize");
	    JButton newLineButton = new JButton("New Road");
	    JButton clearButton = new JButton("Clear");
	    JButton newNodeButton = new JButton("New Node");
	    JButton RUNButton = new JButton("Run (24h)");
	    JButton T1Button = new JButton("Preset 1");
	    JButton T2Button = new JButton("Preset 2");
	    JButton T3Button = new JButton("Preset 3");
	    

	    //buttonsPanel.add(initializeButton);
	    buttonsPanel.add(T1Button);
	    buttonsPanel.add(T2Button);
	    buttonsPanel.add(T3Button);
	    buttonsPanel.add(newNodeButton);
	    buttonsPanel.add(newLineButton);
	    buttonsPanel.add(RUNButton);
	    //buttonsPanel.add(clearButton);
	    testFrame2.getContentPane().add(buttonsPanel2, BorderLayout.SOUTH);
	    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	    testFrame.getContentPane().add(inputPanel, BorderLayout.NORTH);
	    
	    // Initialize
    	if(isINIT == false){
        	// Initializing
            int xline = 13, yline = 12;
            int startX = 50, startY=50;
            
            // Draw Horizontal lines
            int x1 = startX, y1 = startY;
            for (int i=0; i<=(xline); i++){
            	comp1.addLine(x1, y1, x1+(50*yline), y1, Color.LIGHT_GRAY);
            	y1 += (50);
            }
            // Draw vertical lines
            x1 = startX;
            y1 = startY;
            for (int i=0; i<=(yline); i++){
            	comp1.addLine(x1, y1, x1, y1+(50*xline), Color.LIGHT_GRAY);
            	x1 += (50);
            }
            isINIT = true;
    	}
    	
	    // New Road
	    newLineButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int xline = X_limit, yline = Y_limit;
	            int startX = 50, startY=50;
	            
	            // Draw Horizontal lines
	            int x1 = startX, y1 = startY;
	            for (int i=0; i<=(xline); i++){
	            	comp1.addLine(x1, y1, x1+(50*yline), y1, Color.LIGHT_GRAY);
	            	y1 += (50);
	            }
	            // Draw vertical lines
	            x1 = startX;
	            y1 = startY;
	            for (int i=0; i<=(yline); i++){
	            	comp1.addLine(x1, y1, x1, y1+(50*xline), Color.LIGHT_GRAY);
	            	x1 += (50);
	        	}
	        }
	    });
	    
	    // Clear
	    clearButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            comp1.clearLines();
	        }
	    });
	    
	    // New Node
	    newNodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isINIT == true){
					int inX, inY;
					int ttype;
					Color color;
					int population = 0;
					System.out.print("\n\n$ Node 0, 0 starts from top-left");
					System.out.print("\nEnter X, Y Coordinate of new Node : ");
					inX = scan.nextInt();
					inY = scan.nextInt();
					if(inX <= X_limit || inY <= Y_limit){
						System.out.print("$ Node type  [1 : Commercial district]  [2 : Residential district] [3 : Intersection]");
						System.out.print("\nEnter type of new Node : ");
						
						switch(ttype = scan.nextInt()){
						
						case 1 : color = Color.blue; 
						System.out.print("Enter Population : ");
						population = scan.nextInt(); break;
						
						case 2 : color = Color.magenta; 
						System.out.print("Enter Population : ");
						population = scan.nextInt(); break;
						
						case 3 : color = Color.DARK_GRAY; break;
						
						default : color = Color.magenta; break;
						}
						newNode((inX*100+inY), population, ttype);
			            int xline = 10, yline = 10;
			            int startX = 45+(inX*50), startY=45+(inY*50);
			            
			            // Draw Horizontal lines
			            int x1 = startX, y1 = startY;
			            for (int i=0; i<=(xline); i++){
			            	comp1.addLine(x1, y1, x1+(10), y1, color);
			            	y1 += 1;
			            }
			            // Draw vertical lines
			            x1 = startX;
			            y1 = startY;
			            for (int i=0; i<=(yline); i++){
			            	comp1.addLine(x1, y1, x1, y1+(10), color);
			            	x1 += 1;
			            }	
			            NodeCount += 1;
			            System.out.printf("New Node Created at %d, %d", inX, inY);
			            print();
					}
				}
			}
	    });
	    
	    // Initialize
	    initializeButton.addActionListener(new ActionListener() {
	    	// Initializing grid
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(isINIT == false){
		            int xline = 13, yline = 12;
		            int startX = 50, startY=50;
		            
		            // Draw Horizontal lines
		            int x1 = startX, y1 = startY;
		            for (int i=0; i<=(xline); i++){
		            	comp1.addLine(x1, y1, x1+(50*yline), y1, Color.LIGHT_GRAY);
		            	y1 += (50);
		            }
		            // Draw vertical lines
		            x1 = startX;
		            y1 = startY;
		            for (int i=0; i<=(yline); i++){
		            	comp1.addLine(x1, y1, x1, y1+(50*xline), Color.LIGHT_GRAY);
		            	x1 += (50);
		            }
		            isINIT = true;

	        	}
	        }
	    });
	    
	    // Run
	    RUNButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        		// 24시간 모니터륑
	        		// do something
	        	
	        }
	    });
	    
	    // Preset 1
	    T1Button.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	
	        }
	    });
	    

	    testFrame.pack();
	    testFrame.setVisible(true);
	    testFrame2.pack();
	    testFrame2.setVisible(true);

		
		// Run
	}

}
