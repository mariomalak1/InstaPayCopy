import java.util.ArrayList;
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
        System.out.println(bankAccount.GetBalance());
        if(bankApiServices.VerifyCustomerData(bankAccount.GetAccNum(), user.GetPhone(),bankAccount.GetBankName())){
            return user;
        }
        else{
            return null;
        }
    }
    public void FillData(String PhoneNum, String Name, String Pass , String mail){
        double randomValue = 1000 ;
        bankAccount.SetBalance(randomValue);
        user.setEmail(mail);
        user.SetPassword(Pass);
        user.setUserName(Name);
        user.SetPhone(PhoneNum);
    }
}
