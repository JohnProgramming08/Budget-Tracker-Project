import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Display extends JFrame {
    // Create class attributes 
    JPanel budgetPanel;
    JPanel salaryPanel;
    JPanel investmentsPanel;
    JPanel linksPanel;
    JTextField yearlySalaryField;
    JTextField weeklySalaryField;
    JTextField monthlySalaryField;
    JTextField rentField;
    JTextField foodField;
    JTextField utilitiesField;
    JTextField transportationField;
    JTextField investmentsField;
    JTextField stocksField;
    JTextField indexFundField;

    // Constructor
    public Display() {
        super("Budget Tracker");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        createPanels();
        createWidgets();
        FileHandling fileHandling = new FileHandling();
        fileHandling.displayData(this);

        setVisible(true);
    }

    // Create all panels needed for GUI
    void createPanels() {
        budgetPanel = new JPanel();
        budgetPanel.setBorder(BorderFactory.createTitledBorder("BUDGET"));
        budgetPanel.setLayout(new GridLayout(5, 2));

        salaryPanel = new JPanel();
        salaryPanel.setBorder(BorderFactory.createTitledBorder("SALARY"));
        salaryPanel.setLayout(new GridLayout(3, 2));

        investmentsPanel = new JPanel();
        investmentsPanel.setBorder(BorderFactory.createTitledBorder("INVESTMENTS"));
        investmentsPanel.setLayout(new GridLayout(2, 2));

        linksPanel = new JPanel();
        linksPanel.setBorder(BorderFactory.createTitledBorder("USEFUL LINKS"));
        linksPanel.setLayout(new GridLayout(2, 2));

        add(budgetPanel, BorderLayout.CENTER);
        add(salaryPanel, BorderLayout.WEST);
        add(investmentsPanel, BorderLayout.NORTH);
        add(linksPanel, BorderLayout.SOUTH);
    }

    // Create all components needed for GUI
    void createWidgets() {
        // Salary Panel
        JLabel monthlySalary = new JLabel("Monthly Salary: ");
        monthlySalaryField = new JTextField(10);
        JLabel yearlySalary = new JLabel("Yearly Salary: ");
        yearlySalaryField = new JTextField(10);
        JLabel weeklySalary = new JLabel("Weekly Salary: ");
        weeklySalaryField = new JTextField(10);

        salaryPanel.add(monthlySalary);
        salaryPanel.add(monthlySalaryField);
        salaryPanel.add(yearlySalary);
        salaryPanel.add(yearlySalaryField);
        salaryPanel.add(weeklySalary);
        salaryPanel.add(weeklySalaryField);

        // Budget Panel
        JLabel rent = new JLabel("Rent: ");
        rentField = new JTextField(10);
        JLabel food = new JLabel("Food: ");
        foodField = new JTextField(10);
        JLabel utilities = new JLabel("Utilities: ");
        utilitiesField = new JTextField(10);
        JLabel transportation = new JLabel("Transportation: ");
        transportationField = new JTextField(10);
        JLabel investments = new JLabel("Investments: ");
        investmentsField = new JTextField(10);

        budgetPanel.add(rent);
        budgetPanel.add(rentField);
        budgetPanel.add(food);
        budgetPanel.add(foodField);
        budgetPanel.add(utilities);
        budgetPanel.add(utilitiesField);
        budgetPanel.add(transportation);
        budgetPanel.add(transportationField);
        budgetPanel.add(investments);
        budgetPanel.add(investmentsField);

        // Investments Panel
        JLabel stocks = new JLabel("Stocks: ");
        stocksField = new JTextField(10);
        JLabel indexFund = new JLabel("Index Fund: ");
        indexFundField = new JTextField(10);

        investmentsPanel.add(stocks);
        investmentsPanel.add(stocksField);
        investmentsPanel.add(indexFund);
        investmentsPanel.add(indexFundField);

        // Links Panel
        JLabel link1 = new JLabel("nationaldebtline.org");
        JLabel link2 = new JLabel("evelyn.com");
        JButton saveButton = new JButton("SAVE");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save data to files
                FileHandling fileHandler = new FileHandling();
                fileHandler.writeData(Display.this);
            }
        });
        
        linksPanel.add(link1);
        linksPanel.add(saveButton);
        linksPanel.add(link2);  
    }

    public double[] getSalary() {
        double yearlySalary = Double.parseDouble(yearlySalaryField.getText());
        double weeklySalary = yearlySalary / 52;
        double monthlySalary = weeklySalary * 4;
        double[] salaries = {monthlySalary, weeklySalary, yearlySalary};
        return salaries;
    }
    
    public double[] getBudget() {
        double rent = Double.parseDouble(rentField.getText());
        double food = Double.parseDouble(foodField.getText());
        double utilities = Double.parseDouble(utilitiesField.getText());
        double transportation = Double.parseDouble(transportationField.getText());
        double investments = Double.parseDouble(investmentsField.getText());
        double[] budget = {rent, food, utilities, transportation, investments};
        return budget;
    }

    public double[] getInvestment() {
        double stocks = Double.parseDouble(stocksField.getText());
        double indexFund = Double.parseDouble(indexFundField.getText());
        double[] investment = {stocks, indexFund};
        return investment;
    }
}