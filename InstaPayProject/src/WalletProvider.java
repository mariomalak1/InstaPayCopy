public abstract class WalletProvider {
    protected String Type;

    String GetWalletProviderType(){
        return Type;
    }

    public void setWalletProviderType(String type){
        Type = type;
    }

    public abstract boolean checkReceiverExist(String AccNum);

    public boolean checkWalletExist(){
        return true;
    }
}
