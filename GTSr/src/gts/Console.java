package gts;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Console {
	  JTextArea textArea;
	  final JFrame frame = new JFrame("System Log");
	  public Console() {
	    textArea = new JTextArea(40, 80);
	    textArea.setBackground(Color.BLACK);
	    textArea.setForeground(Color.ORANGE);
	    textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
	    System.setOut(new PrintStream(new OutputStream() {
	      @Override
	      public void write(int b) throws IOException {
	        textArea.append(String.valueOf((char) b));
	      }
	    }));
	    frame.add(textArea);
	  }
	  public void init() {
	    frame.pack();
	    frame.setVisible(true);
	  }
	  public JFrame getFrame() {
	    return frame;
	  }
	  public void out(String arg){
		  System.out.println(arg);
	  }
}
