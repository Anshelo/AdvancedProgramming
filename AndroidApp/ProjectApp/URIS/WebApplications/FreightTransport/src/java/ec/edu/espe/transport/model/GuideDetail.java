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
public class GuideDetail {
    private String guideId;
    private String productCode;
    private int quantity;
    private double total;
    /*{
        "guideId"="1",
        "productCode"="01",
        "quantity"=3
    }*/

    public GuideDetail() {
    }

    public GuideDetail(String guideId, String productCode, int quantity, double total) {
        this.guideId = guideId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.total = total;
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
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
    
    
}
