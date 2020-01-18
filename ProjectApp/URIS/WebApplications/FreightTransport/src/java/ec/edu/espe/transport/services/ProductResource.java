/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Carrier;
import ec.edu.espe.transport.model.CarrierDAO;
import ec.edu.espe.transport.model.Client;
import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Product;
import ec.edu.espe.transportist.control.ClientDAO;
import ec.edu.espe.transportist.control.ProductDAO;
import java.sql.PreparedStatement;
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
@Path("product")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }
    
    @POST
    @Path("/calculateproductprice/inserit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addProduct(Product objProduct) throws SQLException {
        DBConnect connect = new DBConnect();
        double valueProduct, priceKg = 2, priceFragile = 4.50;
        String query;
        PreparedStatement state;
        String sensibility;
        sensibility= objProduct.getSensibility().toLowerCase();
        if (sensibility.equals("fragil")) {
            valueProduct = (objProduct.getWeight() * priceKg) + priceFragile;
        } else {
            valueProduct = objProduct.getWeight() * priceKg;
        }
        query = "INSERT INTO producto" + " (codigoprod,nombreprod,descripcion,peso,sensibilidad,valorunit) values (?,?,?,?,?,?)";
        state = connect.connect().prepareStatement(query);
        state.setString(1, objProduct.getProductCode());
        state.setString(2, objProduct.getProductName());
        state.setString(3, objProduct.getDescription());
        state.setDouble(4, objProduct.getWeight());
        state.setString(5, objProduct.getSensibility());
        state.setDouble(6, valueProduct);
        state.executeUpdate();
        Product product = new Product(objProduct.getProductCode(), objProduct.getProductName(), objProduct.getDescription(), 
                objProduct.getWeight(), objProduct.getSensibility(), valueProduct);
        return product;
    }
    @GET
    @Path("{weight}")    
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJsonProductoPeso(@PathParam("weight") float peso) {
        ProductDAO prod=new ProductDAO();
        ArrayList<Product> producto=new ArrayList<Product>();
        producto=prod.mostrarProducto(peso);
        return producto;
    }
    
    @Path("searchProduct/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getCarrierTruck(@PathParam("id") String id) {
        ProductDAO searchedProduct = new ProductDAO();
        return searchedProduct.searchproductByCi(id);
    }

    
    
    @PUT
    @Path("/modify/product")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Product> modifyProduct(Product data) {
        ProductDAO response = new ProductDAO();
        response.modificarProductoIdentificacion(data);
  /*      System.out.println(data.getCodigo());
        System.out.println(data.getNombre());
        System.out.println(data.getDescripcion());
        System.out.println(data.getPeso());
        System.out.println(data.getSensibilidad());
        System.out.println(data.getValorU());
*/        ProductDAO prod=new ProductDAO();
        
        ArrayList<Product> producto=new ArrayList<Product>();
        producto=prod.mostrarProductoCodigo(data.getProductCode());
        return producto;

    }
    
    @PUT
    @Path("/updateproduct/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(Product data) {
        ProductDAO updatedproduct = new ProductDAO();
        updatedproduct.modificarProductoIdentificacion(data);
    }
    
    @POST
    @Path("/createProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Product data) {
        ProductDAO response = new ProductDAO();
        response.adicionarProduct(data);
    //    response.adicionarGuia(data);
      //  System.out.println(data.getCodigo());
    //    System.out.println(data.getNombre());
      //  System.out.println(data.getCiudad());
    }    
    
   @DELETE
    @Path("/deleteProduct/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteClient(@PathParam("code") String code) throws SQLException{
        ProductDAO deletedProduct = new ProductDAO();
        deletedProduct.eliminarProductoIdentificacion(code);
    }
    
    @Path("getproducts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProduct() {
        ProductDAO productList = new ProductDAO();
         ArrayList<Product> productVO=new ArrayList<Product>();
         productVO = productList.printProducto();
         return productVO;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
