import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Product{
	int productId;
	String productName;
	String category;
	Product(int productId,String productName,String category){
		this.productId=productId;
		this.productName=productName;
		this.category=category;
		
	}
	public String toString() {
		return "Product Id:"+productId+" Name:"+productName+" Catagory:"+category+" ";
	}
	
}
//Could have been done easily in same class but applied Single responsibility of Solid Principles Learned from Hands on.
		
class LinearSearch{
	/*This class and methods are designed not to return an object of type Product(i.e return void) in LinearSearch as 
	we want to find duplicates(more than one product although duplicates can only exist in category
	as multiple product may be of same category.
	we can name the methods individually (searchById,searchByName,searchByCategory)
	but here the name is kept same to implement mMethod Overloading */ 
	
	/*function return type-void
	finds all the product with same id, but this can be modified to find a unique product id as
	each product id should be unique in an actual setup.*/
	public void search(ArrayList<Product> product,int id) {
		int productSize=product.size();
		for(int i=0;i<productSize;i++) {
			Product tempProduct=product.get(i);
			if(tempProduct.productId==id)
				System.out.println(tempProduct.toString());
		}
	}
	/*function return type-void
	 *This function finds all the product with same name and prints them to console.
	 */
	public void search(ArrayList<Product> product,String name) {
		int productSize=product.size();
		for(int i=0;i<productSize;i++) {
			Product tempProduct=product.get(i);
			if(tempProduct.productName.equals(name))
				System.out.println(tempProduct.toString());
		}
	}
	/*function return type-void
	 * This function finds all products listed in a particular category and prints them to console.
	 * 
	 */
	public void search(String category,ArrayList<Product> product){
		int productSize=product.size();
		for(int i=0;i<productSize;i++) {
			Product tempProduct=product.get(i);
			if(tempProduct.category.equals(category))
				System.out.println(tempProduct.toString());
		}
	}
	
}
//The first and foremost requirement of Binary search is an sorted array and as the Product class
//has 3 properties searching for each property requires sorting the whole ArrayList by that property.
class CompareById implements Comparator<Product>{
	public int compare(Product p1,Product p2) {
		
		if(p1.productId<p2.productId) {
			return -1;
		}
		else if(p1.productId==p2.productId){
			return 0;
		}
		else {
			return 1;
		}
	}
}
class CompareByName implements Comparator<Product>{
	public int compare(Product p1,Product p2) {
		return p1.productName.compareTo(p2.productName);
		
	}
}
class CompareByCategory implements Comparator<Product>{
	public int compare(Product p1,Product p2) {
		return p1.category.compareTo(p2.category);
		
	}
}
class BinarySearch{
	public Product search(ArrayList<Product> product,int id) {
		Product currentProduct;
		int start=0;
		int end=product.size();
		while(start<=end) {
			int mid=(start+end)/2;
			currentProduct=product.get(mid);
			if(currentProduct.productId==id) {
				return currentProduct;
			}
			else if(currentProduct.productId<id) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		return null;
		
	}
	public Product search(ArrayList<Product> product,String name) {
		Product currentProduct;
		int start=0;
		int end=product.size();
		while(start<=end) {
			int mid =(start+end)/2;
			currentProduct=product.get(mid);
			if(currentProduct.productName.equals(name)) {
				return currentProduct;
			}
			else if(currentProduct.productName.compareTo(name)>0) {
				end=mid-1;
				
			}
			else {
				start=mid+1;
			}
		}
		return null;

				
	}
	public Product search(String category,ArrayList<Product> product) {
		Product currentProduct;
		int start=0;
		int end=product.size();
		while(start<=end) {
			int mid=(start+end)/2;
			currentProduct=product.get(mid);
			if(currentProduct.category.equals(category)) {
				return currentProduct;
			}
			else if(currentProduct.category.compareTo(category)>0) {
				end=mid-1;
				
			}
			else {
				start=mid+1;
			}
		}
		
		return null;
	}
}
public class Exercise2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		System.out.println("Enter Size of your inventory:");
		int inventorySize=sc.nextInt();
		ArrayList <Product> product=new ArrayList<>(inventorySize);
		
		
		/*For dynamic addition of products
		 for(int i=0;i<inventorySize;i++) {
			product.add(i,new Product(1,"Apple","Fruit"));
		}
		*/
		
