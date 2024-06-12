package Exercise.FactoryPracticeDocument;

public class Word implements Document{
  String name;
  Word (){
    this.name = "Word";
  }

 
  public void create(){
    System.out.println("Word Created");
  }

  public void open(){
    System.out.println("Word Opened");
  }

  public void edit(){
    System.out.println("Word Edited");
  }

  public void save(){
    System.out.println("Word Saved");
  }

}
