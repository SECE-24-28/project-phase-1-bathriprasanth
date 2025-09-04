import java.io.*;
import java.util.*;

public class BankStore {
    private static final String FILE_NAME = "accounts.txt";

    // Load accounts from file
    public static List<Account> loadAccounts() {
        List<Account> accounts = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return accounts; // if no file yet, return empty list
        }

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    accounts.add(Account.fromFileString(line));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading accounts.");
        }
        return accounts;
    }

    // Save accounts to file
    public static void saveAccounts(List<Account> accounts) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Account a : accounts) {
                pw.println(a.toFileString());
            }
        } catch (Exception e) {
            System.out.println("Error saving accounts.");
        }
    }
}