		//Statically adding new Products
		
		product.add(new Product(1001,"Apple","Fruit"));
		product.add(new Product(2001,"Carrot","Vegetable"));
		product.add(new Product(8001,"ScrewDiver","Tools"));
		product.add(new Product(1008,"Avocado","Fruit"));
		product.add(new Product(4003,"Table","Furniture"));
		
		
		
		System.out.println("Enter to search by 1-ProductId, 2-Product Name, 3-Product Catagory,0-Exit");
		LinearSearch ln = new LinearSearch();
		int enteredValue=sc.nextInt();
		System.out.println("Entering Linear Search");
		while(enteredValue!=0) {
			switch(enteredValue) {
			case 1:
				System.out.println("Enter the product Id by which you want to search");
				int pid = sc.nextInt();
				System.out.println("Search Results :");
				ln.search(product, pid);
				break;
			case 2:
				System.out.println("Enter product name by which you want to search");
				String name=sc.next();
				System.out.println("Search Results :");
				ln.search(product,name.trim());
				break;
			case 3:
				System.out.println("Enter product catagory by which you want to search");
				String category=sc.next();
				System.out.println("Search Results :");
				ln.search(category, product);
				break;
			default:
				System.out.println("Invalid Choice");
			}
			
			System.out.println("\nEnter to search by 1-ProductId, 2-Product Name, 3-Product Catagory,0-Exit");
			enteredValue=sc.nextInt();
			if(enteredValue==0) {
				System.out.println("Exiting Linear Search");
			}
		
		}
//		System.out.println("\nDo you want to perform Binary Search enter y-YES, n-NO");
//		char ch=sc.next().charAt(0);
		System.out.println("Performing Binary Search");
		BinarySearch bs = new BinarySearch();
		
		System.out.println("Enter to search by 1-ProductId, 2-Product Name, 3-Product Catagory");
		enteredValue=sc.nextInt();
		Product searchedProduct=null;
		
		switch(enteredValue) {
		case 1:
			Collections.sort(product,new CompareById());
			System.out.println("Enter the product Id by which you want to search");
			int pid = sc.nextInt();
			searchedProduct=bs.search(product, pid);
			if(searchedProduct==null) {
				System.out.println("No Products found");
			}
			else {
				System.out.println(" Searched Product Details:\n"+searchedProduct.toString());
			}
			break;
		case 2:
			Collections.sort(product,new CompareByName());
			System.out.println("Enter product name by which you want to search");
			String name=sc.next().trim();
			searchedProduct=bs.search(product, name);
			if(searchedProduct==null) {
				System.out.println("No Products found");
			}
			else{
				System.out.println(" Searched Product Details:\n"+searchedProduct.toString());
			}
			break;
		case 3:
			Collections.sort(product,new CompareByCategory());
			System.out.println("Enter product catagory by which you want to search");
			String category=sc.next().trim();
			searchedProduct=bs.search(category,product);
			if(searchedProduct==null) {
				System.out.println("No Products found");
			}
			else{
				System.out.println("First product in this category:\n"+searchedProduct.toString());
			}
			break;
		default:
			System.out.println("Invalid Input");			
		}
		sc.close();
	
/*
 * 		Time Complexity:
 * 		Linear Search: O(n)
 * 		Binary Search: O(log(n))
 * 
 * 		Linear search can find out duplicates (i.e all products in the same category )but Binary search cant
		be used to find all duplicates.
		
		I would Like to propose a Hybrid or mixture of both algorithms
		Linear Search(for category) and Binary Search(for id and name).
		
		As it is an open ended question I have implement the both the searches for all three properties.
		
		Binary Search has less time complexity to search for product Id and product name as both are unique
		but for searching by category i would recommend to use Linear search as It will provide all the products 
		present in that category
		
 * 
 */
	}


}
