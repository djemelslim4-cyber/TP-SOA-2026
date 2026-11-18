package Service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/calcul")
@Produces(MediaType.APPLICATION_JSON)
public class CalculRest {

    private final Calculatrice calc = new Calculatrice();

    @GET
    @Path("/addition")
    public Operation addition(@QueryParam("a") double a, @QueryParam("b") double b) {
        return new Operation("addition", a, b, calc.addition(a, b));
    }

    @GET
    @Path("/soustraction")
    public Operation soustraction(@QueryParam("a") double a, @QueryParam("b") double b) {
        return new Operation("soustraction", a, b, calc.soustraction(a, b));
    }

    @GET
    @Path("/multiplication")
    public Operation multiplication(@QueryParam("a") double a, @QueryParam("b") double b) {
        return new Operation("multiplication", a, b, calc.multiplication(a, b));
    }

    @GET
    @Path("/division")
    public Response division(@QueryParam("a") double a, @QueryParam("b") double b) {
        try {
            Operation op = new Operation("division", a, b, calc.division(a, b));
            return Response.ok(op).build();
        } catch (ArithmeticException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"erreur\":\"" + e.getMessage() + "\"}")
                    .build();
        }
    }
}