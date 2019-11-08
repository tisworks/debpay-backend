package br.com.debpay.dto;

import java.util.Date;

public class OperationFilterDTO {
    private int userID;
    private Date dueDate;

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
