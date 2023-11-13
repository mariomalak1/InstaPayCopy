public class BankAccount {
    private String AccNumber;
    private String MobNum;
    private double Balance;
    private String BankName;

    public void SetAccNum(String AccNumber){
        this.AccNumber = AccNumber;
    }
    public void SetMobNum(String MobNum){
        this.MobNum = MobNum;
    }
    public void SetBalance(double Balance){
        this.Balance = Balance;
    }
    public void SetBankName(String bankName){
        this.BankName = bankName;
    }
    public String GetAccNum(){
        return AccNumber;
    }
    public String GetMobNum(){
        return MobNum;
    }
    public String GetBankName(){
        return BankName;
    }
    public double GetBalance(){
        return Balance;
    }
}
