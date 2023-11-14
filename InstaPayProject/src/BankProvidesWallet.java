public class BankProvidesWallet extends WalletProvider{
    @Override
    public boolean checkWalletExist() {
        return false;
    }
    @Override
    public boolean checkReceiverExist(String AccNum){
        return false;
    }
}
