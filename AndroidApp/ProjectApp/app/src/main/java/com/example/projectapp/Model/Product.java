package com.example.projectapp.Model;

public class Product {
    private String productCode;
    private String productName;
    private String description;
    private float weight;
    private String sensibility;
    private float unitValue;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getSensibility() {
        return sensibility;
    }

    public void setSensibility(String sensibility) {
        this.sensibility = sensibility;
    }

    public float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(float unitValue) {
        this.unitValue = unitValue;
    }
}
