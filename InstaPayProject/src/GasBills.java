public class GasBills extends UtilityBillsPayment{
    public GasBills(){
        System.out.println("Enter your address");
        Type = "GasBills";
    }
    public GasBills (String address , BillsData billsData){
        this.info = address;
        this.SetBellsData(billsData);
        Type = "GasBills";
    }
    @Override
    public void PrintInvoice(){
        System.out.println("Gas Bill Invoice");        
        System.out.println("Given Address : " + info);
        System.out.println("Total Consumption (liters): " + SelectedBillsData.GetConsumption() + " Liters");
        System.out.println("Total Cost : " + SelectedBillsData.GetCost());
       }
   @Override
   public void SetInfo(String Address){
        this.info = Address;
    }
 
    public String GetAddress(){
         return info;
    }

}
