package internship;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ATM {
    private double balance;
    private BufferedReader reader;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) throws IOException {
        switch (option) {
            case 1:
                System.out.println("Your current balance: $" + balance);
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = getValidAmountInput();
                deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = getValidAmountInput();
                withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private double getValidAmountInput() throws IOException {
        while (true) {
            try {
                String input = reader.readLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Your new balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public static void main(String[] args) throws IOException {
        //we are creating instance for initial balance
        ATM atm = new ATM(1000.0);

        while (true) {
            atm.displayMenu();
            // we are displaying here  the menu of bank.
            System.out.print("Choose an option (1-4): ");
            int option = Integer.parseInt(atm.reader.readLine());

            atm.executeOption(option);
        }
    }
}
