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
## Project Structure

- decision-analytics-toolkit-java  
  - data  
    - sample_sales_data.csv  
  - src  
    - main  
      - java  
        - com  
          - analytics  
            - Main.java  
            - model  
            - service  
            - util  
---

## How to Download

### Option 1: Download as ZIP

1. Go to the GitHub repository  
2. Click the green **Code** button  
3. Select **Download ZIP**  
4. Extract the folder to your computer  
5. Open the project in your preferred coding platform  

### Option 2: Clone with Git

git clone https://github.com/your-username/decision-analytics-toolkit-java.git

## How to Run
### Open the project in IntelliJ IDEA

Open src/main/java/com/analytics/Main.java

Click the green ▶ icon next to main

Use the console menu to interact with the program

Testing with Sample Data
This project includes a sample dataset that allows users to test functionality and verify business logic without modifying the source code.

The sample data file is located at:

bash
Copy code
data/sample_sales_data.csv
How to Test
Run the application (Main.java)

Select option 1 to load the sample CSV data

Use the following menu options to test functionality:

2 – View product revenue, cost, and profit summary

3 – Run profit analysis and view total revenue and total profit

4 – View break-even units and break-even revenue

5 – Run scenario analysis (e.g., enter 5 for a +5% price change)

Expected Results
Products with higher margins show higher profitability

Products with higher fixed costs require more units to break even

Increasing prices in scenario analysis increases profit for products with positive unit sales

A 0% price change results in no difference in profit

Sample Data Validation
Using the values in sample_sales_data.csv, results can be manually verified as follows:

Revenue = price × unitsSold

Total cost = (variableCost × unitsSold) + fixedCost

Profit = revenue − total cost

Break-even units = fixedCost ÷ (price − variableCost)

This allows users to confirm calculation accuracy and understand how input data affects outcomes.

Technologies Used
Java

IntelliJ IDEA

CSV file processing

Object-oriented design

Financial and decision analytics

Future Enhancements
Export analysis results to CSV

Additional scenario parameters

Database integration

Data visualization support

```bash
