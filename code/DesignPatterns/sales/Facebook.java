package DesignPatterns.sales;

public class Facebook implements IMessageService{
  @Override
  public void send(String message){
    System.out.println("Send Facebook: " + message);
  }
}
