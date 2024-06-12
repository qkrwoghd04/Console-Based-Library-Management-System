package Exercise.sales;

public class Order {
  private IMessageService ms;
  private Customer c;

  public Order(Customer c){
    this.c = c;
    if(c.IsPreferEmail()){
      ms = new Email();
    }else{
      ms = new Facebook();
    }
  }

  public void SendMessage(){
    ms.send("Dear " + c.getName() + ", thank you ...");
  }
}