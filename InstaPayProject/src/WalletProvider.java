public abstract class WalletProvider {
    protected String Type;

    String GetWalletProviderType(){
        return Type;
    }
    public abstract boolean checkReceiverExist(String AccNum);

    public abstract boolean checkWalletExist(String WalletProvoderName , String PhoneNum , String UserType);
    public abstract void IncrementBalance(double Amount , Wallet wallet);
    public abstract void SetType();
    public abstract void DecrementBalance(double Amount , Wallet wallet);
}
