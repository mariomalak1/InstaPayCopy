public class ElectricBills extends UtilityBillsPayment{
    private String DeviceNumber;
    private String type = "ElectricBills";
    
    @Override
    public void PrintInvoice() {
        if (SelectedBillsData != null) {
            System.out.println("Electric Bill Invoice");
            System.out.println("Bill number : ");
            System.out.println("Device Number : " + DeviceNumber);
            System.out.println("Total Consumption (watt): " + SelectedBillsData.GetConsumption() + " Watt");
            System.out.println("Total Cost : " + SelectedBillsData.GetCost());
        } else {
            System.out.println("No bill data available.");
        }
    }

   public void SetDeviceNumber(String DeviceNumber){
       this.DeviceNumber = DeviceNumber; 
   }

   public String GetDeviceNumber(){
        return DeviceNumber;
   }

   @Override
   public BillsData GetBill(String info){
     return SelectedBillsData;
   }
  
   @Override 
   public Boolean RemoveBill(String info , String BillType){
   for (int i = 0; i < billsData.size(); i++) {
     if (BillType.equals(type)){
     if (info.equals(DeviceNumber)) {
          billsData.remove(i);
          System.out.println("Bill removed successfully");
          return true; 
          }
     } }
     System.out.println("Selected Bill wasn't found ");
                    return false;
}
}
