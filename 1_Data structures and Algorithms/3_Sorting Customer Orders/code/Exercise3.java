
import java.util.Scanner;
class Order{
	int orderId;
	String customerName;
	double totalPrice;
	public Order(int orderId,String customerName,double totalPrice){
		this.orderId=orderId;
		this.customerName=customerName;
		this.totalPrice=totalPrice;
	}
	public String toString() {
		return "Order ID : "+orderId+", Customer Name : "+customerName+", Total Price : "+totalPrice;
	}
	//This class can be encapsulated by using private data members and public functions and getter setter methods
	//but keeping the data members public for easy retrieval and implementation thereby reducing the complexity of whole application.
}
public class Exercise3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter total no of items to be stored in order list");
//		int totalItems=sc.nextInt();
//		Order order[]=new Order[totalItems];
//	
//		System.out.println("Enter Order Id, Customer Name, Total price");
//		for(int i=0;i<totalItems;i++) {
//			order[i]=new Order(sc.nextInt(),sc.next(),sc.nextDouble());
//		}
		
//		/Statically adding Products
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		
		Order order[]=new Order[10];
		
		order[0]=new Order(1001,"Samay  ",15000.23);
		order[1]=new Order(1002,"Priya  ",780.87);
		order[2]=new Order(1003,"Naveen ",5600.45);
		order[3]=new Order(1004,"Amrita ",3782.23);
		order[4]=new Order(1005,"Gourav ",4679.12);
		order[5]=new Order(1006,"Ritika ",2398.67);
		order[6]=new Order(1007,"Sanjeev",200.50);
		order[7]=new Order(1008,"Devraj ",7899.66);
		order[8]=new Order(1009,"Rajesh ",1050.00);
		order[9]=new Order(1010,"Nikita ",5678.89);
		System.out.println("Before Sorting\n");
		for(int i=0;i<order.length;i++) {
			System.out.println(order[i]);
		}
		System.out.println("\nEnter Which sorting algorithm you want to use bubble-BubbleSort, quick-quickSort");
		String userChoice=sc.next();
		if(userChoice.trim().equals("bubble")) {
			BubbleSort(order,order.length);
			System.out.println("\nSorted by price");
		}
		else if(userChoice.trim().equals("quick")) {
			QuickSort(order,0,order.length-1);
			System.out.println("Sorted By Quick Sort");
			System.out.println("\nSorted by price");
		}
		else {
			System.out.println("Invalid Input");
		}
		
		
		for(int i=0;i<order.length;i++) {
			System.out.println(order[i]);
		}
		sc.close();
	/*
	 *Time Complexity:
	 *	Bubble Sort: O(n^2)
	 * 	Quick Sort: O(n*log(n))
	 * 
	 * Quick Sort is preferred over Bubble sort due to its significantly better average case time complexity than Bubble sort
	 * 
	 */
	}
	public static void BubbleSort(Order order[],int orderLength) {
		Order tempOrder=null;
		for(int i=0;i<orderLength;i++) {
			for(int j=0;j<orderLength-1;j++) {
				if(order[j].totalPrice > order[j+1].totalPrice) {
					tempOrder=order[j];
					order[j]=order[j+1];
					order[j+1]=tempOrder;
					
				}
			}
		}
		
		tempOrder=null;
		System.out.println("Sorted By Bubble Sort");
	}
	public static void QuickSort(Order order[],int low,int high) {
		
		if(low<high) {
			int q=Partition(order,low,high);
			
			QuickSort(order,low,q-1);
			QuickSort(order,q+1,high);
		}
		
	}
	public static int Partition(Order order[],int low,int high) {
		//Using Lomuto's Partition
		double pivot=order[high].totalPrice;
		int i=low-1;
		
		for(int j=low;j<high;j++) {
			if(order[j].totalPrice<pivot) {
				i++;
				swap(order,i,j);
			}
		}
		swap(order,i+1,high);
		return i+1;
	}
	public static void swap(Order order[],int order1,int order2) {
		Order tempOrder=order[order1];
		order[order1]=order[order2];
		order[order2]=tempOrder;
		tempOrder=null;//Referencing to null so that this reference/object should get deleted during automatic garbage collection
	}
	
}

