
public class WalletProviderFactory {

    public WalletProvider CreateWalletProvider(String type){
        if (type.equalsIgnoreCase("1") ||type.equals("Bank")){
            return new BankProvidesWallet();
        }
        else if (type.equalsIgnoreCase("2") || type.equals("Telecommunication")){
            return new TelecoummunicationCopmany();
        }
        else if (type.equalsIgnoreCase("3")|| type.equals("ElectronicPayment")){
            return new ElectronicPayment();
        }
        return null;
    }

}
