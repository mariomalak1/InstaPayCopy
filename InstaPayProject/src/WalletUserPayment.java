public class WalletUserPayment extends Payment {
    private WalletProviderFactory walletProviderFactory  = new WalletProviderFactory();
    private WalletProvider walletProvider;
    private WalletUser walletUser= new WalletUser();


    public WalletUserPayment(WalletUser walletuser){
        this.walletUser = walletuser;
        walletProvider=walletProviderFactory.CreateWalletProvider(this.walletUser.GetWallet().GetWalletProvider().GetWalletProviderType());
    }
    @Override
    public double PayBills(){
        walletProvider.DecrementBalance(ConsumptionCost,walletUser.GetWallet());
        return walletUser.GetWallet().GetBalance();
    }
}
