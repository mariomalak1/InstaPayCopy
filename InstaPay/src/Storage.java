import java.util.ArrayList;

public class Storage {
    private BillsFactory billFactory;
    private ArrayList<UtilityBillsPayment> billsList;
    private UserFactory userFactory;
    private ArrayList<User> Users;
    


    public void UpdateUsersList(ArrayList<User>newUser) {
        Users = newUser;
    }

    
    public void UpdateBillsList(ArrayList<UtilityBillsPayment>newBillslist) {
        billsList = newBillslist;
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
