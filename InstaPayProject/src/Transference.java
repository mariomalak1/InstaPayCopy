public abstract class Transference extends InstaPayService{
    protected String ReceiverAccNum;

    protected double ValueTransfered;

    public abstract boolean Transfer();

    public abstract boolean checkReceiverExist(String ReceiverAccNum);

    public boolean CheckEnoughBalance(){
        return true;
    }

    public void SetReceiverAccNum(String ReceiverNum){
        this.ReceiverAccNum = ReceiverNum;
    }

    public void SetValueTransfered(double valueTransfered){
        this.ValueTransfered = valueTransfered;
    }

    public String GetReceiverAccNum(){
        return ReceiverAccNum;
    }

    public double getValueTransfered() {
        return ValueTransfered;
    }
}
