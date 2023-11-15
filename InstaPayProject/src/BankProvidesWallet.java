public class BankProvidesWallet extends WalletProvider{
    @Override
    public boolean checkWalletExist(String WalletProviderName, String PhoneNum) {
        System.out.println("The Wallet provider: " + WalletProviderName + " is confirmed that it has a wallet linked with phone number " + PhoneNum);        return true;
    }

    @Override
    public boolean checkReceiverExist(String AccNum){
        return true;
    }
}
