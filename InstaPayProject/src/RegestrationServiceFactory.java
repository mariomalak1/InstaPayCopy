public class RegestrationServiceFactory {
    public RegestrationService CreateRegestrationType(String type){
        if(type.equals("1") || type.equals("")){
            return new BankUserRegetration(); 
        }
        else if (type.equals("2")){
            return new WalletUserRegestration(); 
        }
        else{
            return null;
        }
    }
}
