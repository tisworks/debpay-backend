package br.com.debpay.Entities;

import java.util.Date;

public class Operation {

    private int id;
    private String description;
    private OperationType type;
    private Date dueDate;
    private int installmentsLeft;
    private float value;
    private Contact contact;

    public Operation(int id, String description, OperationType type, Date dueDate, int installmentsLeft, float value, Contact contact) {
        setId(id);
        setDescription(description);
        setType(type);
        setDueDate(dueDate);
        setInstallmentsLeft(installmentsLeft);
        setValue(value);
        setContact(contact);
    }

    public Operation() {}

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
