import java.awt.*;
import javax.swing.*;

public class SynchronizedEx {
	public static void main(String[] args) {
		Printer p = new Printer();
		String[] ar= {"동해물과 ","백두산이 ","마르고 ","닳도록 ","하나님이","보우하사"};
		String[] arr= {"Hello","My name is","Luka Doncici","i am","basketball"," player"};
		
		Thread th1 = new WorkThread(p,ar);
		Thread th2 = new WorkThread(p,arr);
		
		th1.start();
		th2.start();
	}

}

class Printer{
	synchronized void print(String text) {
		for(int i = 0;i<text.length();i++) {
			System.out.print(text.charAt(i));
		}
		System.out.println();
	}
}

class WorkThread extends Thread{
	Printer p;
	String[] text;
	
	WorkThread(Printer p,String []text){
		this.p = p;
		this.text = text;
	}
	
	public void run() {
		for(int i = 0;i<text.length;i++) {
			p.print(text[i]);
		}
	}
}