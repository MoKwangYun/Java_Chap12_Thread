import java.awt.*;
import javax.swing.*;

class Thread1 extends Thread{
	JLabel la;
	public Thread1(JLabel la) {
		this.la = la;
	}
	public void run() {
		int n = 1;
		while(true) {
			la.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {return;}
		}
	}
}
public class TimerThread extends JFrame{
	TimerThread(){
		setTitle("TimerThread");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel la = new JLabel();
		c.add(la);
		
		Thread1 th = new Thread1(la);
		
		setVisible(true);
		setSize(300,300);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new TimerThread();
	}
}
