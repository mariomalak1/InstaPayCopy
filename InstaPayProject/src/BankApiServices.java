public class BankApiServices {
    public boolean VerifyCustomerData(String accountNumber, String mobileNumber , String BankName){
        System.out.println("Account number " + accountNumber + " which is linked to the phone number "  + mobileNumber+"in "+BankName  + "Is exist");
        return true;
    }

    public void IncrementBalance(double Amount , BankAccount bankAccount){
        bankAccount.SetBalance(bankAccount.GetBalance()+Amount);
    }

    public void DecrementBalance(double Amount , BankAccount bankAccount){
        bankAccount.SetBalance(bankAccount.GetBalance()-Amount);
    }
}
