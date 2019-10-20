package br.com.debpay.Services;

import br.com.debpay.DTO.UserDTO;

public interface IUserService {
    UserDTO getUser(String login);
}
