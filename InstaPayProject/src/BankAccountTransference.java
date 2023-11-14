public class BankAccountTransference extends Transference{
    private String BankName;

    public BankAccountTransference(String bankName){
        this.BankName = bankName;
    }

    @Override
    public boolean Transfer(String WalletProviderType) {
        return true;
    }

    @Override
    public boolean checkReceiverExist(String ReceiverAccNum) {
        return false;
    }
}
