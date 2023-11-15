public class WalletProviderFactory {

    public WalletProvider CreateWalletProvider(String type){
        if (type.equalsIgnoreCase("1")){
            return new BankProvidesWallet();
        }
        else if (type.equalsIgnoreCase("2")){
            return new TelecoummunicationCopmany();
        }
        else if (type.equalsIgnoreCase("3")){
            return new ElectronicPayment();
        }
        return null;
    }

}
