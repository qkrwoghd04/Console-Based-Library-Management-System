package Exercise.FactoryPracticeDocument;

public class ExcelDMS extends DocumentManagementSystem{
  
  @Override
  public Document createDocument(){
    return new Excel();
  }
}
