public class UserFactory {
    public User createUser(String type){
        if(type.equals("BankUser")){
            return new BankUser();
        }
        else if(type.equals("WalletUser")){
            return new WalletUser();
        }
        else{
            return null;
        }
    }
}
