package br.com.debpay.services;

import br.com.debpay.dto.ContactDTO;

import java.util.List;

public interface IContactService {
  void createContact(ContactDTO dto);

  List<ContactDTO> listContact(int userID);
}
