package br.com.debpay.controllers;

import java.util.Date;

class JSONInput {
  static class User {
    String login;
    String password;
    String name;
  }

  static class Operation {
    String description;
    Date dueDate;
    int operationType;
    int contactID;
    int userID;
    int installmentsLeft;
    float value;
  }
}
