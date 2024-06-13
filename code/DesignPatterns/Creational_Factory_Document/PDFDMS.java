package DesignPatterns.Creational_Factory_Document;

public class PDFDMS extends DocumentManagementSystem{
  @Override
  public Document createDocument(){
    return new PDF();
  }
}
