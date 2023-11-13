public class RegestrationServiceFactory {
    public RegestrationService CreateRegestrationType(String type){
        if(type.equals("WalletUserRegestration")){
            return new WalletUserRegestration(); 
        }
        else if(type.equals("BankUserRegetration")){
            return new BankUserRegetration(); 
        }
        else{
            return null;
        }
    }
}
