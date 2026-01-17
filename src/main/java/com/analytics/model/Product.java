package com.analytics.model;

public class Product {

    private String name;
    private double price;
    private int unitsSold;
    private double variableCost;
    private double fixedCost;

    public Product(String name, double price, int unitsSold, double variableCost, double fixedCost) {
        this.name = name;
        this.price = price;
        this.unitsSold = unitsSold;
        this.variableCost = variableCost;
        this.fixedCost = fixedCost;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getVariableCost() {
        return variableCost;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public double getRevenue() {
        return price * unitsSold;
    }

    public double getTotalCost() {
        return (variableCost * unitsSold) + fixedCost;
    }

    public double getProfit() {
        return getRevenue() - getTotalCost();
    }
}
