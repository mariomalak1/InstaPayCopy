import java.util.Scanner;

public class BankUserMenu implements Menu {
    InstaPayManager instaPayManager;
    private UtilityBillsPayment Bill;
    private BankUser user;
    private BillsFactory billsFactory = new BillsFactory();
    public BankUserMenu(BankUser user1 , InstaPayManager Manager){
        this.user=user1;
        this.instaPayManager=Manager;
    }
    @Override
    public void DisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Bank User Menu: ");
            System.out.println("1. Transfer money");
            System.out.println("2. Pay Bills");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    // transfere();
                    break;
                case "2":
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
                        System.out.println("Your balance is " + user.GetBankAccount().GetBalance());
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
                            }
                            System.out.println("The bill has been paid , now your balance is " + user.GetBankAccount().GetBalance());
                        }
                    }
                    Bill = null;
                    break;
                case "3":
                    System.out.println("Your balance is : "+user.GetBankAccount().GetBalance()+ " LE");
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

    public void transfere(){
        // implementation
    }

    public void Paybills(){
        
    }


}



