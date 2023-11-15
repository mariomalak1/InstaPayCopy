public class ElectronicPayment extends WalletProvider{
    public  ElectronicPayment(){
        SetType();
    }
    @Override
    public boolean checkWalletExist(String WalletProviderName, String PhoneNum , String UserType) {
        System.out.println("The Electronic payment Wallet provider: " + WalletProviderName + " is confirmed that it has a wallet linked with phone number " + PhoneNum);        return true;
    }
    @Override
    public boolean checkReceiverExist(String AccNum){
        return true;
    }

    @Override public void DecrementBalance(double Amount , Wallet wallet){
        if(wallet.GetBalance()<Amount){
            System.out.println("Not enough balance");
        }
        else{
            wallet.SetBalance(wallet.GetBalance()-Amount);
        }
    }
    @Override public void IncrementBalance(double Amount , Wallet wallet){
        if(wallet.GetBalance()<Amount){
            System.out.println("Not enough balance");
        }
        else{
            wallet.SetBalance(wallet.GetBalance()+Amount);
        }
    }
    @Override public void SetType(){
        this.Type = "ElectronicPayment";
    }
}
