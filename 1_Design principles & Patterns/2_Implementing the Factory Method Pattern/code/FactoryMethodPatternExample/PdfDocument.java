package FactoryMethodPatternExample;

public class PdfDocument implements Document {
	public void newDocument() {
		System.out.println("A new pdf document is created");
	}
}
