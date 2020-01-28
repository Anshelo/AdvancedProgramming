/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Carrier;
import ec.edu.espe.transport.model.Guide;
import ec.edu.espe.transport.model.GuideDAO;
import ec.edu.espe.transport.model.GuideDetail;
import ec.edu.espe.transport.model.Product;
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
 * @author DenniseSandoval
 */
@Path("guide")
public class GuideResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GuideResource
     */
    public GuideResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.services.GuideResource
     * @return an instance of ec.edu.espe.transport.model.Guide
     * @throws java.sql.SQLException
     */
    @Path("/showallguides")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Guide> getGuide() throws SQLException {
        GuideDAO guide = new GuideDAO();
        ArrayList<Guide> objGuide=new ArrayList<Guide>();
        objGuide = guide.showAllGuides();
        return objGuide;
    }
    @Path("/showguidebyid/{idguide}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Guide getGuidebyId(@PathParam("idguide") String id) throws SQLException {
        GuideDAO guide = new GuideDAO();
        Guide objGuide= new Guide();
        objGuide=guide.searchGuidebyId(id);
        return objGuide;
    }
    
    @Path("/removeguide/{idguide}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Guide> deleteGuide(@PathParam("idguide") String id) throws SQLException{
        GuideDAO guide =new GuideDAO();
        guide.deleteGuide(id);
        ArrayList<Guide> listGuide= new ArrayList<Guide>();
        listGuide=guide.showAllGuides();
        return listGuide;
    }
    
    @Path("/updateguide/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Guide updateGuide(Guide objGuide, @PathParam("id") String id) throws SQLException{
        GuideDAO guide=new GuideDAO();
        guide.updateGuide(objGuide,id);
        /*Guide guideOb=new Guide();
        guideOb=guide.searchGuidebyId(id);*/
        return objGuide;
    }
    @Path("/insertguide")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Guide addGuide(Guide objGuide) throws SQLException{
        GuideDAO guide = new GuideDAO();
       return guide.addGuide(objGuide);
    } 
    @Path("/calculatetotal/addguidedetail")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GuideDetail addGuide(GuideDetail objGuide) throws SQLException{
        GuideDAO guide = new GuideDAO();
       return guide.addGuideDetail(objGuide);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Guide content) {
    }
}
