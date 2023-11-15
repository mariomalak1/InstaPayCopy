public class Wallet {
        public double Balance;
        private WalletProvider walletProvider;

        public void SetBalance(double Balance){
            this.Balance = Balance;
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
        
         public void AddWalletProvider(WalletProvider walletProvider){
             this.walletProvider = walletProvider;
         }
         public WalletProvider GetWalletProvider(){
             return this.walletProvider;
         }
    }
    
