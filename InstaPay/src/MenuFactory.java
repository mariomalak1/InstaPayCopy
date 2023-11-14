public class MenuFactory {
    public Menu createMenu(String type){
        if (type.equals("BankUser")) {
            return new BankUserMenu();
        } else if (type.equals("WalletUser")){
            return new WalletUserMenu();
        }else
            return null;
    }
}
