/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportist.control;

import ec.edu.espe.transport.model.Client;
import ec.edu.espe.transport.model.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Santiago Vivas
 */
public class ClientDAO {

    DBConnect con;

    public ClientDAO() {
        con = new DBConnect();
    }

    public Client addClient(Client client) throws SQLException {
        Connection acceso = con.connect();
        String sql = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, client.getCiClient());
            ps.setString(2, client.getRucClient());
            ps.setString(3, client.getNameClient());
            ps.setString(4, client.getAddressClient());
            ps.setString(5, client.getPhoneClient());
            ps.setString(6, client.getMobileClient());
            ps.setString(7, client.getEmailClient());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return client;
    }
    
    public ArrayList<Client> showAllCustomers() {
        Client client = new Client();
        Connection acceso = con.connect();
        ArrayList<Client> allCustomers = new ArrayList<>();
        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    client = new Client();
                    client.setCiClient(rs.getString(1));
                    client.setRucClient(rs.getString(2));
                    client.setNameClient(rs.getString(3));
                    client.setAddressClient(rs.getString(4));
                    client.setPhoneClient(rs.getString(5));
                    client.setMobileClient(rs.getString(6));
                    client.setEmailClient(rs.getString(7));
                allCustomers.add(client);
                        
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return allCustomers;
    }

    public Client searchClientByCi(String ci) {
        Client client = new Client();
        Connection acceso = con.connect();
        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                if (ci.equals(rs.getString(1))) {
                    client = new Client();
                    client.setCiClient(rs.getString(1));
                    client.setRucClient(rs.getString(2));
                    client.setNameClient(rs.getString(3));
                    client.setAddressClient(rs.getString(4));
                    client.setPhoneClient(rs.getString(5));
                    client.setMobileClient(rs.getString(6));
                    client.setEmailClient(rs.getString(7));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return client;
    }

    public void updateClient(Client client) {
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("UPDATE cliente SET ruc='" + client.getRucClient()
                    + "', nombre='" + client.getNameClient() + "', direccion='" + client.getAddressClient() + "', telfconvencional='" + client.getPhoneClient()
                    + "', telfcelular='" + client.getMobileClient() + "', correo='" + client.getEmailClient()
                    + "'WHERE ci='" + client.getCiClient() + "'");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteClient(String ci) {
        try {
            Connection accesoDB = con.connect();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE FROM cliente where ci='" + ci + "'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
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
    
    

}
