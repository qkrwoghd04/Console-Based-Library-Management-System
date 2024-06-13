package DesignPatterns.Behavioral_ChainOfResposibility_ATM;

public class Client {
  public static void main(String[] args) {
    Handler fifty = new fiftyDispenser();
    Handler twenty = new twentyDispenser();
    Handler ten = new tenDispenser();

    fifty.setNextHandler(twenty);
    twenty.setNextHandler(ten);

    fifty.dispense(555);


  }
}
