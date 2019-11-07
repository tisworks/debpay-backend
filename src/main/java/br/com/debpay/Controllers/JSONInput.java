package br.com.debpay.Controllers;

import java.util.Date;

class JSONInput {
    class User {
        String login;
        String password;
    }

    class Operation {
        String description;
        Date dueDate;
        int operationType;
        int contactID;
        int installmentsLeft;
        float value;
    }
}
