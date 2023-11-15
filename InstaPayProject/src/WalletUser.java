public class WalletUser extends User {
    private Wallet wallet = new Wallet();
    public WalletUser(){
        SetType();
    }
    public WalletUser(String username,String pass,String mail,String phone,double balance,WalletProvider walletProvider){
        super(username , pass,mail,phone);
        this.wallet.SetBalance(balance);
        this.wallet.AddWalletProvider(walletProvider);
        SetType();
    }
    public void SetWallet(Wallet wallet){
        this.wallet = wallet;
    }
    public Wallet GetWallet(){
        return this.wallet;
    }
    @Override
    public void SetType(){
        this.Type = "WalletUser";
    }
    @Override
    public double GetBalance() {
        return wallet.GetBalance();
    }
}
