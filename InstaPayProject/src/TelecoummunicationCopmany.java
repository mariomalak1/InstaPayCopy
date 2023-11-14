public class TelecoummunicationCopmany extends WalletProvider{
    @Override
    public boolean checkWalletExist() {
        return true;
    }
    @Override
    public boolean checkReceiverExist(String AccNum){
        return false;
    }
}
