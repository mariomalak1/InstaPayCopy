import java.util.ArrayList;

public abstract class Transference extends InstaPayService{
    protected String ReceiverAccNum;

    protected double ValueTransferred;

    public abstract boolean Transfer(String WalletProviderType);

    public abstract User checkReceiverExist(String ReceiverInfo, ArrayList<User> users,String UserType);

    public boolean CheckEnoughBalance(){
        return true;
    }

    public void SetReceiverAccNum(String ReceiverNum){
        this.ReceiverAccNum = ReceiverNum;
    }

    public void setValueTransferred(double valueTransferred){
        this.ValueTransferred = valueTransferred;
    }

    public String GetReceiverAccNum(){
        return ReceiverAccNum;
    }

    public double getValueTransferred() {
        return ValueTransferred;
    }
}
