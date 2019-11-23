package br.com.debpay.controllers;

import br.com.debpay.Container;
import br.com.debpay.dto.OperationDTO;
import br.com.debpay.dto.OperationFilterDTO;
import br.com.debpay.entities.OperationType;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;

@Path("operation")
public class OperationsController {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response createOperation(String input) {
    try {
      JSONInput.Operation operation;

      try {
        var gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        operation = gson.fromJson(input, JSONInput.Operation.class);
      } catch (Exception ex) {
        return Response.status(Response.Status.BAD_REQUEST).build();
      }

      if (OperationType.valueOf(operation.operationType) == null
          || operation.contactID < 1
          || operation.userID < 1
          || operation.installmentsLeft < 0
          || operation.value < 0) {

        return Response.status(Response.Status.BAD_REQUEST).build();
      }

      var dto = new OperationDTO();
      dto.setDescription(operation.description);
      dto.setType(OperationType.valueOf(operation.operationType));
      dto.setDueDate(operation.dueDate);
      dto.setInstallmentsLeft(operation.installmentsLeft);
      dto.setValue(operation.value);
      dto.setContactID(operation.contactID);
      dto.setUserID(operation.userID);

      var service = Container.getOperationService();
      service.createOperation(dto);

      return Response.status(Response.Status.CREATED).build();
    } catch (Exception ex) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listOperation(
      @QueryParam("userID") int userID, @QueryParam("due_date") String dueDate) {
    try {
      var filter = new OperationFilterDTO();

      if (userID < 1) {
        return Response.status(Response.Status.BAD_REQUEST).build();
      }

      filter.setUserID(userID);

      if (dueDate != null) {
        try {
          filter.setDueDate(new SimpleDateFormat("yyyy-MM-dd").parse(dueDate));
        } catch (Exception ex) {
          return Response.status(Response.Status.BAD_REQUEST).build();
        }
      }

      var service = Container.getOperationService();
      var result = service.listOperations(filter);
      return Response.status(Response.Status.OK).entity(result).build();
    } catch (Exception ex) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteOperation(@QueryParam("id") int operationID) {
    try {
      if (operationID < 1) {
        return Response.status(Response.Status.BAD_REQUEST).build();
      }

      var service = Container.getOperationService();
      service.deleteOperation(operationID);
      return Response.status(Response.Status.OK).build();
    } catch (Exception ex) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }
}
