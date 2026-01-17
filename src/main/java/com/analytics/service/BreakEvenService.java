package com.analytics.service;

import com.analytics.model.Product;

public class BreakEvenService {

    public static int calculateBreakEvenUnits(Product product) {
        if (product.getRevenue() <= 0 || product.getProfit() == 0) {
            return 0;
        }

        double contributionMargin = product.getRevenue() / product.getUnitsSold()
                - product.getTotalCost() / product.getUnitsSold();

        if (contributionMargin <= 0) {
            return -1; // Break-even not achievable
        }

        return (int) Math.ceil(product.getTotalCost() / contributionMargin);
    }
}
