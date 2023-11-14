public class MobileTransference extends Transference{
    WalletProviderFactory walletProviderFactory;
    @Override
    public boolean Transfer(String WalletProviderType) {
        String receiverAccNum = GetReceiverAccNum();
        if(checkReceiverExist(receiverAccNum)){
            WalletProvider walletProvider = WalletProviderFactory.CreateWalletProvider(WalletProviderType);
            return walletProvider.checkReceiverExist(receiverAccNum);
        }
        return false;
    }

    @Override
    public boolean checkReceiverExist(String ReceiverAccNum) {
        return false;
    }
}
