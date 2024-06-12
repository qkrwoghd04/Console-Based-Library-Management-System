package Exercise.FactoryPracticeDocument;

public class PDF implements Document{
  String name;

  PDF(){
    this.name = "PDF";
  }

  public void create(){
    System.out.println("PDF Created");
  }

  public void open(){
    System.out.println("PDF Opened");
  }

  public void edit(){
    System.out.println("PDF Edited");
  }

  public void save(){
    System.out.println("PDF Saved");
  }
}
