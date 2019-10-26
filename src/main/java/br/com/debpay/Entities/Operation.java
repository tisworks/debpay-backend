package br.com.debpay.Entities;

import java.sql.Date;

public class Operation {

    private int id;
    private String description;
    private Date dueDate;
    private int installmentsLeft;
    private float value;
    private int contactId;
    private OperationType type;

    public Operation(int id, String description, Date dueDate, int installmentsLeft, float value, int contactId, int type) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.installmentsLeft = installmentsLeft;
        this.value = value;
        this.contactId = contactId;
        this.type= type == 1 ? OperationType.CREDITO : OperationType.DEBITO;
    }

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

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }
}
