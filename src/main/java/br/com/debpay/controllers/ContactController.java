package br.com.debpay.controllers;

import br.com.debpay.Container;
import br.com.debpay.dto.ContactDTO;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("contact")
public class ContactController {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response createContact(String JSONInput) {
    try {
      ContactInput contact;

      try {
        contact = new Gson().fromJson(JSONInput, ContactInput.class);
      } catch (Exception ex) {
        return Response.status(Response.Status.BAD_REQUEST).build();
      }

      if (contact.userID < 1 || contact.name.isBlank()) {
        return Response.status(Response.Status.BAD_REQUEST).build();
      }

      var dto = new ContactDTO();
      dto.setUserID(contact.userID);
      dto.setName(contact.name);
      dto.setCpf(contact.cpf);
      dto.setBankCode(contact.bankCode);
      dto.setBankAgency(contact.bankAgency);
      dto.setBankAccount(contact.bankAccount);

      var service = Container.getContactService();
      service.createContact(dto);

      return Response.status(Response.Status.CREATED).build();
    } catch (Exception ex) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listContact(@QueryParam("userID") int userID) {
    try {
      if (userID < 1) {
        return Response.status(Response.Status.BAD_REQUEST).build();
      }

      var service = Container.getContactService();
      var result = service.listContact(userID);
      return Response.status(Response.Status.OK).entity(result).build();
    } catch (Exception ex) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  private static class ContactInput {
    int userID;
    String name;
    String cpf;
    String bankCode;
    String bankAgency;
    String bankAccount;
  }
}
