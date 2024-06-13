package DesignPatterns.Creational_Factory_Document;

public class Client {
  public static void main(String[] args) {
    DocumentManagementSystem dms1 = new WordDMS();
    System.out.println("Word Document created");
    Document word = dms1.makeDocument();

    DocumentManagementSystem dms2 = new PDFDMS();
    System.out.println("PDF Document created");
    Document pdf = dms2.makeDocument();
    
    DocumentManagementSystem dms3 = new ExcelDMS();
    System.out.println("Excel Document created");
    Document excel = dms3.makeDocument();
  }
}
