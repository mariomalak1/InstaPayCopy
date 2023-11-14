public class BankUser extends User {
    private BankAccount bankAccount;
    //private Transference transference;

    public BankUser(){
        SetType();
    }
    public void SetBankAccount(BankAccount bankAcc){
        this.bankAccount = bankAcc;
    }

    public BankAccount GetBankAccount(){
        return this.bankAccount;
    }
    @Override
    public void SetType(){
        this.Type = "BankUser";
    }
}
