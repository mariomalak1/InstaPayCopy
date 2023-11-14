import java.util.Random;
import java.util.Scanner;

public class WalletUserRegestration extends RegestrationService {
    Wallet wallet = new Wallet();
    public WalletUserRegestration(){
        SetUser(userfactory.createUser("WalletUser"));
    }
    @Override 
    public User Register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter Mobile number: ");
        String mobNumber = scanner.nextLine();
        wallet.SetMobNum(mobNumber);
        System.out.print("Wallet Provider Name");
        String WalletProvider = scanner.nextLine();
        return null;
    }
        public void FillData(String PhoneNum, String Name, String Pass , String mail){
            wallet.SetMobNum(PhoneNum);
            Random random = new Random();
            double randomValue = 1000 + random.nextDouble() * Double.MAX_VALUE;
            wallet.SetBalance(randomValue);
            user.setEmail(mail);
            user.SetPassword(Pass);
            user.setUserName(Name);
        }
}
