public class WalletUser extends User {
    private Wallet wallet;
    public WalletUser(){
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
}
