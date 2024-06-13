package DesignPatterns.Behavioral_StrategyDesign_CourierServiceProblem;

public class Client {
  public static void main(String[] args) {
    Context context = new Context();
    context.setCourierService(new Parcel());
    context.checkout(5);
  }
}
