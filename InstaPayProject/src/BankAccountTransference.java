public class BankAccountTransference extends Transference{
    private String BankName;

    @Override
    public boolean Transfer() {
        return false;
    }

    @Override
    public boolean checkReceiverExist(String ReceiverAccNum) {
        return false;
    }
}
