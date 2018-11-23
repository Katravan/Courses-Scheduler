/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.utbm.courses.entity.Client;
import fr.utbm.courses.entity.CourseSession;
import fr.utbm.courses.repository.ClientDao;
import fr.utbm.courses.repository.CourseSessionDao;
import fr.utbm.courses.repository.Dbservice;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lisa Bessone and Florian Inard
 */
@Path("/clients")
public class ClientAPI {
    
   private ClientDao clientStorer = null;
   private CourseSessionDao courseSessionStorer = null;
   private ObjectMapper mapper = null;
   
   public ClientAPI() {
       Dbservice db = new Dbservice();
       this.clientStorer = db;
       this.courseSessionStorer = db;
       this.mapper = new ObjectMapper();
   }
   
  @POST
  @Path("/subscribe/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String subscribeToACourseSession(String body) {
      
      Map<String, Object> map = new HashMap<>();
       try {
           map = mapper.readValue(body, new TypeReference<Map<String, String>>(){});
       } catch (IOException ex) {
           Logger.getLogger(ClientAPI.class.getName()).log(Level.SEVERE, null, ex);
       }
      
      CourseSession courseSession = courseSessionStorer.getCourseSession(Integer.parseInt((String)map.get("course_session_id")));
      
      Client client = new Client(null, (String)map.get("lastname"), 
              (String)map.get("firstname"), 
              (String)map.get("address"), 
              (String)map.get("phone"), 
              (String)map.get("email"), 
              courseSession);
      
      clientStorer.createClient(client);
      
      return "{}";
  }
    
}
