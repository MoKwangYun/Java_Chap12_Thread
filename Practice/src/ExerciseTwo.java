public class ExerciseTwo {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
			
		User1 user1 = new User1();
		user1.setCalculator(calculator);//name - nser1 설정
		user1.start();// -run()을 실행 -> setMemory(100)실행 --> memory = 100 설정 & 출력
			
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
	}// synchronized를 붙임으로 print될 때까지 다음으로 실행되는 50 or 100으로 memory가 덮어씌워지지 않는다.
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