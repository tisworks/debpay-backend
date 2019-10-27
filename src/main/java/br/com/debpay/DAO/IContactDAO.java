package br.com.debpay.DAO;

import br.com.debpay.Entities.Contact;

import java.util.List;

public interface IContactDAO {
    Contact get(int id);

    List<Contact> getAll(int userId);

    void save(Contact c);

    void update(Contact c);

    void delete(int id);
}
