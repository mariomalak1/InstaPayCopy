public class ElectricBills extends UtilityBillsPayment{

    public ElectricBills (String Device , BillsData billsData){
        this.info = Device;
        this.SetBellsData(billsData);
        Type = "ElectricBills";
        System.out.println("Enter your device number");
    }
    public ElectricBills(){
        Type = "ElectricBills";
        System.out.println("Enter your electric device number");
    }
    @Override
    public void PrintInvoice() {
        if (SelectedBillsData != null) {
            System.out.println("Electric Bill Invoice");
            System.out.println("Bill number : ");
            System.out.println("Device Number : " + info);
            System.out.println("Total Consumption (watt): " + SelectedBillsData.GetConsumption() + " Watt");
            System.out.println("Total Cost : " + SelectedBillsData.GetCost());
        } else {
            System.out.println("No bill data available.");
        }
    }

    @Override
    public void SetInfo(String DeviceNum){
        this.info = DeviceNum;
    }

   public String GetDeviceNumber(){
        return info;
   }


}
