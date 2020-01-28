/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

/**
 *
 * @author Mateo
 */
public class Zone {

    private String codigozona;
    private String nombrezona;
        
    /*
    {
    "codigozona":"6",
    "nombrezona":"Ibarra"
    }
    */

    public Zone() {
    }

    public Zone(String codigozona, String nombrezona) {
        this.codigozona = codigozona;
        this.nombrezona = nombrezona;
    }

    public String getCodigozona() {
        return codigozona;
    }

    public void setCodigozona(String codigozona) {
        this.codigozona = codigozona;
    }

    public String getNombrezona() {
        return nombrezona;
    }

    public void setNombrezona(String nombrezona) {
        this.nombrezona = nombrezona;
    }

}
