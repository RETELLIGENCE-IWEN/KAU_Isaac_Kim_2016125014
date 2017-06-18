// License
package gts;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GTS_RETELLIGENCE extends JComponent{

	public static int GLOBAL_TIME;
	private static final long serialVersionUID = -2451104197357070767L;
	static Scanner scan = new Scanner(System.in);	
	public static boolean isINIT = false;
	public static int NodeCount = 0;
	public static int RoadCount = 0;
	public static int X_limit = 13;
	public static int Y_limit = 12;
	
	public static Node[] NodeTable = new Node[(X_limit*Y_limit)];
	public static Road[] RoadTable = new Road[(X_limit*Y_limit*16)];
	
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
	    lines.clear();
	    repaint();
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
		if(getNode(id)!=null){
			return;
		}
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
		else{
			// no more space
		}
	}

	static void NodeClear() {
		NodeCount = 0;
		RoadClear();
		NodeTable = new Node[(X_limit*Y_limit)];
		
	}
	
	public static Node getNode(int id){
		for (int i = 0; i<NodeCount; i++){
			if ((NodeTable[i].getPositionID())==id){
				return NodeTable[i];
			}		
		}
		return null;
	}
	
	
	
	static int newRoad(int sX, int sY, int dX, int dY, int type){
		Node tp1 = getNode((sX*100)+sY);
		Node tp2 = getNode((dX*100)+dY);
		if (tp1!=null && tp2!=null){
			Road temp = new Road(sX, sY, dX, dY, type, tp2);
			RoadTable[RoadCount] = temp;
			RoadCount += 1;
			//tp1.Add_link_out(temp);
			return 0;
		}
		else{
			System.out.println("\nUnable to create Road with incomplete connection");
			return 1;
		}	
	}
	
	static void RoadClear() {
		RoadCount = 0;
		RoadTable = new Road[(X_limit*Y_limit*16)];
		for (int i = 0; i< NodeCount; i++){
			NodeTable[i].ressetRoads();
		}
	}
	
	public static Node getRoad(int id){
		Node temp = new Node();
		for (int i = 0; i<NodeTable.length; i++){
			if ((NodeTable[i].getPositionID())==id){
				temp = NodeTable[i];
				return temp;
			}		
		}
		return null;
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
		// Printing Nodes
		for(int i = 0; i<NodeCount; i++){
			if(NodeTable[i]!=null){
				System.out.printf("\nNode %d : %d, %d    Type : %s   Polulation : %d", i, 
						(NodeTable[i].getPositionID())/100, (NodeTable[i].getPositionID())%100, 
						NodeTable[i].getType(), NodeTable[i].getPopulation());
			}
		}
		System.out.print("\n\n");
		
		// Printing Roads
		for(int i = 0; i<RoadCount; i++){
			if(RoadTable[i]!=null){
				System.out.printf("\nRode %d : %d, %d -> %d, %d    Type : %s ", i,
						RoadTable[i].getSX(), RoadTable[i].getSY(), RoadTable[i].getDX(), RoadTable[i].getDY(), RoadTable[i].getType());
			}
		}
		System.out.print("\n\n");
	}
	

	
	

	public static void main(String[] args) throws IOException{

		// initialize
		
		// initialize grid
	
		// initialize nodes
		
		
		// GUI Frame
	    JFrame testFrame = new JFrame("Ground Transportation Simulation - RETELLIGENCE");
	    testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    final GTS_RETELLIGENCE comp1 = new GTS_RETELLIGENCE();
	    comp1.setPreferredSize(new Dimension(700, 800));
	    testFrame.getContentPane().add(comp1, BorderLayout.CENTER);
	    testFrame.setLocation(500, 0);
	    
	    JPanel buttonsPanel = new JPanel();
	    JPanel inputPanel = new JPanel();
	    JButton initializeButton = new JButton("Initialize");
	    JButton newLineButton = new JButton("New Road");
	    JButton clearButton = new JButton("Clear");
	    JButton newNodeButton = new JButton("New Node");
	    JButton RUNButton = new JButton("Run (24h)");
	    JButton T1Button = new JButton("Preset 1");
	    JButton T2Button = new JButton("Preset 2");
	    JButton T3Button = new JButton("Preset 3");
	    JButton SaveButton = new JButton("Save");
	    //JLabel name = new JLabel("Ground Transformation Simulation");
	    
	    //buttonsPanel.add(initializeButton);
	    buttonsPanel.add(T1Button);
	    buttonsPanel.add(T2Button);
	    //buttonsPanel.add(T3Button);
	    buttonsPanel.add(newNodeButton);
	    buttonsPanel.add(newLineButton);
	    buttonsPanel.add(RUNButton);
	    buttonsPanel.add(clearButton);
	    buttonsPanel.add(SaveButton);
	    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	    testFrame.getContentPane().add(inputPanel, BorderLayout.NORTH);
	    Console console = new Console();
	    console.init();

	    		
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
	    initializeButton.doClick();
		Input tt = new Input(X_limit, Y_limit);
		System.out.print("Initialization Complete");
	    tt.setINIT(true);
	    																									
    	
	    // New Road
	    newLineButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
				if (isINIT == true){
					int sX, sY, dX, dY;
					int ttype;
					Color color;
		
					int[] input = new int[5];
					input = tt.getRoad();
					sX = input[0];
					sY = input[1];
					dX = input[2];
					dY = input[3];
					ttype = input[4];
					if(sX==99){
						return;
					}
	
					if(sX <= X_limit || sY <= Y_limit || dX <= X_limit || dY <= Y_limit){
						if(sX != dX && sY != dY){
							return;
						}
						if (newRoad(sX, sY, dX, dY, ttype)!=0){
							return;
						}
						
						switch(ttype){
						case 1 : color = Color.BLACK; break;
						case 2 : color = Color.CYAN;						
						case 3 : color = Color.ORANGE; break;
						default : color = Color.BLACK; break;
						}
						if (sX == dX){ // Vertical Road
							if (sY < dY){ // Top -> Down
								comp1.addLine(50+sX*50-3, 50+sY*50+5, 50+dX*50-3, 50+dY*50-5, color);
							}
							else{ // Bottom -> Up
								comp1.addLine(50+sX*50+3, 50+sY*50-5, 50+dX*50+3, 50+dY*50+5, color);
							}
						}
						else{ // Horizontal Road
							if (sX < dX){ // Left -> Right
								comp1.addLine(50+sX*50+5, 50+sY*50+3, 50+dX*50-5, 50+dY*50+3, color);
							}
							else{ // Right -> Left
								comp1.addLine(50+sX*50-5, 50+sY*50-3, 50+dX*50+5, 50+dY*50-3, color);
							}
						
						}
			            System.out.printf("\nNew Road Created form %d, %d   to %,d %d   TYPE : %d", sX, sY, dX, dY, ttype);
					}
				}
	        }
	    });
	    
	    // Clear
	    clearButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            comp1.clearLines();
	            isINIT = false;
	        }
	    });
	    
	    // New Node
	    newNodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isINIT == true){
					int inX, inY;
					int ttype=3;
					Color color;
					int population = 0;
	
					inX = (tt.getNode())[0];
					inY = (tt.getNode())[1];
					ttype = (tt.getNode())[2];
					population = (tt.getNode())[3];
					if(inX==99){
						return;
					}
		
					if(inX <= X_limit || inY <= Y_limit){
						
						switch(ttype){
						
						case 1 : color = Color.blue;  break;
						
						case 2 : color = Color.magenta; break;
						
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
			            System.out.printf("New Node Created at %d, %d", inX, inY);
			            print();
					}
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
	        	int isNODEin = 0;
	            String Xinfo, Yinfo, Tinfo, Pinfo;
	            String SX, SY, DX, DY;
	            // Erase previous % re-initialize
	            comp1.clearLines();
	            isINIT = false;
	            initializeButton.doClick();
	            NodeClear();
	            
	            
	            // Node INIT
	            try{
	            	BufferedReader br = new BufferedReader(new FileReader("c:/Users/iwins/Presets/p1/Nodes.txt"));
	                while(true) {
	                    String line = br.readLine();
	                    if (line==null) break;
	                    
	                    // get data
	                    Xinfo = line.split(";")[0];
	                    Yinfo = line.split(";")[1];
	                    Tinfo = line.split(";")[2];
	                    Pinfo = line.split(";")[3];
	                    int inX = Integer.parseInt(Xinfo);
	                    int inY = Integer.parseInt(Yinfo);
	                    int ttype = Integer.parseInt(Tinfo);
	                    int population = Integer.parseInt(Pinfo);
	                    
	                    // create node
	                    Color color;
						switch(ttype){
						case 1 : color = Color.blue; break;
						case 2 : color = Color.magenta; break;
						case 3 : color = Color.DARK_GRAY; break;
						default : color = Color.DARK_GRAY; break;
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
	                }
	                br.close();
	                isNODEin = 1;
	                console.out("\n<<Preset.1 all Nodes created>>");
	                //print();
	            }
	            catch (Exception e1) {
	            	System.out.print(e1);
	            	System.out.println("Error accoured while opening Node File : P1");
	            }
	            
	            // Road INIT
	            if (isNODEin==1){
		            try{
		            	BufferedReader br = new BufferedReader(new FileReader("c:/Users/iwins/Presets/p1/Roads.txt"));
		                while(true) {
		                    String line = br.readLine();
		                    if (line==null) break;
		                    
		                    // get data
		                    SX = line.split(";")[0];
		                    SY = line.split(";")[1];
		                    DX = line.split(";")[2];
		                    DY = line.split(";")[3];
		                    Tinfo = line.split(";")[4];
		                    int sX = Integer.parseInt(SX);
		                    int sY = Integer.parseInt(SY);
		                    int dX = Integer.parseInt(DX);
		                    int dY = Integer.parseInt(DY);
		                    int ttype = Integer.parseInt(Tinfo);

		                    // create node
		                    Color color;
							switch(ttype){
							case 1 : color = Color.BLACK; break;
							case 2 : color = Color.CYAN; break;
							case 3 : color = Color.ORANGE; break;
							default : color = Color.BLACK; break;
							}
							newRoad(sX, sY, dX, dY, ttype);
							if (sX == dX){ // Vertical Road
								if (sY < dY){ // Top -> Down
									comp1.addLine(50+sX*50-3, 50+sY*50+5, 50+dX*50-3, 50+dY*50-5, color);
								}
								else{ // Bottom -> Up
									comp1.addLine(50+sX*50+3, 50+sY*50-5, 50+dX*50+3, 50+dY*50+5, color);
								}
							}
							else{ // Horizontal Road
								if (sX < dX){ // Left -> Right
									comp1.addLine(50+sX*50+5, 50+sY*50+3, 50+dX*50-5, 50+dY*50+3, color);
								}
								else{ // Right -> Left
									comp1.addLine(50+sX*50-5, 50+sY*50-3, 50+dX*50+5, 50+dY*50-3, color);
								}
							
							}
		                }
		                br.close();
		                System.out.print("<<Preset.1 all Roads created>>");
		            }
		            catch (Exception e1) {
		            	System.out.print("Error accoured while opening Road File : P1");
		            }
	            }
                print();
	        }
	    });
	    
	    // Preset 2
	    T2Button.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int isNODEin = 0;
	            String Xinfo, Yinfo, Tinfo, Pinfo;
	            String SX, SY, DX, DY;
	            // Erase previous % re-initialize
	            comp1.clearLines();
	            isINIT = false;
	            initializeButton.doClick();
	            NodeClear();
	            
	            
	            // Node INIT
	            try{
	            	BufferedReader br = new BufferedReader(new FileReader("c:/Users/iwins/Presets/p2/Nodes.txt"));
	                while(true) {
	                    String line = br.readLine();
	                    if (line==null) break;
	                    
	                    // get data
	                    Xinfo = line.split(";")[0];
	                    Yinfo = line.split(";")[1];
	                    Tinfo = line.split(";")[2];
	                    Pinfo = line.split(";")[3];
	                    int inX = Integer.parseInt(Xinfo);
	                    int inY = Integer.parseInt(Yinfo);
	                    int ttype = Integer.parseInt(Tinfo);
	                    int population = Integer.parseInt(Pinfo);
	                    
	                    // create node
	                    Color color;
						switch(ttype){
						case 1 : color = Color.blue; break;
						case 2 : color = Color.magenta; break;
						case 3 : color = Color.DARK_GRAY; break;
						default : color = Color.DARK_GRAY; break;
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
	                }
	                br.close();
	                isNODEin = 1;
	                console.out("\n<<Preset.2 all Nodes created>>");
	                //print();
	            }
	            catch (Exception e1) {
	            	System.out.print(e1);
	            	System.out.println("Error accoured while opening Node File : P2");
	            }
	            
	            // Road INIT
	            if (isNODEin==1){
		            try{
		            	BufferedReader br = new BufferedReader(new FileReader("c:/Users/iwins/Presets/p2/Roads.txt"));
		                while(true) {
		                    String line = br.readLine();
		                    if (line==null) break;
		                    
		                    // get data
		                    SX = line.split(";")[0];
		                    SY = line.split(";")[1];
		                    DX = line.split(";")[2];
		                    DY = line.split(";")[3];
		                    Tinfo = line.split(";")[4];
		                    int sX = Integer.parseInt(SX);
		                    int sY = Integer.parseInt(SY);
		                    int dX = Integer.parseInt(DX);
		                    int dY = Integer.parseInt(DY);
		                    int ttype = Integer.parseInt(Tinfo);

		                    // create node
		                    Color color;
							switch(ttype){
							case 1 : color = Color.BLACK; break;
							case 2 : color = Color.CYAN; break;
							case 3 : color = Color.ORANGE; break;
							default : color = Color.BLACK; break;
							}
							newRoad(sX, sY, dX, dY, ttype);
							if (sX == dX){ // Vertical Road
								if (sY < dY){ // Top -> Down
									comp1.addLine(50+sX*50-3, 50+sY*50+5, 50+dX*50-3, 50+dY*50-5, color);
								}
								else{ // Bottom -> Up
									comp1.addLine(50+sX*50+3, 50+sY*50-5, 50+dX*50+3, 50+dY*50+5, color);
								}
							}
							else{ // Horizontal Road
								if (sX < dX){ // Left -> Right
									comp1.addLine(50+sX*50+5, 50+sY*50+3, 50+dX*50-5, 50+dY*50+3, color);
								}
								else{ // Right -> Left
									comp1.addLine(50+sX*50-5, 50+sY*50-3, 50+dX*50+5, 50+dY*50-3, color);
								}
							
							}
		                }
		                br.close();
		                System.out.print("<<Preset.2 all Roads created>>");
		            }
		            catch (Exception e1) {
		            	System.out.print("Error accoured while opening Road File : P2");
		            }
	            }
	        }
	    });

	    
	    // Preset 3
	    T3Button.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int isNODEin = 0;
	            String Xinfo, Yinfo, Tinfo, Pinfo;
	            String SX, SY, DX, DY;
	            // Erase previous % re-initialize
	            comp1.clearLines();
	            isINIT = false;
	            initializeButton.doClick();
	            NodeClear();
	            RoadClear();
	            
	            
	            // Node INIT
	            try{
	            	BufferedReader br = new BufferedReader(new FileReader("c:/Users/iwins/Presets/p3/Nodes.txt"));
	                while(true) {
	                    String line = br.readLine();
	                    if (line==null) break;
	                    
	                    // get data
	                    Xinfo = line.split(";")[0];
	                    Yinfo = line.split(";")[1];
	                    Tinfo = line.split(";")[2];
	                    Pinfo = line.split(";")[3];
	                    int inX = Integer.parseInt(Xinfo);
	                    int inY = Integer.parseInt(Yinfo);
	                    int ttype = Integer.parseInt(Tinfo);
	                    int population = Integer.parseInt(Pinfo);
	                    
	                    // create node
	                    Color color;
						switch(ttype){
						case 1 : color = Color.blue; break;
						case 2 : color = Color.magenta; break;
						case 3 : color = Color.DARK_GRAY; break;
						default : color = Color.DARK_GRAY; break;
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
	                }
	                br.close();
	                isNODEin = 1;
	                console.out("\n<<Preset.3 all Nodes created>>");
	                //print();
	            }
	            catch (Exception e1) {
	            	System.out.print("Error accoured while opening Node File : P3");
	            }
	            
	            // Road INIT
	            if (isNODEin==1){
		            try{
		            	BufferedReader br = new BufferedReader(new FileReader("c:/Users/iwins/Presets/p3/Roads.txt"));
		                while(true) {
		                    String line = br.readLine();
		                    if (line==null) break;
		                    
		                    // get data
		                    SX = line.split(";")[0];
		                    SY = line.split(";")[1];
		                    DX = line.split(";")[2];
		                    DY = line.split(";")[3];
		                    Tinfo = line.split(";")[4];
		                    int sX = Integer.parseInt(SX);
		                    int sY = Integer.parseInt(SY);
		                    int dX = Integer.parseInt(DX);
		                    int dY = Integer.parseInt(DY);
		                    int ttype = Integer.parseInt(Tinfo);
		                    
		                    // create node
		                    Color color;
							switch(ttype){
							case 1 : color = Color.BLACK; break;
							case 2 : color = Color.CYAN; break;
							case 3 : color = Color.ORANGE; break;
							default : color = Color.BLACK; break;
							}
							newRoad(sX, sY, dX, dY, ttype);
							if (sX == dX){ // Vertical Road
								if (sY < dY){ // Top -> Down
									comp1.addLine(50+sX*50-3, 50+sY*50+5, 50+dX*50-3, 50+dY*50-5, color);
								}
								else{ // Bottom -> Up
									comp1.addLine(50+sX*50+3, 50+sY*50+5, 50+dX*50+3, 50+dY*50-5, color);
								}
							}
							else{ // Horizontal Road
								if (sX < dX){ // Left -> Right
									comp1.addLine(50+sX*50+5, 50+sY*50+3, 50+dX*50-5, 50+dY*50+3, color);
								}
								else{ // Right -> Left
									comp1.addLine(50+sX*50+5, 50+sY*50-3, 50+dX*50-5, 50+dY*50-3, color);
								}
							
							}
							newRoad(sX, sY, dX, dY, ttype);
				            RoadCount += 1;
		                }
		                br.close();
		                System.out.print("<<Preset.3 all Roads created>>");
		            }
		            catch (Exception e1) {
		            	System.out.print("Error accoured while opening Node File : P3");
		            }
	            }
	        }

	    });
	    
	    

	    testFrame.pack();
	    testFrame.setVisible(true);
	    
	    
	 
		
		// Run
	}

}
