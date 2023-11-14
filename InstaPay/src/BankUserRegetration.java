import java.util.Random;
import java.util.Scanner;

public class BankUserRegetration extends RegestrationService {
    private BankApiServices bankApiServices = new BankApiServices();
    private BankAccount bankAccount = new BankAccount();
    public BankUserRegetration(){
        SetUser(userfactory.createUser("BankUser"));
    }

    @Override
    public User Register(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter Bank Name: ");
        String bankName = scanner.nextLine();
        System.out.print("enter Account number: ");
        String accNum = scanner.nextLine();
        bankAccount.SetAccNum(accNum);
        bankAccount.SetBankName(bankName);
        if(bankApiServices.VerifyCustomerData(bankAccount.GetAccNum(), bankAccount.GetMobNum(),bankAccount.GetBankName())){
            return user;
        }
        else{
            return null;
        }
    }
    public void FillData(String PhoneNum, String Name, String Pass , String mail){
        bankAccount.SetMobNum(PhoneNum);
        Random random = new Random();
        double randomValue = 1000 + random.nextDouble() * Double.MAX_VALUE;
        bankAccount.SetBalance(randomValue);
        user.setEmail(mail);
        user.SetPassword(Pass);
        user.setUserName(Name);
    }
}
