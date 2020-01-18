/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Carrier;
import ec.edu.espe.transport.model.CarrierDAO;
import ec.edu.espe.transport.model.Client;
import ec.edu.espe.transportist.control.ClientDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Santiago Vivas
 */
@Path("client")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ClientResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.transport.services.ClientResource
     *
     * @return an instance of ec.edu.espe.transport.model.Client
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ClientResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Client content) {
    }

    @Path("addClient")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Client insertClient(Client client) throws SQLException {
        ClientDAO newClient = new ClientDAO();
        if(newClient.validadorDeCedula(client.getCiClient())){
            return newClient.addClient(client);
        }else{
            return new Client();
        } 
    }

    @Path("searchClient/{ci}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClient(@PathParam("ci") String ci) {
        ClientDAO searchedClient = new ClientDAO();
        return searchedClient.searchClientByCi(ci);
    }
    
    @Path("clients")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Client> getClients() {
        ClientDAO searchedClients = new ClientDAO();
        return searchedClients.showAllCustomers();
    }

    @PUT
    @Path("/updateclient/{ci}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Client updateClient(Client data) {
        ClientDAO updatedClient = new ClientDAO();
        updatedClient.updateClient(data);
        return updatedClient.searchClientByCi(data.getCiClient());
    }

    @DELETE
    @Path("/deleteClient/{ciCustomer}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteClient(@PathParam("ciCustomer") String ciCustomer) throws SQLException{
        ClientDAO deletedClient = new ClientDAO();
        deletedClient.deleteClient(ciCustomer);
    }
}
