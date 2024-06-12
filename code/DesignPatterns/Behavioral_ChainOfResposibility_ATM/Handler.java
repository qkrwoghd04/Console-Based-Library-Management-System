package Exercise.ChainOfResposibility_ATM;

public interface Handler {
  public Handler setNextHandler(Handler handler);

  public void dispense(double amount);
}
