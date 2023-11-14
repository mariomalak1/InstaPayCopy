public class InstaPayTransference extends Transference{

    @Override
    public boolean Transfer(String WalletProviderType) {
        return false;
    }

    @Override
    public boolean checkReceiverExist(String ReceiverAccNum) {
        return false;
    }
}
