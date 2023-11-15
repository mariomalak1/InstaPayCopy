import java.util.InputMismatchException;
import java.util.Scanner;

public class WalletUserMenu extends Menu {
    private WalletUser user;

    public WalletUserMenu(WalletUser user1 , InstaPayManager Manager){
        this.user=user1;
        this.instaPayManager=Manager;
    }
    @Override
    public void DisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice , choice2;

        do {
            System.out.println("Wallet User Menu: ");
            System.out.println("1. Transfer money");
            System.out.println("2. Pay Bills");
            System.out.println("3. Get balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("1. Transfer money to InstaPay Account");
                    System.out.println("2. Transfer money to Mobile Wallet");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    choice2 = scanner.nextLine();
                    switch (choice2) {
                        case "1":
                            transferenceToInstaAccount();
                            break;
                        case "2":
                            transferenceToMobile();
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case "2":
                    PayBills();
                    Bill = null;
                    break;
                case "3":
                    System.out.println("Your balance is " + user.GetWallet().GetBalance()+ " LE");
                    break;
                case "4":
                    System.out.println("Exiting Bank User Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (!choice.equals("4"));
    }
    public void PayBills(){
        Scanner scanner = new Scanner(System.in);
        String BillTypeChoice;
        System.out.println("Bills Type: ");
        System.out.println("1. Electric Bills");
        System.out.println("2. Water Bills");
        System.out.println("3. Gaz Bills");
        BillTypeChoice = scanner.nextLine();
        Bill = billsFactory.createBills(BillTypeChoice);
        Bill.SetUser(user);
        String BillInformation = scanner.nextLine();
        Bill.SetBellsData(instaPayManager.GetBill(BillInformation,Bill.GetType()));
        double OldBalance = user.GetWallet().GetBalance();
        if(Bill.GettBillsData()!=null){
            Bill.SetInfo(BillInformation);
            Bill.PrintInvoice();
            System.out.println("Your balance is " + user.GetWallet().GetBalance());
            System.out.println("1-Confirm Payment");
            System.out.println("2-Exit");
            String Confirmation = scanner.nextLine();
            while (!Confirmation.equals("1") && !Confirmation.equals("2")){
                System.out.println("Invalid input");
                System.out.println("1-Confirm Payment");
                System.out.println("2-Exit");
                Confirmation = scanner.nextLine();
            }
            if(Confirmation.equals("1")){
                Bill.payment = new WalletUserPayment(user);
                Bill.payment.SetCost(Bill.GettBillsData().GetCost());
                user.GetWallet().SetBalance(Bill.payment.PayBills());
                if(OldBalance>user.GetWallet().GetBalance()){ // delete it if balance is decrmented
                    instaPayManager.RemoveBill(BillInformation,Bill.GetType());
                    System.out.println("The bill has been paid , now your balance is " + user.GetWallet().GetBalance());
                }
            }
        }
}
    public void transferenceToMobile() {
        WalletUser walletUser = new WalletUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the user's phone number ");
        String ReciverInfo = scanner.nextLine();
        transference = new MobileTransference();
        WalletUser Reciver = (WalletUser) transference.checkReceiverExist(ReciverInfo, instaPayManager.getUsers(), user.GetType());
        if (Reciver != null) {
            double amount = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter the amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    validInput = true; // If the input is successfully parsed, exit the loop
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
            }
            double OldBalance = user.GetWallet().GetBalance();
            System.out.println("Your balance is " + user.GetWallet().GetBalance() + " LE");
            if (amount > user.GetBalance()) {
                System.out.println("Your account balance is insufficient for the requested transfer. The transaction has been terminated.");
                return;
            }
            System.out.println("1-Confirm Payment");
            System.out.println("2-Exit");
            String Confirmation = scanner.nextLine();
            while (!Confirmation.equals("1") && !Confirmation.equals("2")) {
                System.out.println("Invalid input");
                System.out.println("1-Confirm Payment");
                System.out.println("2-Exit");
                Confirmation = scanner.nextLine();
            }
            if (Confirmation.equals("1")) {
                user.GetWallet().GetWalletProvider().DecrementBalance(amount, user.GetWallet());
                Reciver.GetWallet().GetWalletProvider().IncrementBalance(amount, Reciver.GetWallet());
                System.out.println("Transaction is Done successfully , and balance now:" + user.GetBalance() + " LE");

            } else
                return;
        } else {
            System.out.println("This user is not exist");
        }
    }
    public void transferenceToInstaAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the user's Email");
        String ReciverInfo = scanner.nextLine();
        transference = new InstaPayTransference();
        User Reciver = transference.checkReceiverExist(ReciverInfo,instaPayManager.getUsers() , user.GetType());
        if(Reciver!=null){
            double amount = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter the amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    validInput = true; // If the input is successfully parsed, exit the loop
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
            }
            double OldBalance = user.GetWallet().GetBalance();
            System.out.println("Your balance is " + user.GetWallet().GetBalance() + " LE");
            if(amount>user.GetBalance()){
                System.out.println("Your account balance is insufficient for the requested transfer. The transaction has been terminated.");
                return;
            }
            System.out.println("1-Confirm Payment");
            System.out.println("2-Exit");
            String Confirmation = scanner.nextLine();
            while (!Confirmation.equals("1") && !Confirmation.equals("2")){
                System.out.println("Invalid input");
                System.out.println("1-Confirm Payment");
                System.out.println("2-Exit");
                Confirmation = scanner.nextLine();
            }
            if(Confirmation.equals("1")){
                user.GetWallet().GetWalletProvider().DecrementBalance(amount,user.GetWallet());
                if(Reciver.GetType().equals("BankUser")){
                    BankUser newReciver = (BankUser) Reciver;
                    BankApiServices bankApi = new BankApiServices();
                    bankApi.IncrementBalance(amount,newReciver.GetBankAccount());
                }
                else{
                    WalletUser walletUser= (WalletUser) Reciver;
                    walletUser.GetWallet().GetWalletProvider().IncrementBalance(amount,walletUser.GetWallet());
                }
                System.out.println("Transaction is Done successfully , and balance now equals to:" + user.GetWallet().GetBalance() + " LE");

            }
            else
                return;
        }
        else{
            System.out.println("This user is not exist");
        }

    }
}