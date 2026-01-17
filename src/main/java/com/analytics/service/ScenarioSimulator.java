package com.analytics.service;

import com.analytics.model.Product;

import java.util.List;

public class ScenarioSimulator {

    public static double calculateNewProfit(Product product, double pctChange) {
        double factor = 1 + pctChange / 100.0;

        double newRevenue = (product.getPrice() * factor) * product.getUnitsSold();
        double totalCost = (product.getVariableCost() * product.getUnitsSold()) + product.getFixedCost();

        return newRevenue - totalCost;
    }

    public static void printScenarioReport(List<Product> products, double pctChange) {
        System.out.println("\nScenario Analysis (" + pctChange + "% price change)");
        System.out.printf("%-25s %12s %12s %12s%n",
                "Product", "Old Profit", "New Profit", "Delta");

        for (Product p : products) {
            double oldProfit = p.getProfit();
            double newProfit = calculateNewProfit(p, pctChange);
            double delta = newProfit - oldProfit;

            System.out.printf("%-25s %12.2f %12.2f %12.2f%n",
                    p.getName(), oldProfit, newProfit, delta);
        }
        System.out.println();
    }
}
