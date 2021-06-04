public class ExerciseTwo {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
			
		User1 user1 = new User1();
		user1.setCalculator(calculator);//name - nser1 ����
		user1.start();// -run()�� ���� -> setMemory(100)���� --> memory = 100 ���� & ���
			
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();	
		
	   }
}

class Calculator{
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	synchronized public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e){}
		
		System.out.println(Thread.currentThread().getName()+ ":"+this.memory);
	}// synchronized�� �������� print�� ������ �������� ����Ǵ� 50 or 100���� memory�� ��������� �ʴ´�.
}

class User1 extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}

}

class User2 extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}

}