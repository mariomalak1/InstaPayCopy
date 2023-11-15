import java.util.Scanner;
import java.util.InputMismatchException;

public class BankUserMenu extends Menu {
    private BankUser user;
    protected BankApiServices bankApi = new BankApiServices();
    public BankUserMenu(BankUser user1 , InstaPayManager Manager){
        this.user=user1;
        this.instaPayManager=Manager;
    }
    @Override
    public void DisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice, choice2;

        while (true) {
            System.out.println("Bank User Menu: ");
            System.out.println("1. Transfer money");
            System.out.println("2. Pay Bills");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            if (choice.equals("4")) {
                System.out.println("Exiting Bank User Menu.");
                break;
            }

            switch (choice) {
                case "1":
                    while (true) {
                        System.out.println("Transference Menu");
                        System.out.println("1. To instapay account");
                        System.out.println("2. To Mobile");
                        System.out.println("3. Bank account");
                        System.out.println("4. Exit");
                        choice2 = scanner.nextLine();

                        if (choice2.equals("4")) {
                            break;
                        }

                        switch (choice2) {
                            case "1":
                                transferenceToInstaAccount();
                                break;
                            case "2":
                                transferenceToMobile();
                                break;
                            case "3":
                                transferenceToBank();
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;
                case "2":
                    Paybills();
                    break;
                case "3":
                    System.out.println("Your balance is : " + user.GetBankAccount().GetBalance() + " LE");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void transferenceToBank(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the user's bank account number");
        String ReciverInfo = scanner.nextLine();
        transference = new BankAccountTransference();
        BankUser Reciver = (BankUser) transference.checkReceiverExist(ReciverInfo,instaPayManager.getUsers() , user.GetType());
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
            double OldBalance = user.GetBankAccount().GetBalance();
            System.out.println("Your balance is " + user.GetBankAccount().GetBalance() + " LE");
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
                bankApi.DecrementBalance(amount,user.GetBankAccount());
                bankApi.IncrementBalance(amount,Reciver.GetBankAccount());
                System.out.println("Transaction is Done successfully" + user.GetBankAccount().GetBalance());

            }
            else
                return;
        }
        else{
            System.out.println("This user is not exist");
        }

    }
    public void transferenceToMobile(){
        WalletUser walletUser = new WalletUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the user's phone number ");
        String ReciverInfo = scanner.nextLine();
        transference = new MobileTransference();
        WalletUser Reciver = (WalletUser) transference.checkReceiverExist(ReciverInfo,instaPayManager.getUsers() , user.GetType());
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
            double OldBalance = user.GetBankAccount().GetBalance();
            System.out.println("Your balance is " + user.GetBankAccount().GetBalance() + " LE");
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
                bankApi.DecrementBalance(amount,user.GetBankAccount());
                Reciver.GetWallet().GetWalletProvider().IncrementBalance(amount,Reciver.GetWallet());
                System.out.println("Transaction is Done successfully , and balance now equals to:" + user.GetBankAccount().GetBalance() + " LE");
                instaPayManager.
            }
            else
                return;
        }
        else{
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
            double OldBalance = user.GetBankAccount().GetBalance();
            System.out.println("Your balance is " + user.GetBankAccount().GetBalance() + " LE");
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
                bankApi.DecrementBalance(amount,user.GetBankAccount());
                if(Reciver.GetType().equals("BankUser")){
                    BankUser newReciver = (BankUser) Reciver;
                    bankApi.IncrementBalance(amount,newReciver.GetBankAccount());
                }
                else{
                    WalletUser walletUser= (WalletUser) Reciver;
                    walletUser.GetWallet().GetWalletProvider().IncrementBalance(amount,walletUser.GetWallet());
                }
                System.out.println("Transaction is Done successfully , and balance now equals to:" + user.GetBankAccount().GetBalance() + " LE");

            }
            else
                return;
        }
        else{
            System.out.println("This user is not exist");
        }

    }
    public void Paybills(){
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
        double OldBalance = user.GetBankAccount().GetBalance();
        if(Bill.GettBillsData()!=null){
            Bill.SetInfo(BillInformation);
            Bill.PrintInvoice();
            System.out.println("Your balance is " + user.GetBankAccount().GetBalance() + " LE");
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
                Bill.payment = new BankUserPayment(user);
                Bill.payment.SetCost(Bill.GettBillsData().GetCost());
                user.GetBankAccount().SetBalance(Bill.payment.PayBills());
                if(OldBalance>user.GetBankAccount().GetBalance()){ // delete it if balance is decrmented
                    instaPayManager.RemoveBill(BillInformation,Bill.GetType());
                    System.out.println("The bill has been paid , now your balance is " + user.GetBankAccount().GetBalance());
                }
            }
        }
    }
}



