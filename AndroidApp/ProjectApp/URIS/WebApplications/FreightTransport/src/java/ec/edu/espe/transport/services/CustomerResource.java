/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Customer;
import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Guide;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("customer")
public class CustomerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.services.CustomerResource
     * @return an instance of ec.edu.espe.transport.model.Customer
     */
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }
    @Path("/insertcustomer/aftervalidatingid")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer ValidateIdCard(Customer objCustomer) throws SQLException {
        DBConnect connect = new DBConnect();
        boolean validatorIdCard = false;
        String query;
        PreparedStatement state;
        validatorIdCard = validadorDeCedula(objCustomer.getIdCard());
        if (validatorIdCard == true) {
            query = "INSERT INTO cliente" + " (ci,ruc,nombre,direccion,telfconvencional,telfcelular,correo) values (?,?,?,?,?,?,?)";
            state = connect.connect().prepareStatement(query);
            state.setString(1, objCustomer.getIdCard());
            state.setString(2, objCustomer.getRuc());
            state.setString(3, objCustomer.getName());
            state.setString(4, objCustomer.getAddress());
            state.setString(5, objCustomer.getTelephone());
            state.setString(6, objCustomer.getPhone());
            state.setString(7, objCustomer.getEmail());
            state.executeUpdate();}
            Customer customer=new Customer(objCustomer.getIdCard(), objCustomer.getRuc(), objCustomer.getName(), objCustomer.getAddress(), objCustomer.getTelephone(), objCustomer.getPhone(), objCustomer.getEmail());
        
        return customer;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Customer content) {
    }
}
