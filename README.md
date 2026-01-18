# Decision Analytics Toolkit (Java)

A Java-based decision-support tool designed to help small businesses analyze profitability, understand cost structures, and evaluate pricing scenarios using real sales data.

Instead of building a traditional CRUD application, this project focuses on **business analytics and decision-making logic**, translating raw data into actionable insights.

---

## Business Problem

Small businesses often collect sales data but lack the tools to answer key questions such as:
- Which products are truly profitable?
- How many units must be sold to break even?
- How would pricing changes impact overall profit?

This toolkit provides a structured way to evaluate those questions using financial metrics and scenario analysis.

---

## Features

- CSV-based data ingestion
- Product-level revenue, cost, and profit analysis
- Total revenue and total profit calculation
- Break-even analysis per product
- Scenario simulation for price changes
- Modular, service-based Java design

---


---

## How to Download

### Option 1: Download as ZIP
1. Go to the GitHub repository
2. Click the green **Code** button
3. Select **Download ZIP**
4. Extract the folder to your computer
5. Run on coding platform
   

### Option 2: Clone with Git
```bash
git clone https://github.com/your-username/decision-analytics-toolkit-java.git

## Testing with Sample Data

This project includes a sample dataset to verify functionality and validate business logic.

### Steps to Test

1. Run the application (`Main.java`) in IntelliJ.
2. Select option `1` to load the sample CSV data.
3. Use the following menu options to validate results:
   - `2` – View product revenue, cost, and profit summary
   - `3` – Run profit analysis and view total revenue and profit
   - `4` – View break-even units and break-even revenue
   - `5` – Run scenario analysis (e.g., enter `5` for a +5% price change)

### Expected Behavior

- Products with higher margins show higher profitability.
- Products with higher fixed costs require more units to break even.
- Increasing prices in scenario analysis increases profit for products with positive unit sales.
- A `0%` price change results in no profit difference.

### Sample Validation

Using the included `sample_sales_data.csv`, users can manually verify:
- Revenue = `price × unitsSold`
- Total cost = `(variableCost × unitsSold) + fixedCost`
- Profit = `revenue − total cost`
- Break-even units = `fixedCost ÷ (price − variableCost)`

This allows users to confirm the accuracy of calculations without modifying the source code.



