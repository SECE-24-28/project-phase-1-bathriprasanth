import java.util.*;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Account> accounts = BankStore.loadAccounts();

        while (true) {
            System.out.println("\n Bank Menu ");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Enter User ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Password: ");
                String pass = sc.nextLine();
                System.out.print("Enter Initial Deposit: ");
                double dep = Double.parseDouble(sc.nextLine());

                Account acc = new Account(id, name, pass, dep);
                accounts.add(acc);
                BankStore.saveAccounts(accounts);
                System.out.println("Account created!");

            } else if (choice == 2) {
                System.out.print("Enter User ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                Account acc = findAccount(accounts, id, pass);
                if (acc != null) {
                    acc.displayDetails();
                } else {
                    System.out.println("Account not found.");
                }

            } else if (choice == 3) {
                System.out.print("Enter User ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                Account acc = findAccount(accounts, id, pass);
                if (acc != null) {
                    System.out.print("Enter amount to deposit: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.deposit(amt);
                    BankStore.saveAccounts(accounts);
                } else {
                    System.out.println("Account not found.");
                }

            } else if (choice == 4) {
                System.out.print("Enter User ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                Account acc = findAccount(accounts, id, pass);
                if (acc != null) {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.withdraw(amt);
                    BankStore.saveAccounts(accounts);
                } else {
                    System.out.println("Account not found.");
                }

            } else if (choice == 5) {
                System.out.println("Thank you! Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    private static Account findAccount(List<Account> accounts, int id, String pass) {
        for (Account a : accounts) {
            if (a.getUserId() == id && a.checkPassword(pass)) {
                return a;
            }
        }
        return null;
    }
}
