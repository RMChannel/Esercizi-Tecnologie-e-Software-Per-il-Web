package model;


public class Customer {
  private String firstName;
  private String lastName;
  private int id;
  private double balance, balanceNoSign;

  public Customer() {
    firstName = "";
    lastName = "";
    balance = 0;
    balanceNoSign = 0;
  }

  public Customer(String firstName, String lastName, int id, double balance, double balanceNoSign) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.balance = balance;
    this.balanceNoSign = balanceNoSign;
  }
  
  public int getId() {
    return id;
  }

  public String getFirstName() {
    return(firstName);
  }

  public String getLastName() {
    return(lastName);
  }

  public double getBalance() {
    return(balance);
  }

  public double getBalanceNoSign() {
    return((balance<0)?-balance:balance);
  }


  public void setId(int id) {
    this.id = id;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
  
