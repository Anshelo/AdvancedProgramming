/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

/**
 *
 * @author DenniseSandoval
 */
public class Carrier {
   private String idCarrier;
   private String ci;
   private String birthDate;
   private String name;
   private String address;
   private String phone;
   private String mobile;
   private String email;
   private String truckPlate;
   private String truckType;
   public Carrier() {
    }

    public Carrier(String idCarrier, String ci, String birthDate, String name, String address, String phone, String mobile, String email, String truckPlate, String truckType) {
        this.idCarrier = idCarrier;
        this.ci = ci;
        this.birthDate = birthDate;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.truckPlate = truckPlate;
        this.truckType = truckType;
    }

    
    public String getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(String idCarrier) {
        this.idCarrier = idCarrier;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTruckPlate() {
        return truckPlate;
    }

    public void setTruckPlate(String truckPlate) {
        this.truckPlate = truckPlate;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    @Override
    public String toString() {
        return "Carrier{" + "idCarrier=" + idCarrier + ", ci=" + ci + ", birthDate=" + birthDate + ", name=" + name + ", address=" + address + ", phone=" + phone + ", mobile=" + mobile + ", email=" + email + ", truckPlate=" + truckPlate + ", truckType=" + truckType + '}';
    }
   
   

    
    
}
