package br.com.debpay.controllers;

import java.util.Date;

class JSONInput {
    static class User {
        String login;
        String password;
    }

    static class Operation {
        String description;
        Date dueDate;
        int operationType;
        int contactID;
        int installmentsLeft;
        float value;
    }
}
