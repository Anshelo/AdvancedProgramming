/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

/**
 *
 * @author Santiago Vivas
 */
public class Client {
   private String ciClient;
   private String rucClient;
   private String nameClient;
   private String addressClient;
   private String phoneClient;
   private String mobileClient;
   private String emailClient;

   public Client(){}
    public Client(String ciClient, String rucClient, String nameClient, String addressClient, String phoneClient, String mobileClient, String emailClient) {
        this.ciClient = ciClient;
        this.rucClient = rucClient;
        this.nameClient = nameClient;
        this.addressClient = addressClient;
        this.phoneClient = phoneClient;
        this.mobileClient = mobileClient;
        this.emailClient = emailClient;
    }

    public void setCiClient(String ciClient) {
        this.ciClient = ciClient;
    }

    public void setRucClient(String rucClient) {
        this.rucClient = rucClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public void setMobileClient(String mobileClient) {
        this.mobileClient = mobileClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getCiClient() {
        return ciClient;
    }

    public String getRucClient() {
        return rucClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public String getMobileClient() {
        return mobileClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    @Override
    public String toString() {
        return "Client{" + "ciClient=" + ciClient + ", rucClient=" + rucClient + ", nameClient=" + nameClient + ", addressClient=" + addressClient + ", phoneClient=" + phoneClient + ", mobileClient=" + mobileClient + ", emailClient=" + emailClient + '}';
    }

   
}
