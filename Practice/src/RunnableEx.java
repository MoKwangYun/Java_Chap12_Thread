import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class Runnable1 implements Runnable{
	JLabel la;
	
	public Runnable1(JLabel la) {
		this.la = la;
	}
	public void run() {
		int n = 0;
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
public class RunnableEx extends JFrame{
	RunnableEx(){
		setTitle("Runnable Timer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel la = new JLabel();
		c.add(la);
		
		Runnable1 run = new Runnable1(la);
		Thread th = new Thread(run);
		
		JButton jb = new JButton("멈춰");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "멈춰", "Stop",JOptionPane.ERROR_MESSAGE);
				dispose();//확인 누르면 팝업다이얼로그와 프로그램 돌아가는 창 모두 사라짐
			}
		});
		
		c.add(jb);
		
		setVisible(true);
		setSize(300,300);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new RunnableEx();
	}
}
