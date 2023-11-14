public class RegestrationServiceFactory {
    public RegestrationService CreateRegestrationType(String type){
        if(type.equals("1")){
            return new WalletUserRegestration(); 
        }
        else if (type.equals("2")){
            return new BankUserRegetration(); 
        }
        else{
            return null;
        }
    }
}
