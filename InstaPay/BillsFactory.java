public class BillsFactory {
    public UtilityBillsPayment createBills(String Type){
        if (Type.equals("ElectricBills")) {
            return new ElectricBills();
        }else if (Type.equals("WaterBills")){
            return new WaterBill();
        } else if(Type.equals("GasBills")){
            return new GasBills();
        }else 
        return null;
    }
};
