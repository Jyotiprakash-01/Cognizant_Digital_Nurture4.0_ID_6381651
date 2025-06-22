package FactoryMethodPatternExample;

public class Test {
	public static void main(String[] args) {
		System.out.println("Name: Jyoti Prakash Tripathy");
		System.out.println("Superset ID: 6381651");
		DocumentFactory wordFactory = new WordDocumentFactory();
		Document wordDocument= wordFactory.createDocument();
		
		wordDocument.newDocument();
		
		DocumentFactory excelFactory = new ExcelDocumentFactory();
		Document excelDocument= excelFactory.createDocument();
		
		excelDocument.newDocument();
		
		DocumentFactory pdfFactory = new PdfDocumentFactory();
		Document pdfDocument= pdfFactory.createDocument();
		
		pdfDocument.newDocument();
	}
}
