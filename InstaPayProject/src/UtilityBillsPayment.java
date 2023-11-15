import java.util.ArrayList;

public abstract class UtilityBillsPayment extends InstaPayService {
    protected String info;
    protected String Type;
    protected ArrayList<BillsData> billsData;
    protected BillsData SelectedBillsData;
    protected User user; // erase later
    protected Payment payment;
    public ArrayList<BillsData> GetBills(){
        return billsData;
    }

    public void PrintInvoice(){}

    public void SetBellsData(BillsData bills){
        this.SelectedBillsData = bills;
    }

    public BillsData GettBillsData(){
        return SelectedBillsData;
    }

    public String GetInfo(){
        return  info;
    }
    public String GetType(){
        return  Type;
    }

    public abstract void SetInfo(String info);

    ;
}
