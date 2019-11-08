package br.com.debpay.services;

import br.com.debpay.dao.IContactDAO;
import br.com.debpay.dto.ContactDTO;
import br.com.debpay.entities.Contact;
import br.com.debpay.entities.User;

import java.util.List;

public class ContactService implements IContactService {

  private final IContactDAO dao;

  public ContactService(IContactDAO dao) {
    this.dao = dao;
  }

  @Override
  public void createContact(ContactDTO dto) {
    var contact = new Contact();

    var user = new User();
    user.setId(dto.getUserID());

    contact.setUser(user);
    contact.setName(dto.getName());
    contact.setCpf(dto.getCpf());
    contact.setBankCode(dto.getBankCode());
    contact.setBankAgency(dto.getBankAgency());
    contact.setBankAccount(dto.getBankAccount());

    dao.save(contact);
  }

  @Override
  public List<ContactDTO> listContact(int userID) {
    return null;
  }
}
