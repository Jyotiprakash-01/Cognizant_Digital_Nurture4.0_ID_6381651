
public class Calculator {
	
	public int add(int a,int b) {
		return a+b;
	}
	public int subtract(int a,int b) {
		return a-b;
	}
	public int multiply(int a,int b) {
		return a*b;
	}
	public int divide(int a,int b) {
		int result=0;
		try {
			result=a/b;
		}
		catch(ArithmeticException e) {
			
			System.out.println(e.getMessage());
			return -1;
		}
		return result;
	}	

}
