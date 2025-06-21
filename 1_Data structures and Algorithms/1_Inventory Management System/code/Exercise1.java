//Exercise 1: Inventory Management System
import java.util.HashMap;
import java.util.Scanner;
class Product {
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	public Product(int productId,String productName,int quantity,double price) {
		this.productId=productId;
		this.productName=productName;
		this.quantity=quantity;
		this.price=price;
		
	}
	public int getProductId() {
		return productId;		
	}
	public void setProductId(int productId) {
		this.productId=productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName=productName;		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "Id : "+getProductId()+", Name : "+getProductName()+", Quantity : "+getQuantity()+", Price : "+getPrice();
	}
}
public class Exercise1 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
				
		HashMap <Integer,Product> hm = new HashMap<>();
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		System.out.println("Enter Operation 1-Add Product, 2-Update Product, 3-Delete Product, 0-Exit");
		int userInput=sc.nextInt();
		while(userInput!=0) {
			switch(userInput) {
			case 1:
				addProduct(hm,sc);
				System.out.println(hm);
				break;
			case 2:
				System.out.println("Enter Id of the Product you want to update");
				int id=sc.nextInt();
				updateProduct(id,hm,sc);
				System.out.println(hm);
				break;
			case 3:
				System.out.println("Enter Id of the Product you want to Delete");
				int pid=sc.nextInt();
				deleteProduct(pid,hm);
				System.out.println(hm);
				break;
			default:
				System.out.println("Invalid Choice");
				
			}
			System.out.println("Enter Operation 1-Add Product, 2-Update Product, 3-Delete Product, 0-Exit");
			userInput=sc.nextInt();
		}
		System.out.println("Exiting Application the final Inventory:");
		System.out.println(hm);
				
		sc.close();
		/*
		 * Time Complexity:
		 * Add: O(1)
		 * Update: O(1)
		 * Delete: O(1)
		 * 
		 * HashMap is Thread unsafe as well as unordered,  
		 * So use of Linked Hash Map for ordered map or Concurrent Hash Map will be more efficient for Large application 
		 * as it provides concurrency and is thread safe.
		 */
	}
	public static void addProduct(HashMap <Integer,Product>hm,Scanner sc) {
		
		System.out.println("Enter Product Details:");
		System.out.println("Enter Product Id:");
		int id=sc.nextInt();
		System.out.println("Enter Product Name:");
		String name=sc.next();
		System.out.println("Enter Product Quantity");
		int quantity=sc.nextInt();
		System.out.println("Enter Product Price");
		double price=sc.nextDouble();
		Product newProduct= new Product(id,name,quantity,price);
		hm.put(newProduct.getProductId(), newProduct);
		
	}
	public static void updateProduct(int productId,HashMap <Integer,Product>hm,Scanner sc) {
		Product updateProduct=hm.get(productId);
		//Exception can be thrown here but for simplicity using conditional statements
		if(updateProduct==null) {
			System.out.println("Product is not present in the Inventory");
		}
		else {
			
			System.out.println("What do you want to update  1:Name 2:Quantity 3:Price");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("Enter updated Product Name:");
				updateProduct.setProductName(sc.next());
				break;
			case 2:
				System.out.println("Enter new Product Quantity");
				updateProduct.setQuantity(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter new Product PRICE");
				updateProduct.setPrice(sc.nextDouble());
				break;
			default:
				System.out.println("Invalid Choice");
			}		
			
		}
	
		
	}
	public static void deleteProduct(int productId,HashMap <Integer,Product>hm){
		if(hm.remove(productId)==null) {
			System.out.println("No Such Product Exists");
		}
		else {
			System.out.println("Product Sucessfully deleted");
		}
		
	}
	
	
}
