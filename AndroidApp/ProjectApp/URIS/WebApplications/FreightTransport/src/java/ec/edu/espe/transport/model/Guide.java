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
public class Guide {
    private String guideId;
    private String sendDate;
    private String deliverDate;
    private int quantity;
    private double total;
    private String customerId;
    private String carrierCard;
    private String zoneCode;
    /*
    {
    "guideId":"05",
    "sendDate":"1997/10/30",
    "deliverDate":"1997/10/30",
    "quantity":1,
    "total":34.50,
    "customerId":"1714298823",
    "carrierCard":"1726415672",
    "zoneCode":"1"
    }
    */

    public Guide() {
    }

    public Guide(String guideId, String sendDate, String deliverDate, int quantity, double total, String customerId, String carrierCard, String zoneCode) {
        this.guideId = guideId;
        this.sendDate = sendDate;
        this.deliverDate = deliverDate;
        this.quantity = quantity;
        this.total = total;
        this.customerId = customerId;
        this.carrierCard = carrierCard;
        this.zoneCode = zoneCode;
    }

    /**
     * @return the guideId
     */
    public String getGuideId() {
        return guideId;
    }

    /**
     * @param guideId the guideId to set
     */
    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    /**
     * @return the sendDate
     */
    public String getSendDate() {
        return sendDate;
    }

    /**
     * @param sendDate the sendDate to set
     */
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * @return the deliverDate
     */
    public String getDeliverDate() {
        return deliverDate;
    }

    /**
     * @param deliverDate the deliverDate to set
     */
    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the carrierCard
     */
    public String getCarrierCard() {
        return carrierCard;
    }

    /**
     * @param carrierCard the carrierCard to set
     */
    public void setCarrierCard(String carrierCard) {
        this.carrierCard = carrierCard;
    }

    /**
     * @return the zoneCode
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * @param zoneCode the zoneCode to set
     */
    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
}
