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

/**
 *
 * @author DenniseSandoval
 */
public class GuideDAO {

    DBConnect con;

    public GuideDAO() {
        con = new DBConnect();
    }
public Double calculateTotalGuide(String guideId) throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        double totalguide=0.0;
        query = "SELECT * from detalleguia WHERE idguia='" + guideId + "'";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        GuideDetail guide = null;
        GuideDetail tempGuide;
        ArrayList<GuideDetail> guided = new ArrayList();
        while (rs.next()) {
            tempGuide = new GuideDetail(rs.getString("idguia"), rs.getString("codproducto"), rs.getInt("cantidad"), rs.getDouble("total"));
            guided.add(tempGuide);
            totalguide+=rs.getDouble("total");
        }
        return totalguide;
    }
public int calculateQuantityGuide(String guideId) throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        int quantityguide=0;
        query = "SELECT * from detalleguia WHERE idguia='" + guideId + "'";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        GuideDetail guide = null;
        GuideDetail tempGuide;
        ArrayList<GuideDetail> guided = new ArrayList();
        while (rs.next()) {
            tempGuide = new GuideDetail(rs.getString("idguia"), rs.getString("codproducto"), rs.getInt("cantidad"), rs.getDouble("total"));
            guided.add(tempGuide);
            quantityguide+=rs.getInt("cantidad");
        }
        return quantityguide;
    }
    public Guide addGuide(Guide objGuide) throws SQLException {
        Connection acceso = con.connect();
        double totalguide;
        int quantityguide;
        totalguide=calculateTotalGuide(objGuide.getGuideId());
        quantityguide=calculateQuantityGuide(objGuide.getGuideId());
        objGuide.setTotal(totalguide);
        objGuide.setQuantity(quantityguide);
        String sql = "INSERT INTO guia"
                + " (idguia,fechaenvio,fecha_entrega,cantidad,total,ci_cliente,ci_transportista,cod_zona) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement state = acceso.prepareStatement(sql);
            state.setString(1, objGuide.getGuideId());
            state.setString(2, objGuide.getSendDate());
            state.setString(3, objGuide.getDeliverDate());
            state.setInt(4, objGuide.getQuantity());
            state.setDouble(5, objGuide.getTotal());
            state.setString(6, objGuide.getCustomerId());
            state.setString(7, objGuide.getCarrierCard());
            state.setString(8, objGuide.getZoneCode());
            state.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Guide guide = new Guide(objGuide.getGuideId(), objGuide.getSendDate(), objGuide.getDeliverDate(), objGuide.getQuantity(), objGuide.getTotal(), objGuide.getCustomerId(), objGuide.getCarrierCard(), objGuide.getZoneCode());
        return guide;
    }

    public Product GetUnitValue(String codigo) throws SQLException {
        
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from producto WHERE codigoprod='"+codigo+"'";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        Product producto = null;
        while (rs.next()) {
        producto=new Product(rs.getString("codigoprod"),rs.getString("nombreprod"),
        rs.getString("descripcion"),rs.getDouble("peso"),rs.getString("sensibilidad"),rs.getDouble("valorunit")); 
        
        }
        return producto;
                
    }

    public GuideDetail addGuideDetail(GuideDetail objGuide) throws SQLException {
        Connection acceso = con.connect();
        double totalproduct = 0.0;
        String productcode;
        Product objProduct= new Product();
        objProduct= GetUnitValue(objGuide.getProductCode());
  
        String sql = "INSERT INTO detalleguia"
                + " (idguia,codproducto,cantidad,total) values (?,?,?,?)";
        
        try {

            PreparedStatement state = acceso.prepareStatement(sql);
            state.setString(1, objGuide.getGuideId());
            state.setString(2, objGuide.getProductCode());
            state.setInt(3, objGuide.getQuantity());
            totalproduct=objProduct.getUnitValue()*objGuide.getQuantity();
            objGuide.setTotal(totalproduct);
            state.setDouble(4, objGuide.getTotal());
            state.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        GuideDetail guide = new GuideDetail(objGuide.getGuideId(), objGuide.getProductCode(),
                objGuide.getQuantity(), objGuide.getTotal());
        return guide;
    }

    public ArrayList<Guide> showAllGuides() throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from guia";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        Guide tempGuide;
        ArrayList<Guide> guide = new ArrayList();
        while (rs.next()) {
            tempGuide = new Guide(rs.getString("idguia"), rs.getString("fechaenvio"), rs.getString("fecha_entrega"), rs.getInt("cantidad"), rs.getDouble("total"), rs.getString("ci_cliente"), rs.getString("ci_transportista"), rs.getString("cod_zona"));
            guide.add(tempGuide);
        }
        return guide;
    }

    public Guide searchGuidebyId(String guideId) throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from guia WHERE idguia='" + guideId + "'";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        Guide guide = null;
        while (rs.next()) {
            guide = new Guide(rs.getString("idguia"), rs.getString("fechaenvio"), rs.getString("fecha_entrega"), rs.getInt("cantidad"), rs.getDouble("total"), rs.getString("ci_cliente"), rs.getString("ci_transportista"), rs.getString("cod_zona"));
        }
        return guide;
    }
    
    public void deleteGuide(String guideId) {
        Connection acceso = con.connect();
        String sql = "DELETE FROM guia WHERE idguia='" + guideId + "'";
        try {
            PreparedStatement state = acceso.prepareStatement(sql);
            state.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateGuide(Guide guide, String id) {
        String sql = "UPDATE guia SET fechaenvio='" + guide.getSendDate() + "',fecha_entrega='" + guide.getDeliverDate() + "',cantidad='" + guide.getQuantity() + "',total='" + guide.getTotal() + "',ci_cliente='" + guide.getCustomerId() + "',ci_transportista='" + guide.getCarrierCard() + "',cod_zona='" + guide.getZoneCode() + "' WHERE idguia like '" + id + "'";

        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
