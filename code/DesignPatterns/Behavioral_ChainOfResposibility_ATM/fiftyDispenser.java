package DesignPatterns.Behavioral_ChainOfResposibility_ATM;

public class fiftyDispenser implements Handler{
  private Handler next;

  @Override
  public Handler setNextHandler(Handler handler){
    return this.next = handler;
  }

  @Override
  public void dispense(double amount){
    if(amount % 50 != 0 && amount % 10 == 0){
      System.out.println("Correctly dispense 50 : " + (int)amount / 50);
      amount = amount % 50;
      next.dispense(amount);
    }else if(amount % 50 == 0){
      System.out.println("Correctly dispense 50 : " + (int)amount / 50);
    }else{
      throw new IllegalArgumentException("The amount of money indivisible");
    }
  }
}
