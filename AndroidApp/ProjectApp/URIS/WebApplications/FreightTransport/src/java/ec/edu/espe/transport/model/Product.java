package ec.edu.espe.transport.model;

public class Product {
    private String productCode;
    private String productName;
    private String description;
    private Double weight;
    private String sensibility;
    private Double unitValue;
/*
    {
    "productCode":"01",
    "productName":"Refrigeradora",
    "description":"Pesado",
    "weight":20.0f,
    "sensibility":"Fragil"
    }
    */

    public Product() {
    }

    public Product(String productCode, String productName, String description, Double weight, String sensibility, Double unitValue) {
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.weight = weight;
        this.sensibility = sensibility;
        this.unitValue = unitValue;
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
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * @return the sensibility
     */
    public String getSensibility() {
        return sensibility;
    }

    /**
     * @param sensibility the sensibility to set
     */
    public void setSensibility(String sensibility) {
        this.sensibility = sensibility;
    }

    /**
     * @return the unitValue
     */
    public Double getUnitValue() {
        return unitValue;
    }

    /**
     * @param unitValue the unitValue to set
     */
    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }
    
    
}
