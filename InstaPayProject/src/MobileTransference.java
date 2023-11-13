public class MobileTransference extends Transference{
    WalletProviderFactory walletProviderFactory;
    @Override
    public boolean Transfer() {
        return false;
    }

    @Override
    public boolean checkReceiverExist(String ReceiverAccNum) {
        return false;
    }
}
