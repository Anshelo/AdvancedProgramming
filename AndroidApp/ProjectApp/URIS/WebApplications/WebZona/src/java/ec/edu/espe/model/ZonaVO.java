/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author Mateo
 */
public class ZonaVO {
     private int codigozona;
    private String nombrezona;

    public ZonaVO() {
    }

    public ZonaVO(int codigozona, String nombrezona) {
        this.codigozona = codigozona;
        this.nombrezona = nombrezona;
    }

    public int getCodigozona() {
        return codigozona;
    }

    public void setCodigozona(int codigozona) {
        this.codigozona = codigozona;
    }

    public String getNombrezona() {
        return nombrezona;
    }

    public void setNombrezona(String nombrezona) {
        this.nombrezona = nombrezona;
    }
    
}
