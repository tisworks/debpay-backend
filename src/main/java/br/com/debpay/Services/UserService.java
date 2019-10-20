package br.com.debpay.Services;

import br.com.debpay.DAO.IUserDAO;
import br.com.debpay.DTO.UserDTO;

public class UserService implements IUserService {
    private final IUserDAO dao;

    public UserService(IUserDAO dao) {
        this.dao = dao;
    }

    @Override
    public UserDTO getUser(String login) {
        return UserDTO.converter(dao.getUser(login));
    }
}
