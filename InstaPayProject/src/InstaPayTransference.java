public class InstaPayTransference extends Transference{

    @Override
    public boolean Transfer() {
        return false;
    }

    @Override
    public boolean checkReceiverExist(String ReceiverAccNum) {
        return false;
    }
}
