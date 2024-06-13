package DesignPatterns.Behavioral_StrategyDesign_CourierServiceProblem;

public class Document implements CourierService{
  @Override
  public void calculate(int cost){
    // algorithm C
    int c = cost + 1;
    System.out.println("algorithm c is " + c);
  }
}
