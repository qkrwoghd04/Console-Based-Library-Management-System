package DesignPatterns.sales;

public class Customer {
  String name;
  boolean IsPreferEmail;

  Customer(String name, boolean IsPreferEmail){
    this.name = name;
    this.IsPreferEmail = IsPreferEmail;
  }

  public String getName(){
    return name;
  }

  public boolean IsPreferEmail(){
    return true;
  }
}
