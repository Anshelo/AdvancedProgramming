/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class ZonaDAO {
    
    Conexion con;

    public ZonaDAO() {
        con = new Conexion();
    }
    
    public ArrayList<ZonaVO> mostrarZonaCodigo(int codigozona){
        ArrayList <ZonaVO> listaB=new ArrayList <>();
        ZonaVO vzo;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM zona WHERE codigozona='"+codigozona+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                vzo =new ZonaVO();
                vzo.setCodigozona(rs.getInt(1));
                vzo.setNombrezona(rs.getNString(2));
                listaB.add(vzo);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
}
