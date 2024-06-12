package Exercise.Behavior_StrategyDesign_CourierServiceProblem;

public class Context {
  private CourierService courierService;

  public void setCourierService(CourierService courierService){
    this.courierService = courierService;
  }

  public void checkout(int cost){
    courierService.calculate(cost);
  }
}

