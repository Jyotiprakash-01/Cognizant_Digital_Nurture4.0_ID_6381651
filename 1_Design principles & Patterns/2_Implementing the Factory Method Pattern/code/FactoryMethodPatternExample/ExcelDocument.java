package FactoryMethodPatternExample;

public class ExcelDocument implements Document {
	public void newDocument() {
		System.out.println("A new excel sheet document is created");
	}
}
