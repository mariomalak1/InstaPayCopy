public abstract class WalletProvider {
    protected String Type;

    String GetWalletProviderType(){
        return Type;
    }

    public void setWalletProviderType(String type){
        Type = type;
    }

    public abstract boolean checkWalletExist();
    public abstract boolean checkReceiverExist(String AccNum);
}
