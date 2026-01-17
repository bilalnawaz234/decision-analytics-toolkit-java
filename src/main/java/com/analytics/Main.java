package com.analytics;

import com.analytics.model.Product;
import com.analytics.service.BreakEvenService;
import com.analytics.service.ProfitAnalysisService;
import com.analytics.util.CsvReader;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String DEFAULT_CSV_PATH = "data/sample_sales_data.csv";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Product> products = List.of();

        while (true) {
            printMenu(products);

            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> {
                    products = CsvReader.readProducts(DEFAULT_CSV_PATH);
                    System.out.println("Loaded " + products.size() + " products.\n");
                }
                case 2 -> {
                    ensureLoaded(products);
                    printSummary(products);
                }
                case 3 -> {
                    ensureLoaded(products);
                    ProfitAnalysisService.printProductProfits(products);
                    printTotals(products);
                }
                case 4 -> {
                    ensureLoaded(products);
                    printBreakEvenReport(products);
                }
                case 5 -> {
                    ensureLoaded(products);
                    double pct = readDouble(scanner, "Enter price change %: ");
                    printScenarioPriceChange(products, pct);
                }
                case 0 -> {
                    System.out.println("Exiting application.");
                    return;
                }
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    private static void printSummary(List<Product> products) {
        System.out.println("\n--- Product Summary ---");
        for (int i = 0; i < Math.min(products.size(), 10); i++) {
            Product p = products.get(i);
            System.out.printf(
                    "%d) %s | Revenue: %.2f | Cost: %.2f | Profit: %.2f%n",
                    i + 1,
                    p.getName(),
                    p.getRevenue(),
                    p.getTotalCost(),
                    p.getProfit()
            );
        }
        System.out.println();
    }

    private static void printTotals(List<Product> products) {
        double totalRevenue = ProfitAnalysisService.calculateTotalRevenue(products);
        double totalProfit = ProfitAnalysisService.calculateTotalProfit(products);

        System.out.printf(
                "%nTOTAL REVENUE: %.2f%nTOTAL PROFIT: %.2f%n%n",
                totalRevenue,
                totalProfit
        );
    }

    private static void printBreakEvenReport(List<Product> products) {
        System.out.println("\n--- Break-even Analysis ---");
        System.out.printf("%-25s %15s %18s%n", "Product", "BE Units", "BE Revenue");

        products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .forEach(p -> {
                    int beUnits = BreakEvenService.calculateBreakEvenUnits(p);

                    if (beUnits == -1) {
                        System.out.printf("%-25s %15s %18s%n", p.getName(), "N/A", "N/A");
                    } else {
                        double beRevenue = BreakEvenService.calculateBreakEvenRevenue(p);
                        System.out.printf("%-25s %15d %18.2f%n", p.getName(), beUnits, beRevenue);
                    }
                });

        System.out.println();
    }

    private static void printScenarioPriceChange(List<Product> products, double pctChange) {
        double factor = 1 + pctChange / 100.0;

        System.out.println("\nScenario Analysis (" + pctChange + "% price change)");
        System.out.printf("%-25s %12s %12s %12s%n",
                "Product", "Old Profit", "New Profit", "Delta");

        for (Product p : products) {
            double oldProfit = p.getProfit();

            double newRevenue = (p.getPrice() * factor) * p.getUnitsSold();
            double newTotalCost = (p.getVariableCost() * p.getUnitsSold()) + p.getFixedCost();
            double newProfit = newRevenue - newTotalCost;

            double delta = newProfit - oldProfit;

            System.out.printf(
                    "%-25s %12.2f %12.2f %12.2f%n",
                    p.getName(),
                    oldProfit,
                    newProfit,
                    delta
            );
        }
        System.out.println();
    }

    private static void printMenu(List<Product> products) {
        System.out.println("========================================");
        System.out.println(" Decision Analytics Toolkit");
        System.out.println("========================================");
        System.out.println("Records loaded: " + products.size() + "\n");

        System.out.println("1) Load CSV data");
        System.out.println("2) View product summary");
        System.out.println("3) Profit analysis");
        System.out.println("4) Break-even analysis");
        System.out.println("5) Scenario analysis");
        System.out.println("0) Exit\n");
    }

    private static void ensureLoaded(List<Product> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalStateException("No data loaded.\n");
        }
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }
}
