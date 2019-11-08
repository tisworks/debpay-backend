package br.com.debpay.dto;

import br.com.debpay.entities.OperationType;

import java.util.Date;

public class OperationDTO {
  private int id;
  private String description;
  private OperationType type;
  private Date dueDate;
  private int installmentsLeft;
  private float value;
  private int contactID;
  private int userID;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OperationType getType() {
    return type;
  }

  public void setType(OperationType type) {
    this.type = type;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public int getInstallmentsLeft() {
    return installmentsLeft;
  }

  public void setInstallmentsLeft(int installmentsLeft) {
    this.installmentsLeft = installmentsLeft;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }

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
}
