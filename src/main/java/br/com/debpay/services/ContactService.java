package br.com.debpay.services;

import br.com.debpay.dao.IContactDAO;
import br.com.debpay.dto.ContactDTO;
import br.com.debpay.entities.Contact;
import br.com.debpay.entities.User;

import java.util.ArrayList;
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
    var result = new ArrayList<ContactDTO>();
    var contacts = dao.getAll(userID);

    for(var c : contacts) {
      result.add(contactToDTO(c));
    }
    return result;
  }

  private ContactDTO contactToDTO(Contact c) {
    var dto = new ContactDTO();
    dto.setId(c.getId());
    dto.setUserID(c.getUser().getId());
    dto.setName(c.getName());
    dto.setCpf(c.getCpf());
    dto.setBankCode(c.getBankCode());
    dto.setBankAgency(c.getBankAgency());
    dto.setBankAccount(c.getBankAccount());
    return dto;
  }
}
