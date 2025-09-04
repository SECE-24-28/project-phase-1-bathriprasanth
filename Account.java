public class Account extends User {
    private double balance;

    public Account(int userId, String userName, String password, double initialDeposit) {
        super(userId, userName, password);
        this.balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance - amount >= 2000) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Cannot withdraw. Minimum balance of 2000 required.");
        }
    }

    // Overridden 
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Balance: " + balance);
    }

    // Convert account to simple text format for saving
    public String toFileString() {
        return getUserId() + "," + getUserName() + "," + getPassword() + "," + balance;
    }

    // Create account from saved file line
    public static Account fromFileString(String line) {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String pass = data[2];
        double bal = Double.parseDouble(data[3]);
        return new Account(id, name, pass, bal);
    }
}
