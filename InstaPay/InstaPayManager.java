import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InstaPayManager {
    
    // private services instaPayServies;
    private ArrayList<User> users = new ArrayList<>();
    private RegestrationService registration ;
    private Menu menu;
    private MenuFactory menuFactory;
    private User loggedInUser;
    private Storage storage;
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


    public User isLoggedIn(){
        return loggedInUser;
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
                registration = registerFactory.CreateRegestrationType(choice);
                if(registration!=null){
                    registration.FillData( phoneNumber ,name,pass,Email);
                    if (registration.Register() != null) {
                        users.add(registration.GetUser());
                        break;
                    } 
                }
                else{
                    System.out.println("Invalid choice, please choose 1 for bank account user, 2 for wallet user");
                }
            }

            

        }
    }
            
            
}


    public void SetLoggedInUser(User user) {
        loggedInUser = user;
    }
    
    
    public void SetUserArr(User userArr[]){
        users.addAll(Arrays.asList(userArr));
    };

    public void AddUserToDataBase(User user){
        users.add(user);
    };

    public void DisplayMenu(){
        if (loggedInUser != null) {
            System.out.println(loggedInUser.GetUserName());
            System.out.println(loggedInUser.GetEmail());
            System.out.println(loggedInUser.GetType());
            System.out.println(loggedInUser.GetPhone());
            Menu userMenu = menuFactory.createMenu(loggedInUser.GetType());
            userMenu.DisplayMenu();
        } else {
            System.out.println("User not logged in. Please log in or register.");
        }
    }
}
