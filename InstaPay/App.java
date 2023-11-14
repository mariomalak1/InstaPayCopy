public class App {
    public static void main(String[] args) {
        // Test InstaPay Manager with Dummy Data
        InstaPayManager instaPayManager = new InstaPayManager();
        
        // Dummy Bank User
        BankUser bankUser = new BankUser();
        BankAccount bankAccount = new BankAccount();
        bankAccount.SetAccNum("123456");
        bankAccount.SetMobNum("9876543210");
        bankUser.SetBankAccount(bankAccount);
        // Set the logged-in user in InstaPayManager
        instaPayManager.SetLoggedInUser(bankUser);

        // Call the Start method to simulate user interaction
        instaPayManager.Start();
    }
}
