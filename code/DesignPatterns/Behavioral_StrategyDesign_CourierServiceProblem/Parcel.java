package Exercise.Behavior_StrategyDesign_CourierServiceProblem;

public class Parcel implements CourierService{

  @Override
  public void calculate(int cost){
    // algorithm A
    int w = cost * 3;

    // algorithm B
    int d = cost * 4;

    if(w > d){
      System.out.println("algorithm A is higher");
      }else{
      System.out.println("algorithm B is higher");
    }
  }
}
