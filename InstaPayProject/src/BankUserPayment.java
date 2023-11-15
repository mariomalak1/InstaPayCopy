public class BankUserPayment extends Payment {
    private BankApiServices bankApiServices = new BankApiServices();
    private BankUser bankUser = new BankUser();
    public BankUserPayment(BankUser bankUser){
        this.bankUser=bankUser;
    }
    @Override
    public double PayBills(){
        bankApiServices.DecrementBalance(ConsumptionCost,bankUser.GetBankAccount());
        return bankUser.GetBankAccount().GetBalance();
    }
}
