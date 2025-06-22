import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Book{
	int bookId;
	String title;
	String author;
	public Book(int bookId, String title, String author) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [Book Id = " + bookId + " , Title = " + title + " , Author = " + author + "]";
	}
	
}

class CompareByTitle implements Comparator<Book>{
	public int compare(Book b1,Book b2) {
		
		return b1.title.compareTo(b2.title);
	}

}
public class Exercise6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		
		ArrayList<Book> book=new ArrayList<>();
		
		book.add(new Book(1001,"Harry Potter","J K Rowling"));
		book.add(new Book(2034,"Percy Jackson","Rick Riodan"));
		book.add(new Book(9867,"Lord Of The Rings","J R R Tolkien"));
		book.add(new Book(3451,"The Hunger Games","Suzanne Collins"));
		book.add(new Book(5821,"Rich Dad Poor Dad","Robert Kiosaki"));
		book.add(new Book(2431,"Atomic Habits","James Clear"));
		book.add(new Book(1012,"Fantastic Beasts","J K Rowling"));
		
		System.out.println("All Library records");
		for(Book b:book) {
			System.out.println(b);
		}
		System.out.println("\nEnter How do you want to search 1-Linear Search, 2-Binary Search");
		int userInput=sc.nextInt();
		sc.nextLine();
		System.out.println("\nEnter the title you want to search for");
		String bookTitle=sc.nextLine();
		switch(userInput) {
		case 1:
			linearSearch(book,bookTitle);
			break;
		case 2:
			Collections.sort(book,new CompareByTitle());
			Book searchedBook=binarySearch(book,bookTitle);
			if(searchedBook == null) {
				System.out.println("No such book is present of that title in Library");
			}
			else {
				System.out.println("Found though Binary search :\n"+searchedBook);
			}
			break;
		default:
			System.out.println("Invalid Input");
		}
		sc.close();		
	}
	public static void linearSearch(ArrayList<Book> book,String bookTitle) {
		for(Book b:book) {
			if(b.title.equals(bookTitle)) {
				System.out.println("Found Through Linear Search :\n"+b);
				return;
			}
		}
	}
	public static Book binarySearch(ArrayList<Book> book,String bookTitle) {
		int start=0;
		int end=book.size()-1;
		while(start<=end) {
			int mid=start+((end-start)/2);
			if(book.get(mid).title.equals(bookTitle)) {
				return book.get(mid);
			}
			else if(book.get(mid).title.compareTo(bookTitle)>0) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return null;
		
	}

}
