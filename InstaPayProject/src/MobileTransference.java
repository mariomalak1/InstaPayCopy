public class MobileTransference extends Transference{
    WalletProviderFactory walletProviderFactory;
    @Override
    public boolean Transfer(String WalletProviderType) {
        return false;
    }

    @Override
    public boolean checkReceiverExist(String ReceiverAccNum) {
        return false;
    }
}
