package gts;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class Input {
	private int inX = 99, inY = 99, tp = 99, pop = 99;
	private int SX = 99, SY = 99, DX = 99, DY = 99, TP = 99;
	private boolean isINIT = false;
	private int x_limit, y_limit;

	int[] RN, NN;

	public void setINIT(boolean a){
		isINIT = a;
	}
	
	public int[] getNode(){
		NN = new int[4];
		NN[0] = inX;
		NN[1] = inY;
		NN[2] = tp;
		NN[3] = pop;
		return NN;
	}
	
	public int[] getRoad(){
		RN = new int[5];
		RN[0] = SX;
		RN[1] = SY;
		RN[2] = DX;
		RN[3] = DY;
		RN[4] = TP;
		return RN;
	}
	
	public Input(int xl, int yl){
		x_limit = xl;
		y_limit = yl;
	    JFrame frame = new JFrame("System Input");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(500, 500));
	    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
	    frame.setLocation(30, 200);
	    
        JTextField textfield = new JTextField("", 6);
        JTextField textfield2 = new JTextField("", 6);
        JTextField textfield3 = new JTextField("", 5);
        JTextField textfield4 = new JTextField("", 5);
        JTextField textfield5 = new JTextField("", 5);
        JTextField textfield6 = new JTextField("", 5);
        JTextField textfield12 = new JTextField("", 6);
        JTextField textfield23 = new JTextField("", 6);
        JTextField textfield13 = new JTextField("", 6);
        
        
        JButton b1 = new JButton("New Node");
        b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (isINIT == true){
				try{
					inX = Integer.parseInt(textfield.getText());
					inY = Integer.parseInt(textfield2.getText());
					tp = Integer.parseInt(textfield12.getText());
					pop = Integer.parseInt(textfield13.getText());
					if(inX>x_limit || inX<0 || inY>y_limit || inY<0 ||tp>3 || tp<0 || pop<0){
						inX = 99;
						inY = 99;
						tp = 99;
						pop = 99;
					}
				}
				catch (Exception e1) {
					return;
				}
				textfield.setText("");
				textfield2.setText("");
				textfield12.setText("");
				textfield13.setText("");
				}
			}
		});
       
        
        JButton b2 = new JButton("New Road");
        b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isINIT == true){
					try{
						SX = Integer.parseInt(textfield3.getText());
						SY = Integer.parseInt(textfield4.getText());
						DX = Integer.parseInt(textfield5.getText());
						DY = Integer.parseInt(textfield6.getText());
						TP = Integer.parseInt(textfield23.getText());
						if(SX>x_limit || SX<0 || SY>y_limit || SY<0 ||DX>x_limit || DX<0 || DY>y_limit || DY<0 || TP>3 || TP<0){
							SX = 99;
							SY = 99;
							DX = 99;
							DY = 99;
							TP = 99;
						}
					}
					catch (Exception e1) {
						return;
					}
					textfield3.setText("");
					textfield4.setText("");
					textfield5.setText("");
					textfield6.setText("");
					textfield23.setText("");
					}
			}
		});
        
        
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel paneli = new JPanel();

        JLabel i = new JLabel("NOTICE : Enter infromation of new 'Node' or 'Road'");
        JLabel i2 = new JLabel("and click the 'New Node' or 'New Road' button. ");
        JLabel i3 = new JLabel("Then switch to the main window and press 'New Node'"); 
        JLabel i4 = new JLabel( "or 'New Road' button on main window");
        paneli.add(i);
        paneli.add(i2);
        paneli.add(i3);
        paneli.add(i4);
        
        JLabel n1 = new JLabel("[ Add New Node ]");
        JLabel n2 = new JLabel("[ Add New Road ]");
        n1.setFont(new Font("Courier", Font.BOLD, 16));
        n2.setFont(new Font("Courier", Font.BOLD, 16));
        

        JLabel b11 = new JLabel("            "); 
        JLabel b22 = new JLabel("            ");
        JLabel b33 = new JLabel("            ");
        JLabel b44 = new JLabel("             ");
        JLabel b55 = new JLabel("            ");
        JLabel jl = new JLabel("X Coordinate");
        JLabel j2 = new JLabel("Y Coordinate");
        JLabel j3 = new JLabel("Start X");
        JLabel j4 = new JLabel("Start Y");
        JLabel j5 = new JLabel("Dest. X");
        JLabel j6 = new JLabel("Dest. Y");
        JLabel j12 = new JLabel("                  Node Type");
        JLabel j23 = new JLabel("    Road Type");
        JLabel j13 = new JLabel("   Population");
        
        panel.add(b11);
        panel.add(jl);
        panel.add(textfield);
        panel.add(b22);
        panel.add(j2);
        panel.add(textfield2);
        panel.add(b33);
        
        panel.add(j12);
        panel.add(textfield12);
        panel.add(b44);
        panel.add(j13);
        panel.add(textfield13);
        panel.add(b55);
        panel.add(b1);
        
        panel2.add(j3);
        panel2.add(textfield3);
        panel2.add(j4);
        panel2.add(textfield4);
        panel2.add(j5);
        panel2.add(textfield5);
        panel2.add(j6);
        panel2.add(textfield6);
        
        panel2.add(j23);
        panel2.add(textfield23);
        panel2.add(b2);
        
        panel.setSize(new Dimension(100, 100));
        
        
        frame.add(n1);
        frame.add(panel);
        frame.add(n2);
        frame.add(panel2);
        frame.add(paneli);
        
        frame.pack();
        frame.setVisible(true);

	}

};
