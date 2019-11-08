package br.com.debpay.dao;

import br.com.debpay.entities.Contact;

import java.util.List;

public interface IContactDAO {
  Contact get(int id);

  List<Contact> getAll(int userId);

  void save(Contact c);

  void update(Contact c);

  void delete(int id);
}
