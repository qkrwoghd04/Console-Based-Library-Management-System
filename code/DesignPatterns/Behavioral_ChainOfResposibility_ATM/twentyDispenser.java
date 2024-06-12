package Exercise.ChainOfResposibility_ATM;

public class twentyDispenser implements Handler {
  private Handler next;

  @Override
  public Handler setNextHandler(Handler handler){
    return this.next = handler;
  }

  @Override
  public void dispense(double amount){
    if(amount % 20 != 0 && amount % 10 == 0){
      System.out.println("Correctly dispense 20 : " + (int)amount / 20);
      amount = amount % 20;
      next.dispense(amount);
      }else if(amount % 20 == 0){
      System.out.println("Correctly dispense 20 : " + (int)amount / 20);
    }else{
      throw new IllegalArgumentException("The amount of money indivisible");
    }
  }
}
