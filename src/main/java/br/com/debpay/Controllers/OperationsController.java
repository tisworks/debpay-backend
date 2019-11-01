package br.com.debpay.Controllers;

import br.com.debpay.Container;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;

@Path("operation")
public class OperationsController {

   @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listOperation(@QueryParam("id") int id, @QueryParam("due_date") String dueDate) {
        // TODO we should validate the parameters
        try {
            var service = Container.getOperationService();
            var result = service.listOperations(id,
                    new SimpleDateFormat("yyyy-MM-dd").parse(dueDate));
            return Response
                    .status(Response.Status.OK)
                    .entity(result)
                    .build();
        } catch(Exception e) {
            // TODO
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}