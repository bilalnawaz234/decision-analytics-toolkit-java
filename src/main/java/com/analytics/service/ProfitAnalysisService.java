package com.analytics.service;

import com.analytics.model.Product;

import java.util.List;

public class ProfitAnalysisService {

    public static double calculateTotalRevenue(List<Product> products) {
        double totalRevenue = 0.0;
        for (Product product : products) {
            totalRevenue += product.getRevenue();
        }
        return totalRevenue;
    }

    public static double calculateTotalProfit(List<Product> products) {
        double totalProfit = 0.0;
        for (Product product : products) {
            totalProfit += product.getProfit();
        }
        return totalProfit;
    }

    public static void printProductProfits(List<Product> products) {
        System.out.println("Product Profit Analysis:");
        for (Product product : products) {
            System.out.printf(
                    "%s | Revenue: %.2f | Profit: %.2f%n",
                    product.getName(),
                    product.getRevenue(),
                    product.getProfit()
            );
        }
    }
}
