package gts;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Test2 {
	private int inX, inY, tp, pop;
	private int SX, SY, DX, DY, TP;
	private boolean isINIT = false;
	public int Nready=0, Rready=0;
	public void setINIT(boolean a){
		isINIT = a;
	}
	
	public int[] getNode(){
		int[] NN = new int[4];
		NN[0] = inX;
		NN[1] = inY;
		NN[2] = tp;
		NN[3] = pop;
		return NN;
	}
	
	public int[] getRoad(){
		int[] NN = new int[5];
		NN[0] = SX;
		NN[1] = SY;
		NN[2] = DX;
		NN[3] = DY;
		NN[4] = TP;
		return NN;
	}
	
	public Test2(){
		
	    JFrame frame = new JFrame("System Input");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(500, 500));
	    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
	    frame.setLocation(1250, 0);
	    
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
				int inX, inY, tp, pop;
				try{
					inX = Integer.parseInt(textfield.getText());
					inY = Integer.parseInt(textfield2.getText());
					tp = Integer.parseInt(textfield12.getText());
					pop = Integer.parseInt(textfield13.getText());
				}
				catch (Exception e1) {
					return;
				}
				System.out.printf("x: %d    y: %d    T: %d    pop: %d", inX, inY, tp, pop);
				Nready = 1;
				// make
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
				System.out.print("B2");
			}
		});
        
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        
        JLabel n1 = new JLabel("Add New Node");
        JLabel n2 = new JLabel("Add New Road");
        //n1.setFont(font);

        JLabel b11 = new JLabel("            "); 
        JLabel b22 = new JLabel("            ");
        JLabel b33 = new JLabel("            ");
        JLabel b44 = new JLabel("             ");
        JLabel b55 = new JLabel("            ");
        JLabel b66 = new JLabel("            ");
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

        frame.add(n1);
        frame.add(panel);
        frame.add(n2);
        frame.add(panel2);
        
        frame.pack();
        frame.setVisible(true);

	}

};
