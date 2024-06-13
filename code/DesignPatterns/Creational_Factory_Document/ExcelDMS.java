package DesignPatterns.Creational_Factory_Document;

public class ExcelDMS extends DocumentManagementSystem{
  
  @Override
  public Document createDocument(){
    return new Excel();
  }
}
