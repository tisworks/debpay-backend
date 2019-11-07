package br.com.debpay.Entities;

public class Contact {
    private int id;
    private User user;
    private String name;
    private String cpf;
    private String bankCode;
    private String bankAgency;
    private String bankAccount;

    public Contact(int id, User user, String name, String cpf, String bankCode, String bankAgency, String bankAccount) {
        setId(id);
        setUser(user);
        setName(name);
        setCpf(cpf);
        setBankCode(bankCode);
        setBankAgency(bankAgency);
        setBankAccount(bankAccount);
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
