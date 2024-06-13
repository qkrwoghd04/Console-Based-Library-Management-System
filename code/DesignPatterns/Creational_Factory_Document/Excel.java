package DesignPatterns.Creational_Factory_Document;

public class Excel implements Document{
  String name;

  Excel(){
    this.name = "Excel";
  }

  public void create(){
    System.out.println("Excel Created");
  }

  public void open(){
    System.out.println("Excel Opened");
  }

  public void edit(){
    System.out.println("Excel Edited");
  }

  public void save(){
    System.out.println("Excel Saved");
  }
}
