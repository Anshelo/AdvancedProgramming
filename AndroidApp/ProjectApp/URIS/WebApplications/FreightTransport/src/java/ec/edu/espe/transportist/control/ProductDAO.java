/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportist.control;

import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ProductDAO {

    DBConnect con;

    public ProductDAO() {
        con = new DBConnect();
    }

    public Product searchproductByCi(String id) {
        Product product = new Product();
        Connection acceso = con.connect();
        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM producto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                if (id.equals(rs.getString(1))) {
                    product = new Product();
                    product.setProductCode(rs.getString(1));
                    product.setProductName(rs.getString(2));
                    product.setDescription(rs.getString(3));
                    product.setWeight(rs.getDouble(4));
                    product.setSensibility(rs.getString(5));
                    product.setUnitValue(rs.getDouble(6));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return product;
    }

    public ArrayList<Product> mostrarProducto(float peso) {
        ArrayList<Product> listaB = new ArrayList<Product>();
        Product Producto;
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM producto WHERE peso='" + peso + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto = new Product();
                Producto.setProductCode(rs.getString(1));
                Producto.setProductName(rs.getString(2));
                Producto.setDescription(rs.getString(3));
                Producto.setWeight(rs.getDouble(4));
                Producto.setSensibility(rs.getString(5));
                Producto.setUnitValue(rs.getDouble(6));
                listaB.add(Producto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<Product> printProducto() {
        ArrayList<Product> listaB = new ArrayList<Product>();
        Product Producto;
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM producto ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto = new Product();
                Producto.setProductCode(rs.getString(1));
                Producto.setProductName(rs.getString(2));
                Producto.setDescription(rs.getString(3));
                Producto.setWeight(rs.getDouble(4));
                Producto.setSensibility(rs.getString(5));
                Producto.setUnitValue(rs.getDouble(6));
                listaB.add(Producto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public void eliminarProductoIdentificacion(String cod) {
        try {
            Connection accesoDB = con.connect();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE FROM producto where codigoprod='" + cod + "'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Product> mostrarProductoCodigo(String cod) {
        ArrayList<Product> listaB = new ArrayList<Product>();
        Product Producto;
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM producto WHERE codigoprod='" + cod + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto = new Product();
                Producto.setProductCode(rs.getString(1));
                Producto.setProductName(rs.getString(2));
                Producto.setDescription(rs.getString(3));
                Producto.setWeight(rs.getDouble(4));
                Producto.setSensibility(rs.getString(5));
                Producto.setUnitValue(rs.getDouble(6));
                listaB.add(Producto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public void modificarProductoIdentificacion(Product pro) {
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("UPDATE producto SET nombreprod='" + pro.getProductName() + "', descripcion='" + pro.getDescription()
                    + "', peso='" + pro.getWeight() + "', sensibilidad='" + pro.getSensibility() + "', valorunit='" + pro.getUnitValue()
                    + "'WHERE codigoprod='" + pro.getProductCode() + "'");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarProduct(Product prod) {
        Connection acceso = con.connect();
        String sql = "INSERT INTO producto (codigoprod,nombreprod,descripcion,peso,sensibilidad,valorunit) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, prod.getProductCode());
            ps.setString(2, prod.getProductName());
            ps.setString(3, prod.getDescription());
            ps.setDouble(4, prod.getWeight());
            ps.setString(5, prod.getSensibility());
            ps.setDouble(6, prod.getUnitValue());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
