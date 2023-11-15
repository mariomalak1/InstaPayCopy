import java.util.Random;
import java.util.Scanner;

public class WalletUserRegestration extends RegestrationService {
    Wallet wallet = new Wallet();
    WalletProvider walletProvider;
    WalletProviderFactory walletFactory = new WalletProviderFactory();
    public WalletUserRegestration(){
        SetUser(userfactory.createUser("WalletUser"));
    }
    @Override 
    public User Register() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("choose your wallet provider");
            System.out.println("1-Bank Provides Wallets");
            System.out.println("2-telecommunication companies wallet");
            System.out.println("3-electronic payment companies wallet");
            String choice = scanner.nextLine();
            walletProvider= walletFactory.CreateWalletProvider(choice);
            if(walletProvider!=null)
                break;
            else{
                System.out.println("Invalid input");
            }
        }
        System.out.println("enter Wallet Provider Name: ");
        String WalletProviderName = scanner.nextLine();
        if(!walletProvider.checkWalletExist(WalletProviderName,this.user.GetPhone() , this.user.GetType()))
            return null;
        else{
            wallet.AddWalletProvider(walletProvider);
            return user;
        }
    }
        public void FillData(String PhoneNum, String Name, String Pass , String mail){
            Random random = new Random();
            wallet.SetBalance(1000);
            user.setEmail(mail);
            user.SetPassword(Pass);
            user.setUserName(Name);
            user.SetPhone(PhoneNum);
        }
}
