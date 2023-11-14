import java.util.ArrayList;

public abstract class UtilityBillsPayment {
    protected ArrayList<BillsData> billsData;
    protected BillsData SelectedBillsData; 
    protected User user; // erase later

    public void PrintInvoice(){}

    public abstract BillsData GetBill(String info);

    public abstract Boolean RemoveBill(String info, String type);
}
