public class BillsFactory {
    public UtilityBillsPayment createBills(String Type){
        if (Type.equals("1")) {
            return new ElectricBills();
        }else if (Type.equals("2")){
            return new WaterBill();
        } else if(Type.equals("3")){
            return new GasBills();
        }else 
        return null;
    }
};
