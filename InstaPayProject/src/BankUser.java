public class BankUser extends User {
    private BankAccount bankAccount = new BankAccount();
    //private Transference transference;

    public BankUser(){
        SetType();
    }

    public BankUser(String username,String pass,String mail,String phone,double balance,String bankname,String accNum){
        super(username , pass,mail,phone);
        this.bankAccount.SetBalance(balance);
        this.bankAccount.SetBankName(bankname);
        this.bankAccount.SetAccNum(accNum);
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

    @Override
    public double GetBalance() {
        return bankAccount.GetBalance();
    }

}
