package DesignPatterns.Behavioral_ChainOfResposibility_ATM;

public class tenDispenser implements Handler{
  private Handler next;

  @Override
  public Handler setNextHandler(Handler handler){
    return this.next = handler;
  }

  @Override
  public void dispense(double amount){
    if(amount % 10 == 0){
      System.out.println("Correctly dispense 10 : " + (int)amount / 10);
    }else{
      throw new IllegalArgumentException("The amount of money indivisible");
    }
  }
}
