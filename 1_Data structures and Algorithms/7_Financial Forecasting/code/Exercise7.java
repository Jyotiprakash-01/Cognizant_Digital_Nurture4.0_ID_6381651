import java.util.Scanner;
public class Exercise7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		System.out.println("Enter no of years");
		int years=sc.nextInt();
		System.out.println("Enter Present Value");
		double presentValue=sc.nextDouble();
		double growthRates[]=new double[years-1];
		System.out.println("Enter past "+(years-1)+" values/ growth rates:");
		for(int i=0;i<years-1;i++) {
			growthRates[i]=sc.nextDouble();
		}
		double finalValue=futureVaules(presentValue,growthRates,0);
		System.out.println("Final Predicted Value after "+years+" years "+finalValue);
        sc.close();
		
		/*
		 * Time Complexity: O(n) Average Case
		 * It would depend of Types of growth rates and the formula used to find growth rate
		 * as it is an open ended question i researched and assumed formula fit for the question to be
		 * presentValue*(1+growthRates[years]) according to my inputs.
		 * 
		 * To optimize recursive solutions one technique is Memorization or Caching techniques of Dynamic Programming
		 * Implement recursion where required other wise  solve the questions through iteration 
		 */
		
		
	}
	public static double futureVaules(double presentValue,double growthRates[],int years) {
		if(years==growthRates.length) {
			return presentValue;
		}
		double updatedValue=presentValue*(1+growthRates[years]);
		return futureVaules(updatedValue,growthRates,years+1);
	}
}
