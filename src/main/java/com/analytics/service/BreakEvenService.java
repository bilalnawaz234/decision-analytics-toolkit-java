package com.analytics.service;

import com.analytics.model.Product;

public class BreakEvenService {

    public static int calculateBreakEvenUnits(Product product) {
        double contributionMarginPerUnit = product.getPrice() - product.getVariableCost();

        if (contributionMarginPerUnit <= 0) {
            return -1;
        }

        if (product.getFixedCost() <= 0) {
            return 0;
        }

        return (int) Math.ceil(product.getFixedCost() / contributionMarginPerUnit);
    }

    public static double calculateBreakEvenRevenue(Product product) {
        int units = calculateBreakEvenUnits(product);
        if (units <= 0) {
            return units;
        }
        return units * product.getPrice();
    }
}
