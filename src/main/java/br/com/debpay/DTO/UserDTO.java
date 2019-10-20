package br.com.debpay.DTO;

import br.com.debpay.Entities.User;

public class UserDTO {
    private int id;
    private String login;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserDTO converter(User user) {
        var dto = new UserDTO();
        dto.id = user.getId();
        dto.login = user.getLogin();
        dto.password = user.getPassword();
        return dto;
    }
}
