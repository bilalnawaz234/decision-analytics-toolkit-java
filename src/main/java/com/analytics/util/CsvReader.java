package com.analytics.util;

import com.analytics.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Product> readProducts(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String name = values[0];
                double price = Double.parseDouble(values[1]);
                int unitsSold = Integer.parseInt(values[2]);
                double variableCost = Double.parseDouble(values[3]);
                double fixedCost = Double.parseDouble(values[4]);

                products.add(new Product(
                        name, price, unitsSold, variableCost, fixedCost
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return products;
    }
}
