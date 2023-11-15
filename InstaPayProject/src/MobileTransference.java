import java.util.ArrayList;

public class MobileTransference extends Transference{
    WalletProviderFactory walletProviderFactory;
    @Override
    public boolean Transfer(String WalletProviderType) {
        return false;
    }

    @Override
    public User checkReceiverExist(String PhoneNum, ArrayList<User> users , String UserType) {
        for (User UserIteration : users){
            WalletUser walletUser;
            if(UserIteration.GetType().equals("WalletUser")){
                walletUser = (WalletUser) UserIteration;
                if(UserIteration.GetPhone().equals(PhoneNum)){
                    return walletUser;
                }
            }

        }
        return null;
    }
}
