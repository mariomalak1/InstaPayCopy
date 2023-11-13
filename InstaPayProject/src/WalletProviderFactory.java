public abstract class WalletProviderFactory {
    WalletProvider CreateWalletProvider(String type){
        if (type.equalsIgnoreCase("Bank")){
            return new BankProvidesWallet();
        }
        return null;
    }
}
