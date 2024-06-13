package DesignPatterns.Creational_Factory_Document;

public class WordDMS extends DocumentManagementSystem{
  
  @Override
  public Document createDocument(){
    return new Word();
  }
}
