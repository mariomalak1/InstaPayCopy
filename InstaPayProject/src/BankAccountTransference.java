import java.util.ArrayList;

public class BankAccountTransference extends Transference{
    @Override
    public boolean Transfer(String WalletProviderType) {
        return true;
    }

    @Override
    public User checkReceiverExist(String ReceiverAccNum, ArrayList<User> users , String UserType) {
        BankUser bankUser;
        for (User bankUserIteration : users){
            if(bankUserIteration.GetType().equals("BankUser")){

                bankUser = (BankUser) bankUserIteration;
                if(ReceiverAccNum.equals(bankUser.GetBankAccount().GetAccNum())){
                    return  bankUser;
                }
            }
        }
        return null;
    }
}
