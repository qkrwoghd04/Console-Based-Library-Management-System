package Exercise.FactoryPracticeDocument;

public class PDFDMS extends DocumentManagementSystem{
  @Override
  public Document createDocument(){
    return new PDF();
  }
}
