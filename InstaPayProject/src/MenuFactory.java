import java.util.ArrayList;

public class MenuFactory {
    public Menu createMenu(User user , InstaPayManager manager){
        if (user.GetType().equals("BankUser")) {
            BankUser bankUser = (BankUser) user;;
            return new BankUserMenu(bankUser,manager);
        } else if (user.GetType().equals("WalletUser")){
            WalletUser walletUser = (WalletUser) user;
            return new WalletUserMenu(walletUser,manager);
        }else
            return null;
    }
}
