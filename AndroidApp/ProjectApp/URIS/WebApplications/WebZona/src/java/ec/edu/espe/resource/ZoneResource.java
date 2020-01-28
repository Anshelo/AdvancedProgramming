/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.resource;

import ec.edu.espe.model.ZonaDAO;
import ec.edu.espe.model.ZonaVO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mateo
 */
@Path("Zone")
public class ZoneResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ZoneResource
     */
    public ZoneResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.resource.ZoneResource
     * @return an instance of java.lang.String
     */
        @GET
    @Path("{codigozona}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ZonaVO> getJsonProductoPeso(@PathParam("codigozona") int codigozona) {
        ZonaDAO zdao = new ZonaDAO();
        ArrayList<ZonaVO> zvo = new ArrayList<>();
        zvo = zdao.mostrarZonaCodigo(codigozona);
        return zvo;
    }
}
