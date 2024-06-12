package Exercise.FactoryPracticeDocument;

public class WordDMS extends DocumentManagementSystem{
  
  @Override
  public Document createDocument(){
    return new Word();
  }
}
