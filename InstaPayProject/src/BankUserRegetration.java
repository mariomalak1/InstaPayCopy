public class BankUserRegetration extends RegestrationService {
    private BankApiServices bankApiServices;
    private BankAccount bankAccount;

    @Override
    public User Register(){
        if(bankApiServices.VerifyCustomerData(bankAccount.GetAccNum(), bankAccount.GetMobNum(),bankAccount.GetBankName())){
            return user;
        }
        else{
            return null;
        }
    }
}
