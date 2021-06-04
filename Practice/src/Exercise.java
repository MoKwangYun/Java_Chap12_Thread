import java.util.Scanner;
class ThreadOne extends Thread{
	int n;
	
	ThreadOne(int n){
		this.n = n;
	}
	public void run() {
		for(int i=1; i<=n; i++) {
			 System.out.print(i);
			 if(i%10 == 0) 
				 System.out.println();
			 else System.out.print("\t");
		 	}
		 }
	}

public class Exercise {
	public static void main(String[] agrs) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		ThreadOne th = new ThreadOne(x);
		th.start();
	}
}
