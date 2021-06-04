import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class InterruptEx extends JFrame implements Runnable{
	Thread th;
	
	InterruptEx(){
		setTitle("Hmm..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setSize(200,200);
		setVisible(true);
		
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive())
					return;
				th.interrupt();
			}
		});
		
		th = new Thread(this);
		th.start();
	}
	
	public void run() {
		Random r = new Random();
		while(true) {
			try{
		
			Thread.sleep(20);
			}
			catch(InterruptedException e) {
				return;
			}	
			int x = getX()+r.nextInt()%5;
			int y = getX()+r.nextInt()%5;
			setLocation(x,y);
		}
	}
	public static void main(String[] args) {
		new InterruptEx();
	}
}
