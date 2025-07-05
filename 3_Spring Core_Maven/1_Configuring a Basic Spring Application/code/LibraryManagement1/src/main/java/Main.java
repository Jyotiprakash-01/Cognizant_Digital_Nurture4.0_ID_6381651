
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class Main {
	public static void main(String[] args) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		BookService service = (BookService) context.getBean("bookService");
		System.out.println("Enter Book Title");
		Scanner sc = new Scanner(System.in);
		service.addBook(sc.nextLine());
		sc.close();

	}
}
