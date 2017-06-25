package api;

import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class User {

    @GET
    @Path("{name}")
    public String select(@PathParam("name") String name) throws Exception {
        Connect con = new Connect();
        return new Gson().toJson(con.queryUser( name ));
    }

    @GET
    public String getAllUsers() throws Exception {
        Connect con = new Connect();
        return new Gson().toJson(con.queryUsers());
    }

    @PUT
    @Path("{name}")
    public String insert(@PathParam("name") String name){
        return "inserisci " + name.toUpperCase();
    }

    @POST
    @Path("{name}")
    public String post(@PathParam("name") String name){
        return "posta " + name.toUpperCase();
    }

    @DELETE
    @Path("{name}")
    public String remove(@PathParam("name") String name) {
        return "rimuovi " + name.toUpperCase();
    }
}