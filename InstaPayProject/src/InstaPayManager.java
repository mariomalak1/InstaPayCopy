import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InstaPayManager {

    public InstaPayManager(){
        this.users = storage.GetUserArray();
        this.billsList = storage.GetBillsList();
    }
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<UtilityBillsPayment> billsList = new ArrayList<>();
    public ArrayList<UtilityBillsPayment> GettBillsArr(){
        return billsList;
    }
    private RegestrationService registration ;
    private Menu menu;
    private MenuFactory menuFactory = new MenuFactory();
    private User loggedInUser;
    private Storage storage= new Storage();
    private RegestrationServiceFactory registerFactory = new RegestrationServiceFactory();

    public Boolean Login(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter User Name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        for(User user : users){
            if (userName.equals(user.GetUserName()) && password.equals(user.GetPassword())) {
                SetLoggedInUser(user);
                return true;
            }
                
        }
        return false;
    };
    public void Start() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        System.out.println("Welcome to InstaPay System ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            if (Login()) {
                System.out.println("Login successful.");
                System.out.println("Welcome " + loggedInUser.GetUserName());
                DisplayMenu();
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }
        }
        else if (choice.equals("2")) {
            while (true) {
                String choice2;
                System.out.println("Select your type: ");
                System.out.println("1. Bank user: ");
                System.out.println("2. wallet user: ");
                choice2 = scanner.nextLine();
                System.out.print("enter name: ");
                String name = scanner.nextLine();
                System.out.print("enter Email: ");
                String Email = scanner.nextLine();
                System.out.print("enter password: ");
                String pass = scanner.nextLine();
                System.out.print("enter phone number: ");
                String phoneNumber = scanner.nextLine();
                
                registration = registerFactory.CreateRegestrationType(choice2);
                
                if(registration!=null){
                    registration.FillData( phoneNumber ,name,pass,Email);
                    if(registration.VerifyData()){
                        if (registration.Register() != null) {
                            users.add(registration.GetUser());
                            storage.UpdateUsersList(users);
                            System.out.println("Successfully registered");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Invalid choice, please choose 1 for bank account user, 2 for wallet user");
                }
            }
        }else{
            return;
        }
    }
            
            
}


    public void SetLoggedInUser(User user) {
        loggedInUser = user;
    }
    
    
    public void SetUserArr(User userArr[]){
        users.addAll(Arrays.asList(userArr));
    };

    public void DisplayMenu(){
        if (loggedInUser != null) {
            Menu userMenu = menuFactory.createMenu(loggedInUser,this);
            userMenu.DisplayMenu();
        } else {
            System.out.println("User not logged in. Please log in or register.");
        }
    }
    public BillsData GetBill(String info , String BillType){
        for (UtilityBillsPayment bill : billsList) {
            if(info.equals(bill.GetInfo()) && BillType.equals(bill.GetType())){
                return bill.GettBillsData();
            }
        }
        System.out.println("There is no "+ BillType+" Bill for " + info);
        return null;
    }
    public void RemoveBill(String info , String BillType){
        for (UtilityBillsPayment bill : billsList) {
            if(info.equals(bill.GetInfo()) && BillType.equals(bill.GetType())){
                billsList.remove(bill);
                storage.UpdateBillsList(billsList);
                break;
            }
        }
    }
}
