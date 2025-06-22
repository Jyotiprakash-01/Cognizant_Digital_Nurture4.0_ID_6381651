package BuilderPatternExample;

public class Test {
	public static void main(String[] args) {
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
        
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB","Samsung SATA SSD 128GB").build();
                

        System.out.println("Configuration Basic Computer:");
        basicComputer.showConfig();

        Computer researchComputer = new Computer.Builder("AMD Ryzen 9", "128GB","Samsung SATA SSD 10TB").build();
        
        System.out.println("Configuration Research:");
        researchComputer.showConfig();
    }
}
