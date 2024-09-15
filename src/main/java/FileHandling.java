import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class FileHandling {
    // Write data to files
    public void writeData(Display app) {
        try {
            // Salary
            FileWriter writer = new FileWriter("salary.txt");
            double[] salaries = app.getSalary();
            String monthlySalary = String.valueOf(salaries[0]);
            String weeklySalaray = String.valueOf(salaries[1]);
            String yearlySalary = String.valueOf(salaries[2]);
            writer.write(monthlySalary + "\n" + weeklySalaray + "\n" + yearlySalary);
            writer.close();

            // Budget
            FileWriter writer2 = new FileWriter("budget.txt");
            double[] budget = app.getBudget();
            String rent = String.valueOf(budget[0]);
            String food = String.valueOf(budget[1]);
            String utilities = String.valueOf(budget[2]);
            String transportation = String.valueOf(budget[3]);
            String investments = String.valueOf(budget[4]);
            writer2.write(rent + "\n" + food + "\n" + utilities + "\n" + transportation + "\n" + investments);
            writer2.close();

            // Investments
            FileWriter writer3 = new FileWriter("investment.txt");
            double[] investment = app.getInvestment();
            String stocks = String.valueOf(investment[0]);
            String indexFund = String.valueOf(investment[1]);
            writer3.write(stocks + "\n" + indexFund);
            writer3.close();
        } 
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // Display data from files
    public void displayData(Display app) {
        try {
            // Salary
            Scanner reader = new Scanner(new File("salary.txt"));
            app.yearlySalaryField.setText(reader.nextLine());
            app.weeklySalaryField.setText(reader.nextLine());
            app.monthlySalaryField.setText(reader.nextLine());
            reader.close();

            // Budget
            Scanner reader2 = new Scanner(new File("budget.txt"));
            app.rentField.setText(reader2.nextLine());
            app.foodField.setText(reader2.nextLine());
            app.utilitiesField.setText(reader2.nextLine());
            app.transportationField.setText(reader2.nextLine());
            app.investmentsField.setText(reader2.nextLine());
            reader2.close();

            // Investments
            Scanner reader3 = new Scanner(new File("investment.txt"));
            app.stocksField.setText(reader3.nextLine());
            app.indexFundField.setText(reader3.nextLine());
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}