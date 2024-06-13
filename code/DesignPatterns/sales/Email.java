package DesignPatterns.sales;

public class Email implements IMessageService{
  @Override
  public void send(String message){
    System.out.println("Send Email: " + message);
  }
  
}
