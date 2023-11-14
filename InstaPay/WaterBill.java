public class WaterBill extends UtilityBillsPayment{
    private String Address;
    private String type = "WaterBills";

    @Override
    public void PrintInvoice(){
        System.out.println("Water Bill Invoice");        
        System.out.println("Given Address : " + Address);
        System.out.println("Total Consumption (liters): " + SelectedBillsData.GetConsumption() + "Liters");
        System.out.println("Total Cost : " + SelectedBillsData.GetCost());
       }
      
    public void SetAddress(String Address){
        this.Address = Address; 
    }
 
    public String GetAddress(){
         return Address;
    }
 
    @Override
    public BillsData GetBill(String info){
        return SelectedBillsData;
    }

    @Override 
   public Boolean RemoveBill(String info , String BillType){
   for (int i = 0; i < billsData.size(); i++) {
     if (BillType.equals(type)){
     if (info.equals(Address)) {
          billsData.remove(i);
          System.out.println("Bill removed successfully");
          return true; 
          }
     } }
     System.out.println("Selected Bill wasn't found ");
                    return false;
}
}
