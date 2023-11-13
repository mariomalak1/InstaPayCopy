public class BankUser extends User {
    private BankAccount bankAccount;
    //private Transference transference;

    public void SetBankAccount(BankAccount bankAcc){
        this.bankAccount = bankAcc;
    }

    public BankAccount GetBankAccount(){
        return this.bankAccount;
    }
}
