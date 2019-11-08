package br.com.debpay.controllers;

import br.com.debpay.Container;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("contact")
public class ContactController {

    static class ContactInput {
        int id;
        int userID;
        String name;
        String cpf;
        String bankCode;
        String bankAgency;
        String bankAccount;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createContact(String JSONInput) {
        try {
            ContactInput contact;

            try {
                contact = new Gson().fromJson(JSONInput, ContactInput.class);
            } catch (Exception ex) {
                return Response.
                        status(Response.Status.BAD_REQUEST).
                        build();
            }

            if (contact.id < 1 || contact.userID < 1 || contact.name.isBlank()) {
                return Response.
                        status(Response.Status.BAD_REQUEST).
                        build();
            }



            var service = Container.getOperationService();
            service.createOperation(dto);

            return Response
                    .status(Response.Status.CREATED)
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}


