package br.com.debpay.dto;

public class ContactDTO {
  private int id;
  private int userID;
  private String name;
  private String cpf;
  private String bankCode;
  private String bankAgency;
  private String bankAccount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public String getBankAgency() {
    return bankAgency;
  }

  public void setBankAgency(String bankAgency) {
    this.bankAgency = bankAgency;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }
}
