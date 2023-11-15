import java.util.ArrayList;

public class Storage {
    private BillsFactory billFactory;
    public Storage(){
        FillArraysWithDummyData();
    }
    private ArrayList<UtilityBillsPayment> billsList = new ArrayList<>();
    private UserFactory userFactory;
    private ArrayList<User> Users = new ArrayList<>();

    public void FillArraysWithDummyData(){
        BankUser bankUser = new BankUser("asememad","asemEmad?47","asememaasdd984@gmail.com","01115908715",1000.50,"cib","20210191");
        Users.add(bankUser);
        BankUser bankUser2 = new BankUser("ahmedemad","asemEmad?47","asemasemad984@gmail.com","01115908693",500.50,"ahly","240210191");
        Users.add(bankUser2);
        BankUser bankUser3 = new BankUser("shehabemad","asemEmad?47","asememaasdd984@gmail.com","011159088641",700.50,"cib","20210191");
        Users.add(bankUser3);

        TelecoummunicationCopmany vodafone = new TelecoummunicationCopmany();
        WalletUser walletUser = new WalletUser("asoomOmda" , "asemEmad?47","asememad47@yahoo.com","01112402575",1500,vodafone);
        Users.add(walletUser);

        ElectronicPayment Fawry = new ElectronicPayment();
        WalletUser walletUser2 = new WalletUser("asoomOmda2" , "asemEmad?47","asememad490@yahoo.com","01112391066",1500,Fawry);
        Users.add(walletUser2);

        BankProvidesWallet Cip = new BankProvidesWallet();
        WalletUser walletUser3 = new WalletUser("asoomOmda3" , "asemEmad?47","asememad417@yahoo.com","01116502575",1500,Cip);
        Users.add(walletUser3);

        BillsData billsData = new BillsData("20",100,"9582","WaterBills");
        WaterBill waterBill = new WaterBill("15mayCity",billsData);
        billsList.add(waterBill);

        BillsData billsData2 = new BillsData("20",200,"95082","GasBills");
        ElectricBills electricBills = new ElectricBills("987111105",billsData2);
        billsList.add(electricBills);

        BillsData billsData3 = new BillsData("20",300,"95082","ElectricBills");
        GasBills gazBill= new GasBills("Helwan",billsData3);
        billsList.add(gazBill);
    }
    public void UpdateUsersList(ArrayList<User>newUser) {
        Users = newUser;
    }

    
    public void UpdateBillsList(ArrayList<UtilityBillsPayment>newBillslist) {
        billsList = newBillslist;
    }
    public ArrayList<User>  GetUserArray(){
        return Users;
    }
    public ArrayList<UtilityBillsPayment> GetBillsList(){
        return billsList;
    }
    
    public UtilityBillsPayment[] GetBills(String type) {
        ArrayList<UtilityBillsPayment> filteredBills = new ArrayList<>();
        for (UtilityBillsPayment bill : billsList) {
            if (bill.getClass().getSimpleName().equals(type)) {
                filteredBills.add(bill);
            }
        }
        return filteredBills.toArray(new UtilityBillsPayment[0]);
    }

    
    public void RemoveBill(UtilityBillsPayment bill) {
        billsList.remove(bill);
        System.out.println("Bill removed successfully");
    }


}









































// public class Storage {
//     // private UserCreator userCreator;
//     // private User users[];
//     private BillsFactory billFactory;
//     private UtilityBillsPayment Bills[];

//     private void FillUsersList(){}

//     public UtilityBillsPayment[] GetBills(String type){
        
//     }

//     // public void AddNewUser(User user)(){};

//     public void RemoveBill (UtilityBillsPayment u){

//     } 


// }
