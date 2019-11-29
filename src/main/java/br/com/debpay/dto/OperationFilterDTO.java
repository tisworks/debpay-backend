package br.com.debpay.dto;

import java.util.Date;

public class OperationFilterDTO {
  private int userID;
  private Date dueDate;
  private int contactID;

  public int getContactID() {
    return contactID;
  }

  public void setContactID(int contactID) {
    this.contactID = contactID;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }
}
