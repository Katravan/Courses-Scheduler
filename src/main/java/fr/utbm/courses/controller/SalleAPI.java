package fr.utbm.courses.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.utbm.courses.entity.Salle;
import fr.utbm.courses.repository.SalleDao;
import fr.utbm.courses.repository.Dbservice;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

@Path("/salles")
public class SalleAPI {
    
   private SalleDao salleStorer = null;
   private ObjectMapper mapper = null;
   
   public SalleAPI() {
       this.salleStorer = new Dbservice();
       this.mapper = new ObjectMapper();
   }

  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllSalles() {
      List<Salle> salles = salleStorer.getRecordsSalle();
       try {
           String res = mapper.writeValueAsString(salles);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(SalleAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
  
  /*@GET
  @Path("/get/{locationId}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSpecificLocation(@PathParam( "locationId" ) String userCode, @Context UriInfo uriInfo) {
        //Location loc = locationStorer.
        return userCode;
  }*/

}