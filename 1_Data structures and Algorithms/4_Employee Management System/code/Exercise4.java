
import java.util.Scanner;

class Employee{
	int employeeId;
	String employeeName;
	String employeePosition;
	double employeeSalary;
	
	public Employee(int employeeId,String employeeName,String employeePosition,double employeeSalary) {
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.employeePosition=employeePosition;
		this.employeeSalary=employeeSalary;
		
	}
	
	public String toString() {
		return "Employee Id : " + employeeId + ", Name : " + employeeName + ", Position  : "
				+ employeePosition + ", Salary : " + employeeSalary ;
	}
}
public class Exercise4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*Dynamic Array Implementation, Employee Objects Stored in a ArrayList

		ArrayList <Employee> employee=new ArrayList<>(5);

		employee.add(new Employee(1001,"Hardik","Manager",95000.00));
		employee.add(new Employee(1002,"Smita","HR",70000.00));
		employee.add(new Employee(1003,"Sameer","Tech Lead",85000.00));
		employee.add(new Employee(1004,"Abhishek","Junior Dev",60000.00));
		employee.add(new Employee(1005,"Priyanka","Regional Head",150000.00));
		
		Disadvantages of using static array ,it is fixed and we are bound to add limited elements  
		once the defined no of elements are reached we can't add 
		new elements without hard coding the size of Array in our code. 
		*/
		
		//Assumption: Static Array Implementation for Array of Employee Objects
		//as mentioned to show the Scratch Implementation of all these operations
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		
		Employee employee[]=new Employee[6];
		
		
		employee[0]=new Employee(1001,"Hardik","Manager",95000.00);
		employee[1]=new Employee(1002,"Smita","HR",70000.00);
		employee[2]=new Employee(1003,"Sameer","Tech Lead",85000.00);
		employee[3]=new Employee(1004,"Abhishek","Junior Dev",60000.00);
		employee[4]=new Employee(1005,"Priyanka","Regional Head",150000.00);
		
		
		System.out.println("Enter 1-Add employee, 2-Search employee by name,"
				+ " 3-Traverse through Employees, 4-Delete an Employee, 0-Exit Apllication");
		int userQuery=sc.nextInt();
		while(userQuery!=0) {
			switch(userQuery) {
			case 1:
				add(employee,sc);
				break;
			case 2:
				
				search(employee,sc);
				break;
			case 3:
				traverse(employee,employee.length);
				break;
			case 4:
				
				delete(employee,sc);
				break;
			default:
				System.out.println("Invalid Option");
				
			}
			System.out.println("Enter 1-Add employee, 2-Search employee by name,"
					+ " 3-Traverse through Employees, 4-Delete an Employee, 0-Exit Apllication");
			userQuery=sc.nextInt();
		}
		
		System.out.println("Exiting the application");
		
		/*
		 * Time Complexity:
		 * 	Add Element - O(1) at the end(Best case), O(n) for any other Position( Average case) 
		 * 	Search Element- Best case O(1), Average case-O(n)
		 *  Traverse-O(n)
		 *  Delete- O(1) from the end(Best case), in any other case average time complexity is O(n)
		 *  
		 *   Arrays are static in nature so we should use them in cases where size is defined, data are of homogeneous type
		 *   and frequent insertion or deletion is required; 
		 */
		
	}
	public static void add(Employee employee[],Scanner sc) {
		//Open ended QUestion so performing insertion at any position
		if(employee[employee.length-1]!=null) {
			System.out.println("The Array is full");
			return;
		}
		System.out.println("Enter Position You want to Insert");
		int position=sc.nextInt();
	
		if(position<=employee.length) {
			System.out.println("Enter Employee ID, Name, Position, Salary");
			int employeeId=sc.nextInt();
			sc.nextLine();
			String employeeName=sc.nextLine().trim();
			String employeePosition=sc.nextLine().trim();
			double employeeSalary=sc.nextDouble();
			Employee newEmployee=new Employee(employeeId,employeeName,employeePosition,employeeSalary);
			for(int i=employee.length-1;i>=position;i--) {
				employee[i]=employee[i-1];
			}
			employee[position-1]=newEmployee;
			System.out.println("New Employee "+employee[position-1]+" at position"+position);
			
		}
		else {
			System.out.println("Invalid Position");
		}
	
	}		
		
	
	public static void search(Employee employee[],Scanner sc) {
		System.out.println("Enter the name of Employee you want to search");
		String name=sc.next();
		for(int i=0;i<employee.length && employee[i]!=null ;i++) {
			if(employee[i].employeeName.equals(name)){
				
				System.out.println("Employee Found :\n"+employee[i]+"\n Present at Position : "+i);
			}
		}
		
	}
	public static void traverse(Employee employee[],int length) {
		int i=0;

		while(i<length && employee[i]!=null ) {
			System.out.println(employee[i]);
			i++;
		}
		
	}
	public static void delete(Employee employee[],Scanner sc) {
		System.out.println("Enter name of the employee to be deleted");
		String name=sc.next();
		boolean deleted=false;
		for(int i=0;i<employee.length-1;i++) {
			if(!deleted && employee[i].employeeName.equals(name)){
				System.out.println("Deleted Employee "+employee[i]);
				
				employee[i]=null;
				deleted=true;
			}
			if(deleted) {
				Employee tempEmployee=employee[i];
				employee[i]=employee[i+1];
				employee[i+1]=tempEmployee;
			}
			
		}
		
	}

}
