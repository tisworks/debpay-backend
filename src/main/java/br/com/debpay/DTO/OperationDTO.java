package br.com.debpay.DTO;

import br.com.debpay.Entities.Operation;

import java.util.Date;

public class OperationDTO {
    private int id;
    private String description;
    private int type;
    private Date dueDate;
    private int installmentsLeft;
    private float value;
    private int contactID;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public  static OperationDTO converter(Operation op){
        var dto = new OperationDTO();
        dto.id = op.getId();
        dto.dueDate = op.getDueDate();
        dto.description = op.getDescription();
        dto.contactID = op.getContact().getId();
        dto.installmentsLeft = op.getInstallmentsLeft();
        dto.value = op.getValue();
        dto.type = op.getType().getValue();

        return dto;
    }` `
}
