import java.util.Scanner;

public class WalletUserMenu implements Menu {
    InstaPayManager instaPayManager;
    public WalletUserMenu(InstaPayManager Manager){
        this.instaPayManager=Manager;
    }
    @Override
    public void DisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice , choice2;

        do {
            System.out.println("Wallet User Menu: ");
            System.out.println("1. Transfer money");
            System.out.println("2. Pay Bills");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.close();

            switch (choice) {
                case 1:
                    System.out.println("1. Transfer money to InstaPay Account");
                    System.out.println("2. Transfer money to Mobile Wallet");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            //transfer to Instapay
                            break;
                        case 2:
                            //transfer to mobile wallet
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case 2:
                    // Paybills();
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

    public void transfere(){
        //implementation
    }

    public void Paybills(){
        //implementation
    }

}