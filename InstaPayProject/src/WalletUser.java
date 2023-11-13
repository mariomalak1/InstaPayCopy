public class WalletUser extends User {
    private Wallet wallet;
    public void SetWallet(Wallet wallet){
        this.wallet = wallet;
    }
    public Wallet GetWallet(){
        return this.wallet;
    }
}
