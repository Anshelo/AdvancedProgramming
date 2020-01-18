/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anshelo
 */
public class CarrierDAO {
   DBConnect con;
   

    public CarrierDAO() {
        con=new DBConnect();
    }
  
    
    public Carrier SearchTruckCarrier(String truck) {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier = new Carrier();
        try{
            Connection acceso = con.connect();
            
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista ");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                if(truck.equals(rs.getString(9))){
                    
        
                carrier=new Carrier();
                carrier.setIdCarrier(Integer.toString(rs.getInt(1)));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return carrier;
         
  }
    public Carrier addCarrier(Carrier carrier)throws SQLException{
        Connection acceso = con.connect();
        String sql = "INSERT INTO transportista VALUES(?,?,?,?,?,?,?,?,?,?)";
         try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(carrier.getIdCarrier()));
            ps.setString(2, carrier.getCi());
            ps.setString(3, carrier.getBirthDate());
            ps.setString(4, carrier.getName());
            ps.setString(5, carrier.getAddress());
            ps.setString(6, carrier.getPhone());
            ps.setString(7, carrier.getMobile());
            ps.setString(8, carrier.getEmail());
            ps.setString(9, carrier.getTruckPlate());
            ps.setString(10, carrier.getTruckType());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return carrier;
    }
    public ArrayList<Carrier> searchTruckCarrier(String truck) {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier;
        Connection acceso = con.connect();
        try{
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista where tipoCamion='"+truck+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                carrier=new Carrier();
                carrier.setIdCarrier(rs.getString(1));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                listaB.add(carrier);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public Carrier printCarrierById(String id) {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier = new Carrier();
        Connection acceso = con.connect();
        try{
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                if(id.equals(rs.getString(1))){
                carrier = new Carrier();
                carrier.setIdCarrier(rs.getString(1));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return carrier;
    }
    public ArrayList<Carrier> printCarrier() {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier;
        Connection acceso = con.connect();
        try{
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                carrier=new Carrier();
                carrier.setIdCarrier(rs.getString(1));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                listaB.add(carrier);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public void updateCarrier(Carrier carrier){
        try{
            Connection acceso = con.connect();
            PreparedStatement ps= acceso.prepareStatement("UPDATE transportista SET ci='" +carrier.getCi()+"', birthdate='"+carrier.getBirthDate()
                    +"', nombre='"+carrier.getName()+"', direccion='"+carrier.getAddress()+"', telfconvencional='"+carrier.getPhone()
                    +"', telfcelular='"+carrier.getMobile()+"', correo='"+carrier.getEmail()+"', placaCamion='"+carrier.getTruckPlate()+"', tipoCamion='"+carrier.getTruckType()
                    +"'WHERE codigotransp='"+carrier.getIdCarrier()+"'" );
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public void deleteCarrier(String id){
       
        try{
            //preparar la ejecucion
            Connection accesoDB = con.connect();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE FROM transportista WHERE codigotransp='"+id+ "'");
            ps.executeUpdate();
        
        }
        catch(SQLException e){
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
