public abstract class WalletProviderFactory {
    WalletProvider CreateWalletProvider(String type){
        return new BankProvidesWallet();
    }
}
