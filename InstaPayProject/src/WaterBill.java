public class WaterBill extends UtilityBillsPayment{
    public WaterBill(){
        System.out.println("Enter your address");
        Type = "WaterBills";
    }
    public WaterBill (String address , BillsData billsData){
        this.info = address;
        this.SetBellsData(billsData);
        Type = "WaterBills";
    }
    @Override
    public void PrintInvoice(){
        System.out.println("Water Bill Invoice");        
        System.out.println("Given Address : " + info);
        System.out.println("Total Consumption (liters): " + SelectedBillsData.GetConsumption() + " Liters");
        System.out.println("Total Cost : " + SelectedBillsData.GetCost());
       }
   @Override
    public void SetInfo(String Address){
        this.info= Address;
    }
 
    public String GetAddress(){
         return info;
    }

}
