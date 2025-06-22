import java.util.LinkedList;
import java.util.Scanner;
class Task{
	int taskId;
	String taskName;
	String status;
	public Task(int taskId, String taskName, String status) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.status = status;
	}
	public String toString() {
		return "Task Id =" + taskId + ", Task Name =" + taskName + "|  Status =" + status;
	}
	
	
}
public class Exercise5 {
	public static void main(String[] args) {
		LinkedList<Task> taskList=new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		//For Dynamic addition of Tasks
//		for(int i=0;i<taskList.size();i++) {
//			taskList.add(new Task(sc.nextInt(),sc.next(),sc.next()));
//		}
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		
		taskList.add(new Task(1,"Go for Shooping","Incomplete"));
		taskList.add(new Task(2,"Complete your Assignments","Complete"));
		taskList.add(new Task(3,"Schedule the Meeting with client","Incomplete"));
		taskList.add(new Task(4,"Compile the reports for th Project","Complete"));
		taskList.add(new Task(5,"Review the Presentation","Complete"));
		
		System.out.println("Enter 1-Add, 2-Search, 3-Traverse, 4-Delete, 0-Exit Task");
		int userQuery=sc.nextInt();
		while(userQuery!=0) {
			switch(userQuery) {
			case 1:				
				add(taskList,sc);
				break;
			case 2:
				System.out.println("Enter status(Complete/Incomplete) to search by Status");
				String taskStatus=sc.next();
				search(taskList,taskStatus);				
				break;
			case 3:
				traverse(taskList);
				break;
			case 4:
				
				delete(taskList,sc);
				break;
			default:
				
			}
			System.out.println("Enter 1-Add, 2-Search, 3-Traverse, 4-Delete, 0-Exit Task");
			userQuery=sc.nextInt();
		}
		System.out.println("Exiting from application");
		
		
	}
	public static void add(LinkedList<Task> taskList,Scanner sc) {
		System.out.println("Enter Task Id, Name, Status");
		int id=sc.nextInt();
		sc.nextLine();
		String taskName=sc.nextLine();
		String status=sc.next();
		Task newTask=new Task(id,taskName,status);
		
		System.out.println("Enter where to add Task 0-At First, 1-At End, 2-At any Position");
		int inputPosition=sc.nextInt();
		
		if(inputPosition==0)
			taskList.addFirst(newTask);//Insert at Begining
		else if(inputPosition==1)
			taskList.addLast(newTask);//Insert at end
		else
			taskList.add(inputPosition-1,newTask);//Insert at Anyposition
		
		
	}
	public static void search(LinkedList<Task> taskList,String status){
		System.out.println("Searching Tasks by status : "+status);
		for(Task task:taskList) {
			if(task.status.equals(status))
				System.out.println(task);
		}
		
	}
	public static void traverse(LinkedList<Task> taskList) {
		for(Task task:taskList) {
			System.out.println(task);
		}
		
	}
	public static void delete(LinkedList<Task> taskList,Scanner sc) {
		System.out.println("Enter to delete Task 0-From begining, 1-from end, 2-from any Position");
		int userInput=sc.nextInt();
		switch(userInput) {
		case 0:
			taskList.removeFirst();
			break;
		case 1:
			taskList.removeLast();
			break;
		case 2:
			System.out.println("Enter id of task to be deleted:");
			int id=sc.nextInt();
			int index=-1;
			for(int i=0;i<taskList.size();i++) {
				if(taskList.get(i).taskId==id) index=i;
			}
			taskList.remove(index);	
			break;
		default:
			System.out.println("Invalid Choice");
			
		}
		
		
	}

}
