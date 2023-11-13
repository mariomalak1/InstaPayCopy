public class Wallet {
    public class BankAccount {
        public String MobNum;
        public double Balance;
        //public WallerProvider walletProvider;     

        public void SetMobNum(String MobNum){
            this.MobNum = MobNum;
        }
        public void SetBalance(double Balance){
            this.Balance = Balance;
        }
        public String GetMobNum(){
            return MobNum;
        }
        public double GetBalance(){
            return Balance;
        }
        public void IncrementBalance(Double Amount){
            Balance +=Amount;
        }
        public void DecrementBalance(Double Amount){
            Balance -=Amount;
        }
        // public void AddWalletProvider(WallerProvider walletProvider){
        //     this.WallerProvider = walletProvider;
        // }
        // public WalletProvider GetWalletProvider(){
        //     return this.walletProvider
        // }
    }
    
}
