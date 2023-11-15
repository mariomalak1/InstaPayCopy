import java.util.ArrayList;

public class InstaPayTransference extends Transference{

    @Override
    public boolean Transfer(String WalletProviderType) {
        return false;
    }

    @Override
    public User checkReceiverExist(String Email, ArrayList<User> users,String UserType) {
        for (User UserIteration : users){
                if(UserIteration.GetEmail().equals(Email))
                    return UserIteration;
        }
        return null;
    }
}
