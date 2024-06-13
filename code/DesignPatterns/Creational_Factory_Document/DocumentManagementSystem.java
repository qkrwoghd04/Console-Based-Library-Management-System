package DesignPatterns.Creational_Factory_Document;

public abstract class DocumentManagementSystem {

  public Document makeDocument(){
    Document document = createDocument();
    document.create();
    document.open();
    document.save();
    
    return document;
  }

  public abstract Document createDocument();
}
