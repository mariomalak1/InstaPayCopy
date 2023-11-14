import java.util.Scanner;

public class BankUserMenu implements Menu {
    @Override
    public void DisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Bank User Menu: ");
            System.out.println("1. Transfer money");
            System.out.println("2. Pay Bills");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Exiting Bank User Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 3);
    }
}

