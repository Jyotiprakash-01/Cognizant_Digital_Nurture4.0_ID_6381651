package SingletonPatternExample;

public class Test {
	public static void main(String[] args) {
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		Logger logger1=Logger.getLogInstance();
		logger1.logDetails("First Logger Object is created which stores Logger object");
		Logger logger2=Logger.getLogInstance();
		logger2.logDetails("Second Logger Object is created which stores Logger object");
		
		System.out.println("Are the both object same = "+logger1.equals(logger2));
		System.out.println("Hashcode of logger1 = "+logger1.hashCode());
		System.out.println("Hashcode of logger2 = "+logger2.hashCode());
		
		/*
		 * At the first call getLogInstance() actually creates a static logger object and returns the reference for
		 * subsequent calls it only returns the reference of that static object so throughout the program
		 * an single object is created and shared among all this follows the principle of singleton design pattern.
		 */
		
	}
}
